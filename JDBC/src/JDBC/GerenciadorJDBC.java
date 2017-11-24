package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenciadorJDBC {
	interfaceBanco banco=new SqlServer();
	private Connection conn=null;
	private PreparedStatement  pstm=null;
	private String sql="";
	
	public void startBank() throws SQLException{
		conn=DriverManager.getConnection(banco.driver());
	}
	
	public ArrayList select(String coluna,String tabela, String condicao) throws SQLException{
		this.sql=banco.sqlSelect(coluna, tabela, condicao);
		return buscarNoBanco(sql);
	}
	
	public ArrayList select(String coluna,String tabela) throws SQLException{
		this.sql=banco.sqlSelect(coluna, tabela);
		return buscarNoBanco(sql);
	}
	
	public void insert(String tabela, String valores) throws SQLException{
		this.sql=banco.sqlInsert(tabela, valores);
		EntradaNoBanco(sql);
	}
	
	public void Update(String tabela, String values, String condicao) throws SQLException{
		this.sql=banco.sqlUpdate(tabela, values, condicao);
		EntradaNoBanco(sql);
	}
	
	public void delete(String tabela, String condicao) throws SQLException{
		this.sql=banco.sqlDelete(tabela, condicao);
		EntradaNoBanco(sql);
	}
	
	public void delete(String tabela) throws SQLException{
		this.sql=banco.sqlDelete(tabela);
		EntradaNoBanco(sql);
	}
	
	
	public boolean closeConnection() throws SQLException{
		conn.close();
		if(conn.isClosed()){
			return true;
		}
		return false;
	}
	
	private ArrayList buscarNoBanco(String sql) throws SQLException{
		pstm=conn.prepareStatement(sql);
		int amountColumn;
		ArrayList funcionarios=new ArrayList();
		ArrayList funcionario=null;
		try {
			ResultSet result=pstm.executeQuery();
			amountColumn=result.getMetaData().getColumnCount();
			while(result.next()){
				funcionario=new ArrayList();
				for(int i=1;i<=amountColumn;i++){
					funcionario.add(result.getString(i));
				}
				funcionarios.add(funcionario);
				System.out.println(funcionario.toString());
			}
			
		} catch (SQLException e) { 
			System.out.println("execulteQuery");
			e.printStackTrace();
		}
		return funcionario;
	}
	
	public void EntradaNoBanco(String Sql) throws SQLException{
		pstm=conn.prepareStatement(sql);
		pstm.execute();
	}
}

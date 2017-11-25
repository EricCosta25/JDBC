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
	
	public boolean startBank(){
		try {
			conn=DriverManager.getConnection(banco.driver());
			return true;
		} catch (SQLException e) {
			return false;
			//e.printStackTrace();
		}
		
	}
	
	public ArrayList select(String coluna,String tabela, String condicao) throws SQLException{
		this.sql=banco.sqlSelect(coluna, tabela, condicao);
		return buscarNoBanco(sql);
	}
	
	public ArrayList select(String coluna,String tabela) throws SQLException{
		this.sql=banco.sqlSelect(coluna, tabela);
		return buscarNoBanco(sql);
	}
	
	public boolean insert(String tabela, String valores) throws SQLException{
		this.sql=banco.sqlInsert(tabela, valores);
		return EntradaNoBanco(sql);
	}
	
	public boolean Update(String tabela, String values, String condicao) throws SQLException{
		this.sql=banco.sqlUpdate(tabela, values, condicao);
		return EntradaNoBanco(sql);
	}
	
	public boolean delete(String tabela, String condicao) throws SQLException{
		this.sql=banco.sqlDelete(tabela, condicao);
		return EntradaNoBanco(sql);
	}
	
	public boolean deleteTabela(String tabela) throws SQLException{
		this.sql=banco.sqlDelete(tabela);
		return EntradaNoBanco(sql);
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
			return funcionarios=new ArrayList();
		}
		return funcionarios;
	}
	
	public boolean removeTools(String coluna,String tabela,String condicao) {
		this.sql=banco.sqlSelect(coluna, tabela, condicao);
		try {
			pstm=conn.prepareStatement(sql);
			String r="";
			ResultSet result=pstm.executeQuery();
			while(result.next()){
				r=result.getString(1);
				delete(tabela, coluna+"="+r);
			}
			return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean EntradaNoBanco(String Sql){
		try {
			pstm=conn.prepareStatement(sql);
			pstm.execute();
			return true;
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		//
		
	}
	
}

package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class bancoSqlServe {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static String dbUrl="jdbc:sqlserver://localhost\\MSSQLSERVER";	
	private static String user= "eric";
	private static String pass="05061991";
	private static String sql;
	
	public static String driver() {
		String dbUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER";			  	
		String user = "eric";
		String pass = "05061991";
		return dbUrl+";user="+user+";password="+pass;
	}
		
	public String driver(String dbUrl, String user, String pass){
		this.dbUrl=dbUrl;
		this.user=user;
		this.pass=pass;
		return dbUrl+";user="+user+";password="+pass;
	}
	
	
	public static void iniciarBanco() {
			try {
				conn=DriverManager.getConnection(dbUrl, user , pass);
				pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	

	public static ArrayList select() {
		int amountColumn;
		ArrayList funcionarios=new ArrayList();
		ArrayList funcionario=null;
		try {
			ResultSet result=pstmt.executeQuery();
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
	

	
	public static void main(String [] args) throws SQLException{
		/*sql="SELECT * FROM SCP..Cliente";
		driver();
		iniciarBanco();
		select();*/
		GerenciadorJDBC jdbc=new GerenciadorJDBC();
		jdbc.startBank();
		jdbc.select("*", "SCP..Cliente");
		
	}
	
	
	
	
}


//select coluna from tabela where condição
//insert into table values (valueColuna)
//update tabela set conjuntoColunaValores  where condição
//delete from tabela where condição

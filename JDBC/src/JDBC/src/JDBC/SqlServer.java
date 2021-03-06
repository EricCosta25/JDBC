package JDBC;

public class SqlServer implements interfaceBanco{
	private String dbUrl;
	private String user;
	private String pass;
	private String sql;

	@Override
	public String driver() {
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
	
	@Override
	public String sqlSelect(String coluna,String tabela,String condicao) {
		return "select "+ coluna +" from "+tabela +" where " + condicao;
	}
	
	@Override
	public String sqlSelect(String coluna,String tabela) {
		return "select "+ coluna +" from "+tabela;
	}

	@Override
	public String sqlInsert(String table, String valores) {
		return "insert into " + table + " values (" + valores + ")";
	}

	@Override
	public String sqlUpdate(String tabela,String values, String condicao) {
		return "Update "+tabela+" set " + values + "where " + condicao;
	}

	@Override
	public String sqlDelete(String tabela, String condicao) {
		return "delete from " + tabela + " where " + condicao;
	}
	
	@Override
	public String sqlDelete(String tabela) {
		return "delete from " + tabela;
	}
}

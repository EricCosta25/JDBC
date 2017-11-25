package JDBC;
import java.util.ArrayList;

public interface interfaceBanco {
	public String driver();
	//public String sqlSelect();
	public String sqlSelect(String coluna, String tabela, String condicao);
	public String sqlSelect(String coluna, String tabela);
	//public String sqlInsert();
	public String sqlInsert(String table, String valores);
	//public String sqlUpdate();
	public String sqlUpdate(String tabela, String values, String condicao);
	//public String sqldelete();
	public String sqlDelete(String tabela, String condicao);
	public String sqlDelete(String tabela);
	
	
}

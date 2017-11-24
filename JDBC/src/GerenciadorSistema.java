import java.sql.SQLException;

import JDBC.GerenciadorJDBC;

public class GerenciadorSistema {
	GerenciadorJDBC jdbc=new GerenciadorJDBC();
	
	public GerenciadorSistema() throws SQLException{
		jdbc.startBank();
	}
	
	public void cadastrarFun(Funcionario f) throws SQLException{
		String value="'"+f.getMatricula()+"','"+f.getNome()+"','"+f.+"','"+f.getCargo()+"','"+f.getSalario()+"','"+f.getTelefone();
		jdbc.insert("SCP..Pais",value);
	}
	public void editarFun(Funcionario f) throws SQLException{
		String set="matricula='"+f.getMatricula()+"', nome='"+f.getNome()+"', idade='"+f.getIdade()+"', cargo='"+f.getCargo()+"', salario='"+f.getSalario()+"', telefone='"+f.getTelefone()+"'";
		jdbc.Update("SCP..", set,"matricula='"+f.getMatricula()+"'" );
	}
	public void listarFun() throws SQLException{
		jdbc.select("*", "SCP..Cliente");
	}
	public void pesquisarFun(int matricula) throws SQLException{
		jdbc.select("*", "SCP..Cliente","codigo='"+matricula+"'");
	}
	public void removerFun(int matricula) throws SQLException{
		jdbc.delete("SCP..Pais","matricula='"+matricula+"'");
	}
	public void cadastrarEmpresa(Empresa e) throws SQLException{
		String value="'"+e.getCnpj()+"','"+e.getNome()+"','"+e.getEndereco()+"','"+e.getTelefone();
		jdbc.insert("SCP..Pais",value);
	}
	public void editarEmpresa(Empresa e) throws SQLException{
		String set="matricula='"+e.getCnpj()+"', nome='"+e.getNome()+"', telefone='"+e.getTelefone()+"'";
		jdbc.Update("SCP..", set,"cnpj='"+e.getCnpj()+"'" );
	}
	public void listarEmpresa() throws SQLException{
		jdbc.select("*", "SCP..Cliente");
	}
	public void pesquisarEmpresa(int cnpj) throws SQLException{
		jdbc.select("*", "SCP..Cliente","codigo='"+cnpj+"'");	
	}
	public void removerEmpresa(int cnpj) throws SQLException{
		jdbc.delete("SCP..Pais","cnpj='"+cnpj+"'");
	}
	public static void main(String [] args) throws SQLException{
		GerenciadorSistema GS=new GerenciadorSistema();
		GS.pesquisarFun(5);
		//GS.cadastrarEmpresa(new Empresa());
		//GS.removerEmpresa(0);
	}
	

}

//cadastrar fun
//editar fun
//listar todos fun
//pesquisar fun(matricula)
//remover fun()
//editar empresa


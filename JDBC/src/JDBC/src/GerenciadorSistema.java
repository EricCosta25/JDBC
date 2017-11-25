import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.GerenciadorJDBC;

public class GerenciadorSistema {
	GerenciadorJDBC jdbc=new GerenciadorJDBC();
	
	public GerenciadorSistema() throws SQLException{
		jdbc.startBank();
	}
	
	public boolean startConnection(){
		return jdbc.startBank();
	}
	
	public boolean cadastrarFun(Funcionario f) throws SQLException{
		String value=f.getMatricula()+",'"+f.getNome()+"',"+f.getCodEmpresa()+",'"+f.getCargo()+"',"+f.getSalario()+",'"+f.getTelefone()+"'";
		return jdbc.insert("Empresas..Funcionario",value);
	}
	
	public boolean editarFun(Funcionario f) throws SQLException{
		String set="matricula="+f.getMatricula()+", nome='"+f.getNome()+"', codEmpresa="+f.getCodEmpresa()+", cargo='"+f.getCargo()+"', salario="+f.getSalario()+", telefone='"+f.getTelefone()+"'";
		if(pesquisarFun(f.getMatricula()).size()>0){
			return jdbc.Update("Empresas..Funcionario", set,"matricula="+f.getMatricula());
		}
		return false;
	}
	
	public ArrayList listarFun(int cnpj) throws SQLException{
		return jdbc.select("*", "Empresas..Funcionario","codEmpresa="+cnpj);
	}
	
	public ArrayList pesquisarFun(int matricula) throws SQLException{
		return jdbc.select("*", "Empresas..Funcionario","matricula="+matricula);
	}
	
	public boolean removerFun(int matricula) throws SQLException{
		return jdbc.delete("Empresas..Funcionario","matricula="+matricula);
	}
	
	public boolean cadastrarEmpresa(Empresa e) throws SQLException{
		String value=e.getCnpj()+",'"+e.getNome()+"','"+e.getEndereco()+"','"+e.getTelefone()+"'";
		return jdbc.insert("Empresas..Empresa",value);
	}
	
	public boolean editarEmpresa(Empresa e) throws SQLException{
		String set="cnpj="+e.getCnpj()+", nome='"+e.getNome()+"', endereco='"+e.getEndereco()+"', telefone='"+e.getTelefone()+"'";
		if(pesquisarEmpresa(e.getCnpj()).size()>0){
			return jdbc.Update("Empresas..Empresa", set,"cnpj="+e.getCnpj());
		}
		return false;
	}
	
	public ArrayList listarEmpresa() throws SQLException{
		return jdbc.select("*", "Empresas..Empresa");
	}
	
	public ArrayList pesquisarEmpresa(int cnpj) throws SQLException{
		return jdbc.select("*", "Empresas..Empresa","cnpj="+cnpj);	
	}
	
	public boolean removerEmpresa(int cnpj) throws SQLException{
		boolean removeTolls=jdbc.removeTools("matricula","Empresas..Funcionario","codEmpresa="+cnpj);
		boolean delete=jdbc.delete("Empresas..Empresa","cnpj="+cnpj);
		if(removeTolls && delete){
			return true;
		}
		return false;
		
	}
	
	public boolean limpaTabelaEmpresa() throws SQLException{
		return jdbc.deleteTabela("Empresas..Empresa");
	}
	
	public boolean limpaTabelaFuncionario() throws SQLException{
		return jdbc.deleteTabela("Empresas..Funcionario");
	}
	
}

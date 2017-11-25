import java.sql.SQLException;

public class principal {

	public static void main(String[] args) throws SQLException {
		GerenciadorSistema GS=new GerenciadorSistema();
		//GS.pesquisarFun(2);
		//GS.listarFun(2);
		//GS.listarEmpresa();
		//GS.pesquisarEmpresa(1/);
		Empresa e=new Empresa(4,"hs","rua cheia","999988880");
		Empresa e1=new Empresa(5,"hs","rua cheia","999988880");
		//GS.cadastrarEmpresa(e);
		//GS.editarEmpresa(e);
		//GS.removerEmpresa(1);
		Funcionario f=new Funcionario(1,"ana",4,"advogada",350,"343455662");
		//GS.cadastrarFun(f);
		//GS.editarFun(f);
		//GS.removerFun(4);
		f=new Funcionario(10,"maria",2,"medica",350,"222255");
		//GS.limpaTabelaFuncionario();
		System.out.println(GS.editarEmpresa(e1));
	}

}


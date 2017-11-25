import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class GerenciadorSistemaTest {
	GerenciadorSistema GS;
	Empresa e,e1,e2,e3;
	Funcionario f,f1,f2,f3,f4;
	
	@Before
	public void setUp() throws Exception {
		GS=new GerenciadorSistema();
		
		e=new Empresa(4,"hs","rua 1","999988880");
		e1=new Empresa(3,"hs","rua 2","999988880");
		e2=new Empresa(1,"hs","rua 3","999988880");
		e3=new Empresa(1,"hs","rua 4","9999888");
		
		f=new Funcionario(1,"ana",1,"advogada",350,"341111662");
		f1=new Funcionario(2,"maria",2,"medica",300,"222255662");
		f2=new Funcionario(3,"francisco",3,"engenheiro",200,"343450000");
		f3=new Funcionario(4,"dani",1,"vendedor",200,"343450000");
		f4=new Funcionario(4,"romero",4,"lojista",200,"343450000");
	}

	@Test
	public void testStartConnection() {
		assertTrue(GS.startConnection());
	}
	
	@Test
	public void testCadastrarEmpresa() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		assertTrue(GS.cadastrarEmpresa(e));
		assertTrue(GS.cadastrarEmpresa(e1));
		assertTrue(GS.cadastrarEmpresa(e2));
		
		assertFalse(GS.cadastrarEmpresa(e3));
	}

	@Test
	public void testEditarEmpresa() throws SQLException {
		e.setNome("HS");
		e1.setNome("SA");
		e2.setNome("CAA");
		e3.setNome("DEA");
		assertTrue(GS.editarEmpresa(e));
		assertTrue(GS.editarEmpresa(e1));
		assertTrue(GS.editarEmpresa(e2));
	}

	@Test
	public void testListarEmpresa() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		assertEquals(GS.listarEmpresa().size(),3);
	}

	@Test
	public void testPesquisarEmpresa() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		
		ArrayList empresa= (ArrayList) GS.pesquisarEmpresa(1).get(0);
		assertEquals(empresa.get(1),"hs");
		assertEquals(empresa.get(2),"rua 3");
	}

	@Test
	public void testRemoverEmpresa() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		assertEquals(GS.pesquisarEmpresa(e.getCnpj()).size(),1);
		assertTrue(GS.removerEmpresa(e1.getCnpj()));
		assertEquals(GS.pesquisarEmpresa(e1.getCnpj()).size(),0);
	}
	
	@Test
	public void testCadastrarFun() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		assertTrue(GS.cadastrarFun(f));
		assertTrue(GS.cadastrarFun(f2));
		assertTrue(GS.cadastrarFun(f3));
		
		assertFalse(GS.cadastrarFun(f1));
		assertFalse(GS.cadastrarFun(f4));
	}
	
	@Test
	public void testEditarFun() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		f.setSalario(400);
		f1.setSalario(350);
		f2.setSalario(200);
		f3.setSalario(200);
		assertTrue(GS.editarFun(f));
		assertTrue(GS.editarFun(f2));
		assertTrue(GS.editarFun(f3));
	
	}

	@Test
	public void testListarFun() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		assertEquals(GS.listarFun(1).size(),2);
		assertEquals(GS.listarFun(2).size(),0);
		assertEquals(GS.listarFun(3).size(),1);
		assertEquals(GS.listarFun(4).size(),0);
	}

	@Test
	public void testPesquisarFun() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		assertEquals(GS.pesquisarFun(f.getMatricula()).size(),1);
		assertNotNull(GS.pesquisarFun(f.getMatricula()));
	}

	@Test
	public void testRemoverFun() throws SQLException {
		GS.limpaTabelaFuncionario();
		GS.limpaTabelaEmpresa();
		testCadastrarEmpresa();
		testCadastrarFun();
		assertEquals(GS.pesquisarFun(f2.getMatricula()).size(),1);
		assertTrue(GS.removerFun(f2.getMatricula()));
		assertEquals(GS.pesquisarFun(f2.getMatricula()).size(),0);
		
	}

}

import java.util.ArrayList;

public class Empresa {
	private int cnpj;
	private String nome;
	private String endereco;
	private String telefone;
	private ArrayList<Funcionario>funcionarios;
	
	public Empresa(int cnpj, String nome, String endereco, String fone) {
		this.cnpj=cnpj;
		this.nome=nome;
		this.endereco=endereco;
		this.telefone=fone;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}

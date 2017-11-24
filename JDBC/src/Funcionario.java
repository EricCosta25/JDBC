public class Funcionario {
	private int matricula;
	private String nome;
	private int idade;
	private String cargo;
	private float salario;
	private String telefone;
	
	Funcionario(int matricula, String nome, int idade,String cargo, float salario){
		this.matricula=matricula;
		this.nome=nome;
		this.idade=idade;
		this.cargo=cargo;
		this.salario=salario;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}

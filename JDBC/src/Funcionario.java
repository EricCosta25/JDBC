public class Funcionario {
	private int matricula;
	private String nome;
	private int codEmpresa;
	private String cargo;
	private float salario;
	private String telefone;
	
	Funcionario(int matricula, String nome, int codEmpresa, String cargo, float salario){
		this.matricula=matricula;
		this.nome=nome;
		this.codEmpresa=codEmpresa;
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
	public int getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
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


public abstract class Servico {
	protected String cidadeServico;
	protected Funcionario funcionario;
	protected String nomeServico;
	protected Pet pet;
	
	public String getCidade() {
		return cidadeServico;
	}
	
	public void setCidade(String cidadeServico) {
		this.cidadeServico = cidadeServico;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void serFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public String getNome() {
		return nomeServico;
	}
	
	public void setNome(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public void serPet(Pet pet) {
		this.pet = pet;
	}
	
}
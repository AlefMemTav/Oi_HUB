
public abstract class Servico {
	protected String cidadeServico;
	protected Funcionario funcionario;
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
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}
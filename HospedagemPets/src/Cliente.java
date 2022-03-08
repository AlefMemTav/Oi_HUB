
public class Cliente extends Usuario {
	private String cidadeCliente;
	private Pet pet;

	public Cliente(Pet p) {
		pet = p;
	}
	
	public String getCidade() {
		return cidadeCliente;
	}
	
	public void setCidade(String cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
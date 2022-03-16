package Modelo;

public class Cliente extends Usuario {
	private String cidadeCliente;
	private Pet pet;
	
	public Cliente(String e, String n, String s, int t) {
		email = e;
		nome = n;
		senha = s;
		telefone = t;
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
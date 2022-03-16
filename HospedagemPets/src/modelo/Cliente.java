package modelo;

public class Cliente extends Usuario {
	//Declarações
	private String cidadeCliente;
	private Pet pet;

	//Herança explicita de Usuario
	public Cliente() {
		super();
	}
	//Sobrecarga de Cliente
	public Cliente(String e, String n, String s, int t, String c, Pet p) {
		email = e;
		nome = n;
		senha = s;
		telefone = t;
		cidadeCliente = c;
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
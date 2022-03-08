
public abstract class Usuario {
	protected String email;
	protected String nome;
	protected String senha;
	protected int telefone; 

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
			return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getsenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	//Metodo que verifica o login
	public boolean login(String emailU, String senhaU) {
		if(email.equals(emailU) && senha.equals(senhaU)) {
			return true;
		}else {
			return false;
		}
	}
}
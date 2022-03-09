
public class Pet {
	private String castramento;
	private String especie;
	private String genero;
	private String raca;
	private double tamanho;

	public Pet(String c, String e, String g, String r, double t) {
		castramento = c;
		especie = e;
		genero = g;
		raca = r;
		tamanho = t;
	}
	
	public String getCastramento() {
		return castramento;
	}
	
	public void setCastramento(String castramento) {
		this.castramento = castramento;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getRacao() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public double getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
}
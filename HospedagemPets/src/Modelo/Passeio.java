package Modelo;
import java.util.Date;
public class Passeio extends Servico {
	private String comportamentoPet;
	private Date dataPasseio;
	private int horaPasseio;
	private String enderecoPasseio;
	
	public String getComportamento() {
		return comportamentoPet;
	}
	
	public void setComportamento(String comportamentoPet) {
		this.comportamentoPet = comportamentoPet;
	}
	
	public Date getDataPasseio() {
		return dataPasseio;
	}
	
	public void setDataPasseio(Date dataPasseio) {
		this.dataPasseio = dataPasseio;
	}
	
	public int getHoraPasseio() {
		return horaPasseio;
	}
	
	public void setHoraPasseio(int horaPasseio) {
		this.horaPasseio = horaPasseio;
	}
	
	public String getEndereco() {
		return enderecoPasseio;
	}
	
	public void setEndereco(String enderecoPasseio) {
		this.enderecoPasseio = enderecoPasseio;
	}
}
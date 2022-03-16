package modelo;
import java.util.Date;
public class Visita extends Servico {
	private Date dataVisita;
	private int horaVisita;
	private String enderecoCliente;
	
	public Date getDataVisita() {
		return dataVisita;
	}
	
	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	public int getHoraVisita() {
		return horaVisita;
	}
	
	public void setHoraVisita(int horaVisita) {
		this.horaVisita = horaVisita;
	}
	
	public String getEndereco() {
		return enderecoCliente;
	}
	
	public void setEndereco(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
}
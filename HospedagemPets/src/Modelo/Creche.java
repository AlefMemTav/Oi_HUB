package Modelo;
import java.util.Date;
public class Creche extends Servico {
	private Date dataEntrada;
	private Date dataSaida;
	private int horaEntrada;
	private int horaSaida;
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	public int getHoraEntrada() {
		return horaEntrada;
	}
	
	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	public int getHoraSaida() {
		return horaSaida;
	}
	
	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}
}
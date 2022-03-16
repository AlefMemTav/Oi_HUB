package modelo;
import java.util.Date;
public class Funcionario extends Usuario {
	private Date dataNascimento;
	private String endereco;
	private String genero;
	private String habitacao;
	private int precoServico;
	private Servico servicoOfertado;

	public Funcionario(Date d, String e, String g, String h, int p, Servico s) {
		dataNascimento = d;
		endereco = e;
		genero = g;
		habitacao = h;
		precoServico = p;
		servicoOfertado = s;
	}
	
	public Date getData() {
		return dataNascimento;
	}
	
	public void setData(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getHabitacao() {
		return habitacao;
	}
	
	public void setHabitacao(String habitacao) {
		this.habitacao = habitacao;
	}
	
	public int getPreco() {
		return precoServico;
	}
	
	public void setPreco(int precoServico) {
		this.precoServico = precoServico;
	}
	
	public Servico getServico() {
		return servicoOfertado;
	}
	
	public void setServico(Servico servicoOfertado) {
		this.servicoOfertado = servicoOfertado;
	}
}	
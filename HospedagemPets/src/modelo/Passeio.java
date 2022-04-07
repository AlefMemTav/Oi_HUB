
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe Passeio.
 * @author Pedro Lucas Garcia
 */
public class Passeio extends Servico {
    private int id; // Numero de passeio
    private String comportamentoPet;
    private Date dataPasseio;
    private Date horaPasseio;
    private String enderecoPasseio;
    /**
     * Contrutor completo da classe Passeio, que herda de classe Servico.
     * @param id
     * @param comportamentoPet
     * @param dataPasseio
     * @param horaPasseio
     * @param enderecoPasseio
     * @param idServico
     * @param hospitaleiro
     * @param cliente
     * @param pet 
     */
    public Passeio(int id, String comportamentoPet, String dataPasseio, String horaPasseio, String enderecoPasseio, int idServico, Hospitaleiro hospitaleiro, Cliente cliente, Pet pet) {
        super(2, hospitaleiro, cliente, pet);
        this.id = id;
        this.comportamentoPet = comportamentoPet;
        // Converter Date em String
        try {
            this.dataPasseio = new SimpleDateFormat("dd/MM/yyyy").parse(dataPasseio); // Data de entrada
        } catch (ParseException ex) {
           Logger.getLogger(Passeio.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.horaPasseio = new SimpleDateFormat("HH:mm").parse(horaPasseio); // Hora de entrada
        } catch (ParseException ex) {
           Logger.getLogger(Passeio.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.enderecoPasseio = enderecoPasseio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComportamentoPet() {
        return comportamentoPet;
    }

    public void setComportamentoPet(String comportamentoPet) {
        this.comportamentoPet = comportamentoPet;
    }

    public Date getDataPasseio() {
        return dataPasseio;
    }

    public void setDataPasseio(Date dataPasseio) {
        this.dataPasseio = dataPasseio;
    }

    public Date getHoraPasseio() {
        return horaPasseio;
    }

    public void setHoraPasseio(Date horaPasseio) {
        this.horaPasseio = horaPasseio;
    }
    
    // Data formatada
    public String getFmtdDataPasseio(){
        return new SimpleDateFormat("dd/MM/yyyy").format(dataPasseio);
    }
    // Hora formatada
    public String getFmtdHoraPasseio(){
        return new SimpleDateFormat("HH:mm").format(horaPasseio);
    }

    public String getEnderecoPasseio() {
        return enderecoPasseio;
    }

    public void setEnderecoPasseio(String enderecoPasseio) {
        this.enderecoPasseio = enderecoPasseio;
    }
    
}
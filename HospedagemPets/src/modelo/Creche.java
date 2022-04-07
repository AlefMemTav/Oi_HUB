
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe Creche.
 * @author Pedro Lucas Garcia
 */
public class Creche extends Servico {
    private int id;
    private Date dataEntrada;
    private Date dataSaida;
    private Date horaEntrada;
    private Date horaSaida;
    /**
     * Contrutor completo da classe Creche, que herda de classe Servico.
     * @param id
     * @param dataEntrada
     * @param dataSaida
     * @param horaEntrada
     * @param horaSaida
     * @param idServico
     * @param hospitaleiro
     * @param cliente
     * @param pet 
     */
    public Creche(int id, String dataEntrada, String dataSaida, String horaEntrada, String horaSaida, int idServico, Hospitaleiro hospitaleiro, Cliente cliente, Pet pet) {
        super(3, hospitaleiro, cliente, pet);
        this.id = id;
        // Converter Date em String
        try {
            this.dataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrada); // Data de entrada
        } catch (ParseException ex) {
           Logger.getLogger(Creche.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.dataSaida = new SimpleDateFormat("dd/MM/yyyy").parse(dataSaida); // Data de saida
        } catch (ParseException ex) {
           Logger.getLogger(Creche.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.horaEntrada = new SimpleDateFormat("HH:mm").parse(horaEntrada); // Hora de entrada
        } catch (ParseException ex) {
           Logger.getLogger(Creche.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.horaSaida = new SimpleDateFormat("HH:mm").parse(horaSaida); // Hora de saida
        } catch (ParseException ex) {
           Logger.getLogger(Creche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }
    
        // Data de entrada formatada
    public String getFmtdDataEntrada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(dataEntrada); // Get
    }
    // Data de saida formatada
    public String getFmtdDataSaida(){
        return new SimpleDateFormat("dd/MM/yyyy").format(dataSaida); // Get
    }
    // Hora de entrada formatada
    public String getFmtdHoraEntrada(){
        return new SimpleDateFormat("HH:mm").format(horaEntrada); // Get
    }
    // Hora de saida formatada
    public String getFmtdHoraSaida(){
        return new SimpleDateFormat("HH:mm").format(horaSaida); // Get
    }

}


package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Hospedagem
 * @author Pedro Lucas Garcia
 */
public class Hospedagem extends Servico {
    // Declaracoes
    private int id; // Numero de hospedagem
    private Date dataEntrada;
    private Date dataSaida;
    private Date horaEntrada;
    private Date horaSaida;
    /**
     * Parametros
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
    public Hospedagem(int id, String dataEntrada, String dataSaida, String horaEntrada, String horaSaida, int idServico, Hospitaleiro hospitaleiro, Cliente cliente, Pet pet) {
        super(1, hospitaleiro, cliente, pet); // idServico vale 1 para hospedagem
        this.id = id;
        // Converter Date em String
        try {
            this.dataEntrada = new SimpleDateFormat("dd/MM/yyyy").parse(dataEntrada); // Data de entrada
        } catch (ParseException ex) {
           Logger.getLogger(Hospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.dataSaida = new SimpleDateFormat("dd/MM/yyyy").parse(dataSaida); // Data de saida
        } catch (ParseException ex) {
           Logger.getLogger(Hospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.horaEntrada = new SimpleDateFormat("HH:mm").parse(horaEntrada); // Hora de entrada
        } catch (ParseException ex) {
           Logger.getLogger(Hospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Converter Date em String
        try {
            this.horaSaida = new SimpleDateFormat("HH:mm").parse(horaSaida); // Hora de saida
        } catch (ParseException ex) {
           Logger.getLogger(Hospedagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    /* Getters and setters */
    // Id
    public int getId() {
        return id; // Get
    }

    public void setId(int id) {
        this.id = id; // Set
    }
    // Data de entrada
    public Date getDataEntrada() {
        return dataEntrada; // Get
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada; // Set
    }
    // Data de saida
    public Date getDataSaida() {
        return dataSaida; // Get
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida; // Set
    }
    // Hora de entrada
    public Date getHoraEntrada() {
        return horaEntrada; // Get
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada; // Set
    }
    // Hora de saida
    public Date getHoraSaida() {
        return horaSaida; // Get
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida; // Set
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
    
    @Override
    public int getIdServico() {
        return idServico;
    }
    // idServico nao muda, mas porventura pode ser substituido por outro
    @Override
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    @Override
    public Hospitaleiro getHospitaleiro() {
        return hospitaleiro;
    }

    @Override
    public void setHospitaleiro(Hospitaleiro hospitaleiro) {
        this.hospitaleiro = hospitaleiro;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Pet getPet() {
        return pet;
    }

    @Override
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
}
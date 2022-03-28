
package controle;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.DAO.BancoDeDados;
import modelo.DAO.HospedagemDAO;
import modelo.DAO.HospitaleiroDAO;
import modelo.Hospedagem;
import modelo.Hospitaleiro;
import modelo.Pet;
import modelo.Usuario;
import visualizar.TelaHospedReservas;
import visualizar.TelaHospedagem;
import visualizar.TelaLogin;
import visualizar.TelaMenu;

/**
 * 
 * @author Pedro Lucas Garcia
 */
public class ControleHospedagem {
    // Declaracao
    private TelaLogin telaLog;
    private TelaHospedagem telaHosp;
    private TelaHospedReservas telaReservas;

    public ControleHospedagem(TelaHospedagem telaHosp) {
        this.telaHosp = telaHosp;
    }
    
    // OBS
    public void irParaMenu(){
        new TelaMenu().setVisible(true);
    }

    /**
     * Fechar a tela de hospedagem.
     */
    public void fecharHospedagem(){
        this.telaHosp.dispose();
    }
    
    /**
     * Limpar os campos de texto da tela de hospedagem.
     */
    public void limparCampo(){
        telaHosp.getjTxFieldValor().setText("-"); // Limpar os campos de texto
        telaHosp.getjTxFieldCidade().setText("-");
        telaHosp.getjFmtdDataEntrada().setText("");
        telaHosp.getjFmtdDataSaida().setText("");
        telaHosp.getjFmtdHoraEntrada().setText("");
        telaHosp.getjFmtdHoraSaida().setText("");
    }
    
    /* Hospitaleiros */
    
    /**
     * Retornar um objeto de Hospitaleiro selecinado da caixa.
     * @return Object Hospitaleiro selecionado
     */
    public Hospitaleiro obterHospitaleiro(){
        return (Hospitaleiro) telaHosp.getjCmBoxHospitaleiro().getSelectedItem();
    }
    
    /**
    * Preencher o combo box de hospitaleiros da tela de hospedagem com hospitaleiros de ArrayList.
    * @param hospitaleiros ArrayList da classe Hospitaleiro
    */
    public void preencherHospitaleiros(ArrayList<Hospitaleiro> hospitaleiros){
        javax.swing.DefaultComboBoxModel caixaHosp = (javax.swing.DefaultComboBoxModel) telaHosp.getjCmBoxHospitaleiro().getModel();
        // Percorrer hospitaleiros em ArrayList, adicionando hosp
        for(Hospitaleiro hosp : hospitaleiros){
            // Adicionar um hosp (hospitaleiro achado) ao combo box 
            caixaHosp.addElement(hosp);
        }
    }
    
    /**
    * Armazenar em hospitaleiros todos os hospitaleiros em BancoDeDados e adicionar ao combo box.
    */
    public void atualizarHospitaleiros(){
        HospitaleiroDAO hospD = new HospitaleiroDAO();
        ArrayList<Hospitaleiro> hospitaleiros = hospD.selecionarTodos();
        // Preencher o combo box de hospitaleiros com todos os hospitaleiros em BancoDeDados
        preencherHospitaleiros(hospitaleiros);
    }
 
    /* Valor */
    
    /**
     * Altera o campo de texto do valor para valor.
     * @param valor 
     */
    public void obterValor(float valor){
        telaHosp.getjTxFieldValor().setText(valor+""); // Transformar em String
    }
    
    /**
     * Atualiza o campo de texto do valor para o valor do hospeideiro, usando obterValor().
     */
    public void atualizarValor(){
        // Receber um hospitaleiro em hosp
        Hospitaleiro hosp = obterHospitaleiro();
        // Atualizar o valor no campo de texto com o preco de servico de hosp
        obterValor(hosp.getPreco());
    }
    
    /* Cidade */
    
    /**
     * 
     * @param cidade 
     */
    public void obterCidade(String cidade){
        telaHosp.getjTxFieldCidade().setText(cidade);
    }
    /**
     * 
     */
    public void atualizarCidade(){
        // Receber um hospitaleiro em hosp
        Hospitaleiro hosp = obterHospitaleiro();
        obterCidade(hosp.getCidade());
    }
    
    /* Cliente */
    
    /**
     * 
     * @return 
     */
    public Cliente obterCliente(){
        int id = 0;
        for(Usuario usuario : BancoDeDados.usuarios){
            if(telaLog.getjTxFieldUsuario().getText().equals(usuario.getEmail())){
                id = usuario.getId();
            }
        }
        
        for(Cliente cliente : BancoDeDados.clientes){
            if(id == cliente.getId()){
                return cliente;
            }
        }
        return null;
    }
    
    /* Pet */
    
    /**
     * 
     * @return 
     */
    public Pet obterPet(){
        return (Pet) telaHosp.getjCmbBoxPet().getSelectedItem();
    }
    
    /**
     * 
     * @param pets 
     */
    public void preencherPets(ArrayList<Pet> pets){
        javax.swing.DefaultComboBoxModel caixaPets = (javax.swing.DefaultComboBoxModel) telaHosp.getjCmbBoxPet().getModel();
        // Preencher uma linha do combo box adicionando pet
        for(Pet pet : pets){
            // Elemento pet a adicionar
            caixaPets.addElement(pet);
        }
    }
    
    /**
     * 
     */
    //public void atualizarPets(){
    //    PetDAO petD = new petDAO();
    //    ArrayList<Pet> pets = petD.selecionarTodos();
    //    
    //    preencherPets(pets);
    //}

    /**
     * 
     * @return 
     */
    public Hospedagem obterHospedagem(){
        // Pegar os campos digitados
        // Id da hospedagem, nao visivel para o cliente
        String idStr = telaHosp.getjTxFieldId().getText();
        int id = Integer.parseInt(idStr); // Converter idStr de String para int
        // Data de entrada e de saida
        String dataE = telaHosp.getjFmtdDataEntrada().getText();
        String dataS = telaHosp.getjFmtdDataSaida().getText();
        // Hora de entrada e de saida
        String horaE = telaHosp.getjFmtdHoraEntrada().getText();
        String horaS = telaHosp.getjFmtdHoraSaida().getText();
        // Id do tipo de servico (hospedagem), nao visivel tambem
        String idServicoStr = telaHosp.getjTxFieldId().getText();
        int idServico = Integer.parseInt(idServicoStr); 
        // Hospitaleiro
        Hospitaleiro hospitaleiro = obterHospitaleiro();
        // Cliente
        Cliente cliente = obterCliente();
        // Pet
        Pet pet = obterPet();
        
        //
        Hospedagem hospedagem = new Hospedagem(id, dataE, dataS, horaE, horaS, idServico, hospitaleiro, cliente, pet);
        return hospedagem;
    }
    
    /**
     * 
     */
    public void reservarHospedagem(){
        //
        Hospedagem hospedagem = obterHospedagem();
        //
        HospedagemDAO hospedagemD = new HospedagemDAO();
        //
        hospedagemD.inserirHospedagem(hospedagem);
    }
}
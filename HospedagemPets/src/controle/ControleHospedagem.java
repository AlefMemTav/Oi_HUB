
package controle;

import java.util.ArrayList;
import modelo.Cliente;
import controle.DAO.BancoDeDados;
import controle.DAO.HospedagemDAO;
import controle.DAO.HospitaleiroDAO;
import controle.DAO.PetDAO;
import modelo.Hospedagem;
import modelo.Hospitaleiro;
import modelo.Pet;
import modelo.Sessao;
import modelo.Usuario;
import vista.TelaHospedReservas;
import vista.TelaHospedagem;
import vista.TelaLogin;
import vista.TelaMenu;

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
        this.telaLog = new TelaLogin();
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
        telaHosp.getjFmtdDataEntrada().setText("");
        telaHosp.getjFmtdDataSaida().setText("");
        telaHosp.getjFmtdHoraEntrada().setText("");
        telaHosp.getjFmtdHoraSaida().setText("" );
    }
    
    /* Usuario */
    public static int idUsuarioLogado(){
        String usuarioLogado = Sessao.getInstancia().getUsuario().getEmail();
        
        for(Usuario user : BancoDeDados.usuarios){
            if(usuarioLogado.equals(user.getEmail())){
                int id = user.getId();
                return id;
            }
        }
        return 0;
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
        ArrayList<Hospitaleiro> hospitaleiroVerificado = new ArrayList<>();
        ArrayList<Hospitaleiro> hospitaleiros = hospD.selecionarTodos();
        int id = idUsuarioLogado();
        
        // 
        for(Hospitaleiro hospitaleiro : hospitaleiros){
            if(hospitaleiro.getId() != id){
                hospitaleiroVerificado.add(hospitaleiro);
            }
        }
        // Preencher o combo box de hospitaleiros com todos os hospitaleiros em BancoDeDados
        preencherHospitaleiros(hospitaleiroVerificado);
    }
 
    /* Valor */
    
    /**
     * Altera o campo de valor para valor.
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
     * @return cliente se bem-sucedido, null caso contrario.
     */
    public Cliente obterCliente(){
        int id = idUsuarioLogado();
        System.out.println("ControleHospedagem: " + id);

        // Percorrer os clientes em BancoDeDados, comparando o id
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
    public void atualizarPets(){
        int idCliente = idUsuarioLogado();
        PetDAO petD = new PetDAO();
        ArrayList<Pet> pets = petD.selecionarTodos();
        ArrayList<Pet> petsCliente = new ArrayList<>();
        
        for(Pet pet : pets){
            if(idCliente == pet.getIdDono()){
                petsCliente.add(pet);
            }
        }
        preencherPets(petsCliente);
    }

    /**
     * 
     * @return 
     */
    public Hospedagem obterHospedagem(){
        // Atribuir uma hospedagem
        // Id da hospedagem vale 0 para uma nova hospedagem
        // Data de entrada e de saida
        String dataE = telaHosp.getjFmtdDataEntrada().getText();
        String dataS = telaHosp.getjFmtdDataSaida().getText();
        // Hora de entrada e de saida
        String horaE = telaHosp.getjFmtdHoraEntrada().getText();
        String horaS = telaHosp.getjFmtdHoraSaida().getText();
        // Id do tipo de servico hospedagem vale 1
        int idServico = 1;
        // Hospitaleiro
        Hospitaleiro hospitaleiro = obterHospitaleiro();
        // Cliente
        Cliente cliente = obterCliente();
        // Pet
        Pet pet = obterPet();
        
        // Instanciar uma hospedagem
        Hospedagem hospedagem = new Hospedagem(0, dataE, dataS, horaE, horaS, idServico, hospitaleiro, cliente, pet);
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
        //
        limparCampo();
    }
}
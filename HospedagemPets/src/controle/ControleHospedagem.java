
package controle;

import java.util.ArrayList;
import modelo.Cliente;
import controle.DAO.BancoDeDados;
import controle.DAO.HospedagemDAO;
import controle.DAO.HospitaleiroDAO;
import controle.DAO.PetDAO;
import java.util.List;
import modelo.Hospedagem;
import modelo.Hospitaleiro;
import modelo.Pet;
import vista.TelaHospedagemReservas;
import vista.TelaHospedagem;
import vista.TelaLogin;
import vista.TelaMenu;

/**
 * Controlador da tela de hospedagem.
 * @author Pedro Lucas Garcia 
 */
public class ControleHospedagem implements InterfaceControle {
    // Declaracao
    private final TelaLogin telaLog;
    private final TelaHospedagem telaHospedagem;
    private TelaHospedagemReservas telaReservas;
    
    /**
     * 
     * @param telaHospedagem 
     */
    public ControleHospedagem(TelaHospedagem telaHospedagem) {
        this.telaHospedagem = telaHospedagem;
        this.telaLog = new TelaLogin();
    }
    
    /**
     * Abrir a tela de menu.
     */
    public void irParaMenu(){
        new TelaMenu().setVisible(true);
    }

    /**
     * Fechar a tela de hospedagem.
     */
    public void fecharHospedagem(){
        this.telaHospedagem.dispose();
    }
    
    /* Hospitaleiros */
    
    /**
     * Retornar um objeto de Hospitaleiro selecinado da caixa.
     * @return Object Hospitaleiro selecionado
     */
    public Hospitaleiro obterHospitaleiro(){
        return (Hospitaleiro) telaHospedagem.getjCmBoxHospitaleiro().getSelectedItem();
    }
    
    /**
    * Preencher o combo box de hospitaleiros na tela de hospedagem com os hospitaleiros de ArrayList.
    * @param hospitaleiros ArrayList da classe Hospitaleiro
    */
    public void preencherHospitaleiros(ArrayList<Hospitaleiro> hospitaleiros){
        javax.swing.DefaultComboBoxModel caixaHosp = (javax.swing.DefaultComboBoxModel) telaHospedagem.getjCmBoxHospitaleiro().getModel();
        // Percorrer hospitaleiros em ArrayList, adicionando hosp
        for(Hospitaleiro hosp : hospitaleiros){
            // Adicionar um hosp (hospitaleiro achado) ao combo box 
            caixaHosp.addElement(hosp);
        }
    }
    
    /**
    * Armazenar em hospitaleiros todos os presentes em BancoDeDados e atualizar o combo box.
    */
    public void atualizarHospitaleiros(){
        HospitaleiroDAO hospD = new HospitaleiroDAO();
        ArrayList<Hospitaleiro> hospitaleiroVerificado = new ArrayList<>();
        ArrayList<Hospitaleiro> hospitaleiros = hospD.selecionarTodos();
        int id = ControleLogin.idUsuarioLogado();
        
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
        telaHospedagem.getjTxFieldValor().setText(valor+""); // Transformar em String
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
     * Obter cidade de hospitaleiro do campo de texto.
     * @param cidade 
     */
    public void obterCidade(String cidade){
        telaHospedagem.getjTxFieldCidade().setText(cidade);
    }
    
    /**
     * Atualizar campo de texto da cidade do hospitaleiro.
     */
    public void atualizarCidade(){
        // Receber um hospitaleiro em hosp
        Hospitaleiro hosp = obterHospitaleiro();
        obterCidade(hosp.getCidade());
    }
    
    /* Cliente */
    
    /**
     * Obter cliente do servico.
     * @return cliente se bem-sucedido, null caso contrario.
     */
    @Override
    public Cliente obterCliente(){
        int id = ControleLogin.idUsuarioLogado();
        // TESTE
        /*        System.out.println("ControleHospedagem: " + id);*/
        // FIM TESTE
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
     * Obter o pet selecionado pelo cliente no item do combo box.
     * @return item pet selecionado.
     */
    public Pet obterPet(){
        return (Pet) telaHospedagem.getjCmbBoxPet().getSelectedItem();
    }
    
    /**
     * Procurar por pets em ArrayList e adicionar ao combo box da tela.
     * @param pets ArrayList de pet em BancoDeDados
     */
    public void preencherPets(ArrayList<Pet> pets){
        javax.swing.DefaultComboBoxModel caixaPets = (javax.swing.DefaultComboBoxModel) telaHospedagem.getjCmbBoxPet().getModel();
        // Preencher uma linha do combo box adicionando pet
        for(Pet pet : pets){
            // Adicionar pet da presente em pets ao combo box
            caixaPets.addElement(pet);
        }
    }
    
    /**
     * Atualizar combo box com os pets do cliente.
     */
    public void atualizarPets(){
        int idCliente = ControleLogin.idUsuarioLogado(); // Id do dono do pet
        PetDAO petD = new PetDAO();
        // Lista de todos os pets em BancoDeDados
        List<Pet> pets = petD.selecionarTodos(); // pets
        // Lista com os pets do cliente
        ArrayList<Pet> petsCliente = new ArrayList<>(); // petsCliente
        // Procura por pet do cliente em pets
        for(Pet pet : pets){
            if(idCliente == pet.getIdDono()){
                petsCliente.add(pet);
            }
        }
        // Preenche o combo box com petsCliente
        preencherPets(petsCliente);
        // TESTE
        /*for(Pet pete : BancoDeDados.pets){
        System.out.println("ControleHospedagem atualizarPets(): " + pete);
        }*/
        // FIM TESTE
    }
    
    /**
     * Limpar os campos de texto da tela de hospedagem.
     */
    @Override
    public void limparCampos(){
        telaHospedagem.getjFmtdDataEntrada().setText("");
        telaHospedagem.getjFmtdDataSaida().setText("");
        telaHospedagem.getjFmtdHoraEntrada().setText("");
        telaHospedagem.getjFmtdHoraSaida().setText("" );
    }
    
    /**
     * Obter da tela de hospedagem uma hospedagem de pet.
     * @return hospedagem 
     */
    @Override
    public Hospedagem obterCadastro(){
        // Data de entrada e de saida
        String dataE = telaHospedagem.getjFmtdDataEntrada().getText(); // Entrada
        String dataS = telaHospedagem.getjFmtdDataSaida().getText(); // Saida
        // Hora de entrada e de saida
        String horaE = telaHospedagem.getjFmtdHoraEntrada().getText(); // Entrada
        String horaS = telaHospedagem.getjFmtdHoraSaida().getText(); // Saida
        // Constante, Hospedagem vale 1
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
     * Adicionar a hospedagem feita pelo cliente em BancoDeDados.
     */
    @Override
    public void cadastrar(){
        // Instanciar HospedagemDAO
        HospedagemDAO hospedagemD = new HospedagemDAO();
        // Armazenar em hospedagem a hospedagem feita pelo cliente
        Hospedagem hospedagem = obterCadastro();
        // Inserir hospedagem ao BancoDeDados
        hospedagemD.inserirHospedagem(hospedagem);
        // Limpar campos de texto
        limparCampos();
    }
}

package controle;

import java.util.ArrayList;
import modelo.Cliente;
import controle.DAO.BancoDeDados;
import controle.DAO.CrecheDAO;
import controle.DAO.HospitaleiroDAO;
import controle.DAO.PetDAO;
import java.util.List;
import modelo.Creche;
import modelo.Hospitaleiro;
import modelo.Pet;
import vista.TelaCrecheReservas;
import vista.TelaCreche;
import vista.TelaLogin;
import vista.TelaMenu;

/**
 * Controlador da tela de creche.
 * @author Pedro Lucas Garcia 
 */
public class ControleCreche implements InterfaceControle {
    // Declaracao
    private final TelaLogin telaLog;
    private final TelaCreche telaCreche;
    private TelaCrecheReservas telaReservas;
    
    /**
     * 
     * @param telaCreche 
     */
    public ControleCreche(TelaCreche telaCreche) {
        this.telaCreche = telaCreche;
        this.telaLog = new TelaLogin();
    }
    
    /**
     * Abrir a tela de menu.
     */
    public void irParaMenu(){
        new TelaMenu().setVisible(true);
    }

    /**
     * Fechar a tela de creche.
     */
    public void fecharCreche(){
        this.telaCreche.dispose();
    }
    
    /* Hospitaleiros */
    
    /**
     * Retornar um objeto de Hospitaleiro selecinado da caixa.
     * @return Object Hospitaleiro selecionado
     */
    public Hospitaleiro obterHospitaleiro(){
        return (Hospitaleiro) telaCreche.getjCmBoxHospitaleiro().getSelectedItem();
    }
    
    /**
    * Preencher o combo box de hospitaleiros na tela de creche com os hospitaleiros de ArrayList.
    * @param hospitaleiros ArrayList da classe Hospitaleiro
    */
    public void preencherHospitaleiros(ArrayList<Hospitaleiro> hospitaleiros){
        javax.swing.DefaultComboBoxModel caixaHosp = (javax.swing.DefaultComboBoxModel) telaCreche.getjCmBoxHospitaleiro().getModel();
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
        telaCreche.getjTxFieldValor().setText(valor+""); // Transformar em String
    }
    
    /**
     * Atualiza o campo de texto do valor para o valor do hospedeiro, usando obterValor().
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
        telaCreche.getjTxFieldCidade().setText(cidade);
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
     * Obter cliente do servico.
     * @return cliente se bem-sucedido, null caso contrario.
     */
    @Override
    public Cliente obterCliente(){
        int id = ControleLogin.idUsuarioLogado();
        System.out.println("ControleCreche: " + id);

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
        return (Pet) telaCreche.getjCmbBoxPet().getSelectedItem();
    }
    
    /**
     * Procurar por pets em ArrayList e adicionar ao combo box da tela.
     * @param pets ArrayList de pet em BancoDeDados
     */
    public void preencherPets(ArrayList<Pet> pets){
        javax.swing.DefaultComboBoxModel caixaPets = (javax.swing.DefaultComboBoxModel) telaCreche.getjCmbBoxPet().getModel();
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
        ArrayList<Pet> pets = petD.selecionarTodos(); // pets
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
        /*        
        for(Pet pete : BancoDeDados.pets){
        System.out.println("ControleCreche atualizarPets(): " + pete);
        }
        */
        // FIM TESTE
    }
    
    /**
     * Limpar os campos de texto da tela de creche.
     */
    @Override
    public void limparCampos(){
        telaCreche.getjFmtdDataEntrada().setText("");
        telaCreche.getjFmtdDataSaida().setText("");
        telaCreche.getjFmtdHoraEntrada().setText("");
        telaCreche.getjFmtdHoraSaida().setText("" );
    }
    
    /**
     * Obter da tela de creche uma creche de pet.
     * @return creche 
     */
    @Override
    public Creche obterCadastro(){
        //int id, String dataEntrada, String dataSaida, String horaEntrada, String horaSaida, int idServico, Hospitaleiro hospitaleiro, Cliente cliente, pet
        // Data de entrada e de saida
        String dataE = telaCreche.getjFmtdDataEntrada().getText(); // Entrada
        String dataS = telaCreche.getjFmtdDataSaida().getText(); // Saida
        // Hora de entrada e de saida
        String horaE = telaCreche.getjFmtdHoraEntrada().getText(); // Entrada
        String horaS = telaCreche.getjFmtdHoraSaida().getText(); // Saida
        // Constante, Creche vale 3
        int idServico = 3;
        // Hospitaleiro
        Hospitaleiro hospitaleiro = obterHospitaleiro();
        // Cliente
        Cliente cliente = obterCliente();
        // Pet
        Pet pet = obterPet();   
        // Instanciar uma creche
        Creche creche = new Creche(0, dataE, dataS, horaE, horaS, idServico, hospitaleiro, cliente, pet);
        return creche;
    }
   
    /**
     * Adicionar a creche feita pelo cliente em BancoDeDados.
     */
    @Override
    public void cadastrar(){
        // Instanciar CrecheDAO
        CrecheDAO crecheD = new CrecheDAO();
        // Armazenar em creche a creche feita pelo cliente
        Creche creche = obterCadastro();
        // Inserir creche ao BancoDeDados
        crecheD.inserirCreche(creche);
        // Limpar campos de texto
        limparCampos();
    }
}

package controle;

import controle.DAO.BancoDeDados;
import controle.DAO.ClienteDAO;
import controle.DAO.PetDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Pet;
import vista.TelaPet;

/**
 * Controlador da tela de pet.
 * @author Pedro Lucas Garcia
 */
public class ControlePet implements InterfaceControle {
    // Declaracao
    private final TelaPet telaPet;
    
    /**
     * Construtor do controlador da tela de pet
     * @param telaPet
     */
    public ControlePet(TelaPet telaPet){
        this.telaPet = telaPet;
    }

    /* Cliente (Dono do pet) */
    
    /**
    * 
    * @return cliente se bem-sucedido, null caso contrario.
    */
    @Override
    public Cliente obterCliente(){
        int id = ControleLogin.idUsuarioLogado();

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
     * @return 
     */
    public Pet obterPet() {
        return (Pet) telaPet.getjCmbBoxPets().getSelectedItem();
    }
    
    /**
     * Procurar por pets em ArrayList e adicionar ao combo box da tela.
     * @param pets 
     */
    public void preencherPets(ArrayList<Pet> pets){
        javax.swing.DefaultComboBoxModel caixaPets = (javax.swing.DefaultComboBoxModel) telaPet.getjCmbBoxPets().getModel();
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
        int idCliente = ControleLogin.idUsuarioLogado();
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
    public List<Pet> obterPets(){
        int idCliente = ControleLogin.idUsuarioLogado();
        PetDAO petD = new PetDAO();
        ArrayList<Pet> pets = petD.selecionarTodos();
        ArrayList<Pet> petsCliente = new ArrayList<>();
        
        for(Pet pet : pets){
            if(idCliente == pet.getIdDono()){
                petsCliente.add(pet);
            }
        }
        return petsCliente;
    }
    
    /* Castrado */
    
    /**
     *
     * @return 
     */
    public String obterCastramento() {
        return (String) telaPet.getjCmbBoxCastrado().getSelectedItem();
    }
    
    /* Especie */
    
    /**
     *
     * @return 
     */
    public String obterEspecie() {
        return (String) telaPet.getjCmbBoxEspecie().getSelectedItem();
    }
    
    /* Genero */

    /**
     *
     * @return 
     */
    public String obterGenero() {
        return (String) telaPet.getjCmbBoxGenero().getSelectedItem();
    }

    /* Tamanho */
    
    /**
    *
    * @return 
    */
    public String obterTamanho() {
        return (String) telaPet.getjCmbBoxTamanho().getSelectedItem();
    }
    
    @Override
    public void limparCampos(){
        telaPet.getjTxFieldNome().setText("");
        telaPet.getjTxFieldRaca().setText("");
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Pet obterCadastro(){
        // Atribuir uma hospedagem
        // Id dono
        int idDono = ControleLogin.idUsuarioLogado();
        // Nome
        String nome = telaPet.getjTxFieldNome().getText();
        // Castramento
        String castramento = obterCastramento();
        // Especie
        String especie = obterEspecie();
        // Genero
        String genero = obterGenero();
        // Raca
        String raca = telaPet.getjTxFieldRaca().getText();
        // Tamanho
        String tamanho = obterTamanho();
        // Instanciar um pet
        Pet pet = new Pet(0, idDono, nome, castramento, especie, genero, raca, tamanho);
        return pet;
    }
    
    
    
    /**
     * Adicionar o pet registrado pelo cliente ao BancoDeDados.
     */
    @Override
    public void cadastrar(){
        // Obter id do dono
        int id = ControleLogin.idUsuarioLogado();
        // Instanciar clienteDAO
        ClienteDAO clienteD = new ClienteDAO();
        // Instanciar petDAO
        PetDAO petD = new PetDAO();
        // Instanciar em cliente o dono do pet
        Cliente cliente = obterCliente();
        // Adicionar pet no cliente
        clienteD.inserirPetNoCliente(cliente);
        // Armazenar em pet o novo pet registrado pelo cliente
        Pet pet = obterCadastro();
        // Adicionar pet em BancoDeDados
        petD.inserirPet(pet);
        // TESTE
        for(Pet pete : BancoDeDados.pets){
            System.out.println("ControlePet cadastrar(): " + pete);
        }
        // FIM TESTE
        // Limpar campos de texto
        limparCampos();
    }
}

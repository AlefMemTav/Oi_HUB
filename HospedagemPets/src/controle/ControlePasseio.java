
package controle;

import java.util.ArrayList;
import modelo.Cliente;
import controle.DAO.BancoDeDados;
import controle.DAO.HospitaleiroDAO;
import controle.DAO.PasseioDAO;
import controle.DAO.PetDAO;
import java.util.List;
import modelo.Hospitaleiro;
import modelo.Passeio;
import modelo.Pet;
import modelo.Sessao;
import modelo.Usuario;
import vista.TelaHospedagemReservas;
import vista.TelaPasseio;
import vista.TelaLogin;

/**
 * Controlador da tela de passeio.
 * @author Pedro Lucas Garcia 
 */
public class ControlePasseio implements InterfaceControle {
    // Declaracao
    private TelaLogin telaLog;
    private TelaPasseio telaPass;
    private TelaHospedagemReservas telaReservas;

    public ControlePasseio(TelaPasseio telaPass) {
        this.telaPass = telaPass;
        this.telaLog = new TelaLogin();
    }

    /**
     * Fechar a tela de passeio.
     */
    public void fecharPasseio(){
        this.telaPass.dispose();
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
        return (Hospitaleiro) telaPass.getjCmBoxHospitaleiro().getSelectedItem();
    }
    
    /**
    * Preencher o combo box de hospitaleiros da tela de hospedagem com hospitaleiros de ArrayList.
    * @param hospitaleiros ArrayList da classe Hospitaleiro
    */
    public void preencherHospitaleiros(ArrayList<Hospitaleiro> hospitaleiros){
        javax.swing.DefaultComboBoxModel caixaHosp = (javax.swing.DefaultComboBoxModel) telaPass.getjCmBoxHospitaleiro().getModel();
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
        telaPass.getjTxFieldValor().setText(valor+""); // Transformar em String
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
        telaPass.getjTxFieldCidade().setText(cidade);
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
    public Cliente obterCliente(){
        int id = idUsuarioLogado();
        // TESTE
        /*System.out.println("ControleHospedagem: " + id);*/
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
        return (Pet) telaPass.getjCmbBoxPet().getSelectedItem();
    }
    
    /**
     * Procurar por pets em ArrayList e adicionar ao combo box da tela.
     * @param pets ArrayList de pet em BancoDeDados
     */
    public void preencherPets(ArrayList<Pet> pets){
        javax.swing.DefaultComboBoxModel caixaPets = (javax.swing.DefaultComboBoxModel) telaPass.getjCmbBoxPet().getModel();
        // Preencher uma linha do combo box adicionando pet
        for(Pet pet : pets){
            // Elemento pet a adicionar
            caixaPets.addElement(pet);
        }
    }
    
    /**
     * Atualizar combo box com os pets do cliente.
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
     * Limpar os campos de texto da tela de passeio.
     */
    @Override
    public void limparCampos(){
        telaPass.getjFmtdDataPasseio().setText("");
        telaPass.getjFmtdHoraPasseio().setText("");
    }
    
    /**
     * 
     * @return hospedagem 
     */
    @Override
    public Passeio obterCadastro(){
        // Hospitaleiro
        Hospitaleiro hospitaleiro = obterHospitaleiro();
        // Id da hospedagem vale 0 para uma nova hospedagem
        String comportamento = telaPass.getjTxComportamento().getText();
        // Data
        String dataP = telaPass.getjFmtdDataPasseio().getText();
        // Hora
        String horaP = telaPass.getjFmtdHoraPasseio().getText();
        // Id do tipo de servico hospedagem vale 1
        int idServico = 2;
        // Cliente
        Cliente cliente = obterCliente();
        // Pet
        Pet pet = obterPet();
        
        // Instanciar uma hospedagem
        Passeio passeio = new Passeio(0, comportamento, dataP, horaP, "Casa", idServico, hospitaleiro, cliente, pet);
        return passeio;
    }
    
    /**
     * 
     */
    @Override
    public void cadastrar(){
        //
        Passeio passeio = obterCadastro();
        //
        PasseioDAO passeioD = new PasseioDAO();
        //
        passeioD.inserirPasseio(passeio);
        //
        limparCampos();
    }
}
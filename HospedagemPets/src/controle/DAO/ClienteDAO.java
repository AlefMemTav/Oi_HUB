
package controle.DAO;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Pet;

/**
 * Metodos de inserir, atualizar, buscar todos e excluir um cliente do banco de dados.
 * @author Pedro Lucas Garcia
 */
public class ClienteDAO {
    /**
     * Insere um cliente em BancoDeDados.
     * @param cliente
     */
    public void inserirCliente(Cliente cliente){
        BancoDeDados.clientes.add(cliente); //Insere o objeto
    }
    
    /**
     * Procura um cliente em BancoDeDados e compara com cliente. Se iguais, troca o elemento em i por cliente.
     * @param cliente
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarCliente(Cliente cliente){
        for(int i = 0; i < BancoDeDados.clientes.size(); i++) {
            if(idIguais(BancoDeDados.clientes.get(i), cliente)){
                BancoDeDados.clientes.set(i, cliente);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta um cliente em BancoDeDados buscando pelo id.
     * @param cliente
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarCliente(Cliente cliente){
        for (Cliente clienteLista : BancoDeDados.clientes) {
            if(idIguais(clienteLista, cliente)){
                BancoDeDados.clientes.remove(clienteLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encontra todos os clientes em BancoDeDados.
     * @return Retorna o Arraylist de todos os clientes.
     */
    public ArrayList<Cliente> selecionarTodos(){
        return BancoDeDados.clientes;
    }
    
    /**
     * Compara dois clientes pelo id.
     * @param cliente
     * @param clienteAComparar
     * @return Retorna true se id dos dois clientes forem iguais, false se nao forem.
     */
    private boolean idIguais(Cliente cliente, Cliente clienteAComparar) {
        return cliente.getId() ==  clienteAComparar.getId();
    }
    /* Pets do cliente */
    /**
     * Compara o id de pet ate definir maiorId recebido do banco de dados, e gera novoId.
     * @return novoId O maiorId recebido do banco de dados mais um.
     */
    private int novoPet(){
        int maiorId = 0;
        for (Pet pet : BancoDeDados.pets) {   
            int id = pet.getId();
            if(maiorId < id){
                maiorId = id;
            }
        }
        int novoId = maiorId + 1;
        return novoId;
    }
    /**
     * Insere um pet no cliente do BancoDeDados.
     * @param cliente atualizado com o novo pet.
     */
    public void inserirPetNoCliente(Cliente cliente){
        if(cliente.getPet1() != null && cliente.getPet1().getId() == 0){
            cliente.getPet1().setId(novoPet());
        }else if(cliente.getPet2() != null && cliente.getPet2().getId() == 0){
            cliente.getPet2().setId(novoPet()); 
        }else if(cliente.getPet3() != null && cliente.getPet3().getId() == 0){
            cliente.getPet3().setId(novoPet());
        }else if(cliente.getPet4() != null && cliente.getPet4().getId() == 0){
            cliente.getPet4().setId(novoPet());
        }else if(cliente.getPet5() != null && cliente.getPet5().getId() == 0){
            cliente.getPet5().setId(novoPet());
        }
    }
}
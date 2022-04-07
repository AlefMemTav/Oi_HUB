
package controle.DAO;

import java.util.ArrayList;
import java.util.List;
import modelo.Pet;

/**
 * Metodos de inserir, atualizar, buscar todos e excluir um pet do banco de dados.
 * @author Pedro Lucas Garcia
 */
public class PetDAO {
    
    /**
     * Procura um pet em BancoDeDados e compara com pet. Se iguais, troca o elemento na posicao i por pet.
     * @param pet
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarPet(Pet pet){
        for(int i = 0; i < BancoDeDados.pets.size(); i++) {
            if(idIguais(BancoDeDados.pets.get(i), pet)){
                BancoDeDados.pets.set(i, pet);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta um pet em BancoDeDados buscando pelo id.
     * @param pet
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarPet(Pet pet){
        for (Pet petLista : BancoDeDados.pets) {
            if(idIguais(petLista, pet)){
                BancoDeDados.pets.remove(petLista);
                return true;
            }
        }
        return false;
    }
    
    /**
    * Insere um pet em BancoDeDados.
    * @param pet
    */
    public void inserirPet(Pet pet){
        if(pet.getId() == 0){
            pet.setId(novoId());
            BancoDeDados.pets.add(pet); //Insere o objeto
        }
    }
    
    /**
     * Encontra todos os pets em BancoDeDados.
     * @return Retorna o Arraylist de todos os pets.
     */
    public ArrayList<Pet> selecionarTodos(){
        return BancoDeDados.pets;
    }
    
    /**
     * Compara dois pets pelo id.
     * @param pet
     * @param petAComparar
     * @return Retorna true se id dos dois pets forem iguais, false se nao forem.
     */
    private boolean idIguais(Pet pet, Pet petAComparar) {
        return pet.getId() ==  petAComparar.getId();
    }

    /**
    * Compara o id de pet ate definir maiorId recebido do banco de dados, e gera novoId.
    * @return novoId O maiorId recebido do banco de dados mais um.
    */
    private int novoId(){
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
}

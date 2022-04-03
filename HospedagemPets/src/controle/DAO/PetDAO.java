
package controle.DAO;

import java.util.ArrayList;
import modelo.Pet;

/**
 * 
 * @author Pedro Lucas Garcia
 */
public class PetDAO {
    /**
     * Insere um pet em BancoDeDados.
     * @param pet
     */
    public void inserirPet(Pet pet){
        BancoDeDados.pets.add(pet); //Insere o objeto
    }
    
    /**
     * Procura um pet em BancoDeDados e compara com pet. Se iguais, troca o elemento em i por pet.
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
}

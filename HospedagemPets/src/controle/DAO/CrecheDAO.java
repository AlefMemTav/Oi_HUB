
package controle.DAO;

import java.util.ArrayList;
import modelo.Creche;

/**
 *
 * @author Pedro Lucas Garcia
 */
public class CrecheDAO {
    /**
     * Insere uma creche em BancoDeDados.
     * @param creche
     */
    public void inserirCreche(Creche creche){
        if(creche.getId() == 0){
            creche.setId(novoId());
            BancoDeDados.creches.add(creche); //Insere o objeto
        }
    }
    
    /**
     * Procura uma creche em BancoDeDados e compara com creche. Se iguais, troca o elemento em i por creche.
     * @param creche
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarCreche(Creche creche){
        for(int i = 0; i < BancoDeDados.creches.size(); i++) {
            if(idIguais(BancoDeDados.creches.get(i), creche)){
                BancoDeDados.creches.set(i, creche);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta uma creche em BancoDeDados buscando pelo id.
     * @param creche
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarCreche(Creche creche){
        for (Creche crecheLista : BancoDeDados.creches) {
            if(idIguais(crecheLista, creche)){
                BancoDeDados.creches.remove(crecheLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encontra todas as creches em BancoDeDados.
     * @return Retorna o Arraylist de todos os creches.
     */
    public ArrayList<Creche> selecionarTodos(){
        return BancoDeDados.creches;
    }
    
    /**
     * Compara duas creches pelo id.
     * @param creche
     * @param crecheAComparar
     * @return Retorna true se id das duas creches forem iguais, false se nao forem.
     */
    private boolean idIguais(Creche creche, Creche crecheAComparar) {
        return creche.getId() ==  crecheAComparar.getId();
    }
    
    /**
     * Compara o id de creche ate definir maiorId recebido do banco de dados, e gera novoId.
     * @return novoId O maiorId recebido do banco de dados mais um.
     */
    private int novoId(){
        int maiorId = 0;
        for (Creche creche : BancoDeDados.creches) {   
            int id = creche.getId();
            if(maiorId < id){
                maiorId = id;
            }
        }
        int novoId = maiorId + 1;
        return novoId;
    }
}

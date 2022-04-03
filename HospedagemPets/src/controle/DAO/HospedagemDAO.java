
package controle.DAO;

import java.util.ArrayList;
import modelo.Hospedagem;

/**
 *
 * @author Pedro Lucas Garcia
 */
public class HospedagemDAO {
    /**
     * Insere uma hospedagem em BancoDeDados.
     * @param hospedagem
     */
    public void inserirHospedagem(Hospedagem hospedagem){
        if(hospedagem.getId() == 0){
            hospedagem.setId(novoId());
            BancoDeDados.hospedagens.add(hospedagem); //Insere o objeto
        }
    }
    
    /**
     * Procura uma hospedagem em BancoDeDados e compara com hospedagem. Se iguais, troca o elemento em i por hospedagem.
     * @param hospedagem
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarHospedagem(Hospedagem hospedagem){
        for(int i = 0; i < BancoDeDados.hospedagens.size(); i++) {
            if(idIguais(BancoDeDados.hospedagens.get(i), hospedagem)){
                BancoDeDados.hospedagens.set(i, hospedagem);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta uma hospedagem em BancoDeDados buscando pelo id.
     * @param hospedagem
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarHospedagem(Hospedagem hospedagem){
        for (Hospedagem hospedagemLista : BancoDeDados.hospedagens) {
            if(idIguais(hospedagemLista, hospedagem)){
                BancoDeDados.hospedagens.remove(hospedagemLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encontra todas as hospedagens em BancoDeDados.
     * @return Retorna o Arraylist de todos os hospedagems.
     */
    public ArrayList<Hospedagem> selecionarTodos(){
        return BancoDeDados.hospedagens;
    }
    
    /**
     * Compara duas hospedagens pelo id.
     * @param hospedagem
     * @param hospedagemAComparar
     * @return Retorna true se id das duas hospedagens forem iguais, false se nao forem.
     */
    private boolean idIguais(Hospedagem hospedagem, Hospedagem hospedagemAComparar) {
        return hospedagem.getId() ==  hospedagemAComparar.getId();
    }
    
    /**
     * Compara o id de hospedagem ate definir maiorId recebido do banco de dados, e gera novoId.
     * @return novoId O maiorId recebido do banco de dados mais um.
     */
    private int novoId(){
        int maiorId = 0;
        for (Hospedagem hospedagem : BancoDeDados.hospedagens) {   
            int id = hospedagem.getId();
            if(maiorId < id){
                maiorId = id;
            }
        }
        int novoId = maiorId + 1;
        return novoId;
    }
}
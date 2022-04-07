
package controle.DAO;

import java.util.ArrayList;
import modelo.Passeio;

/**
 * Metodos de inserir, atualizar, buscar todos e excluir um passeio do banco de dados.
 * @author Pedro Lucas Garcia
 */
public class PasseioDAO {
    /**
     * Insere uma passeio em BancoDeDados.
     * @param passeio
     */
    public void inserirPasseio(Passeio passeio){
        if(passeio.getId() == 0){
            passeio.setId(novoId());
            BancoDeDados.passeios.add(passeio); //Insere o objeto
        }
    }
    
    /**
     * Procura uma passeio em BancoDeDados e compara com passeio. Se iguais, troca o elemento em i por passeio.
     * @param passeio
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarPasseio(Passeio passeio){
        for(int i = 0; i < BancoDeDados.passeios.size(); i++) {
            if(idIguais(BancoDeDados.passeios.get(i), passeio)){
                BancoDeDados.passeios.set(i, passeio);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta uma passeio em BancoDeDados buscando pelo id.
     * @param passeio
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarPasseio(Passeio passeio){
        for (Passeio passeioLista : BancoDeDados.passeios) {
            if(idIguais(passeioLista, passeio)){
                BancoDeDados.passeios.remove(passeioLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encontra todas as passeios em BancoDeDados.
     * @return Retorna o Arraylist de todos os passeios.
     */
    public ArrayList<Passeio> selecionarTodos(){
        return BancoDeDados.passeios;
    }
    
    /**
     * Compara duas passeios pelo id.
     * @param passeio
     * @param passeioAComparar
     * @return Retorna true se id das duas passeios forem iguais, false se nao forem.
     */
    private boolean idIguais(Passeio passeio, Passeio passeioAComparar) {
        return passeio.getId() ==  passeioAComparar.getId();
    }
    
    /**
     * Compara o id de passeio ate definir maiorId recebido do banco de dados, e gera novoId.
     * @return novoId O maiorId recebido do banco de dados mais um.
     */
    private int novoId(){
        int maiorId = 0;
        for (Passeio passeio : BancoDeDados.passeios) {   
            int id = passeio.getId();
            if(maiorId < id){
                maiorId = id;
            }
        }
        int novoId = maiorId + 1;
        return novoId;
    }
}
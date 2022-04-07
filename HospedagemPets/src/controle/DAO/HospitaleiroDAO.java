
package controle.DAO;

import java.util.ArrayList;
import modelo.Hospitaleiro;

/**
 * Metodos de inserir, atualizar, buscar todos e excluir um hospitaleiro do banco de dados.
 * @author Pedro Lucas Garcia
 */
public class HospitaleiroDAO {
    /**
     * Insere um hospitaleiro em BancoDeDados.
     * @param hosp
     */
    public void inserirHospitaleiro(Hospitaleiro hosp){
        BancoDeDados.hospitaleiros.add(hosp); //Insere o objeto
    }
    
    /**
     * Procura um hospitaleiro em BancoDeDados e compara com hosp. Se iguais, troca o elemento em i por hospitaleiro.
     * @param hosp
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarHospitaleiro(Hospitaleiro hosp){
        for(int i = 0; i < BancoDeDados.hospitaleiros.size(); i++) {
            if(idIguais(BancoDeDados.hospitaleiros.get(i), hosp)){
                BancoDeDados.hospitaleiros.set(i, hosp);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta um hospitaleiro em BancoDeDados buscando pelo id.
     * @param hosp
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarHospitaleiro(Hospitaleiro hosp){
        for (Hospitaleiro hospitaleiroLista : BancoDeDados.hospitaleiros) {
            if(idIguais(hospitaleiroLista, hosp)){
                BancoDeDados.hospitaleiros.remove(hospitaleiroLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encontra todos os hospitaleiros em BancoDeDados.
     * @return Retorna o Arraylist de todos os hospitaleiros.
     */
    public ArrayList<Hospitaleiro> selecionarTodos(){
        return BancoDeDados.hospitaleiros;
    }
    
    /**
     * Compara dois hospitaleiros pelo id.
     * @param hosp
     * @param hospitaleiroAComparar
     * @return Retorna true se id dos dois hospitaleiros forem iguais, false se nao forem.
     */
    private boolean idIguais(Hospitaleiro hosp, Hospitaleiro hospitaleiroAComparar) {
        return hosp.getId() ==  hospitaleiroAComparar.getId();
    }
}

package controle;

import java.util.ArrayList;
import modelo.DAO.HospedagemDAO;
import modelo.Hospedagem;
import visualizar.TelaHospedReservas;

/**
 * Controlador da tela de reservas de hospedagem
 * @author Pedro Lucas Garcia
 */
public class ControleHospedReservas {
    // Declaracao
    private TelaHospedReservas telaReservas;
    
    // Construtor
    public ControleHospedReservas(TelaHospedReservas telaReservas) {
        this.telaReservas = telaReservas;
    }
    
    /**
    * 
    * @param hospedagens ArrayList de Hospedagem com todas as hospedagens armazenadas
    */
    public void preencherTabela(ArrayList<Hospedagem> hospedagens){
        // Instanciar a tabela das reservas de hospedagens
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        // Altera o numero de linhas da tabela a partir do zero
        TbReservas.setRowCount(0);
        // Percorrer hospedagens de ArrayList
        for(Hospedagem hospedagem : hospedagens){
            // Adicionar na TbReservas o objeto hospedagem
            TbReservas.addRow(new Object[]{
                // Linha a adicionar continu. embaixo
                hospedagem.getHospitaleiro().getNome(), hospedagem.hospitaleiro.getPreco(), hospedagem.hospitaleiro.getCidade(),
                hospedagem.getFmtdDataEntrada(), hospedagem.getFmtdDataSaida(), hospedagem.getFmtdHoraEntrada(), hospedagem.getFmtdHoraSaida()
            });
        }
    }
    
    /**
    * 
    */
    public void atualizarTabela(){
        // Instanciar hospedagemD
        HospedagemDAO hospedagemD = new HospedagemDAO();
        // Armazenar em hospedagens todas as hospedagens de BancoDeDados
        ArrayList<Hospedagem> hospedagens = hospedagemD.selecionarTodos();
        // Preencher a tabela com as hospedagens em BancoDeDados
        preencherTabela(hospedagens);
    }
}

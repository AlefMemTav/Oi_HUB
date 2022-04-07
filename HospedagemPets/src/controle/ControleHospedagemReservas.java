
package controle;

import controle.DAO.BancoDeDados;
import java.util.ArrayList;
import controle.DAO.HospedagemDAO;
import modelo.Hospedagem;
import vista.TelaHospedagemReservas;

/**
 * Controlador da tela de reservas de hospedagem.
 * @author Pedro Lucas Garcia 
 */
public class ControleHospedagemReservas implements InterfaceReservas{
    // Declaracao
    private final TelaHospedagemReservas telaReservas;
    
    // Construtor
    public ControleHospedagemReservas(TelaHospedagemReservas telaReservas) {
        this.telaReservas = telaReservas;
    }

    /**
    * Preencher a tabela com os cadastros do cliente.
    * @param hospedagens ArrayList de Hospedagem com todas as hospedagens armazenadas
    */
    public void preencherTabela(ArrayList<Hospedagem> hospedagens){
        
        // Instanciar a tabela das reservas de hospedagens
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        // Altera o numero de linhas da tabela a partir do zero
        TbReservas.setRowCount(0);
        int id = ControleLogin.idUsuarioLogado();
        // Percorrer hospedagens de ArrayList
        for(Hospedagem hospedagem : hospedagens){
            if(hospedagem.getCliente().getId() == id){
                // Adicionar na TbReservas o objeto hospedagem
                TbReservas.addRow(new Object[]{
                    // Linha a adicionar continu. embaixo
                    hospedagem.getId(), hospedagem.getHospitaleiro(), hospedagem.hospitaleiro.getPreco(), hospedagem.hospitaleiro.getCidade(),
                    hospedagem.getFmtdDataEntrada(), hospedagem.getFmtdDataSaida(), hospedagem.getFmtdHoraEntrada(), hospedagem.getFmtdHoraSaida(),
                    hospedagem.getPet()
                });
            }
        }
    }
    
    /**
    * Atualizar a tabela com os dados de BancoDeDados.
    */
    @Override
    public void atualizarTabela(){
        // Instanciar hospedagemD
        HospedagemDAO hospedagemD = new HospedagemDAO();
        // Armazenar em hospedagens todas as hospedagens de BancoDeDados
        ArrayList<Hospedagem> hospedagens = hospedagemD.selecionarTodos();
        // Preencher a tabela com as hospedagens em BancoDeDados
        preencherTabela(hospedagens);
    }
    /**
     * Remover linha selecionada pelo cliente na tabela.
     */
    @Override
    public void removerLinha(){
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        int linha = telaReservas.getjTbReservas().getSelectedRow();
        int id = (int) TbReservas.getValueAt(linha, 0);
        // Instanciar hospedagemD
        HospedagemDAO hospedagemD = new HospedagemDAO();
        if(linha >= 0){
            for(Hospedagem hospedagem : BancoDeDados.hospedagens){
                if(hospedagem.getId() == id){
                    hospedagemD.deletarHospedagem(hospedagem);
                    atualizarTabela();
                }
            }    
        }
    }
}

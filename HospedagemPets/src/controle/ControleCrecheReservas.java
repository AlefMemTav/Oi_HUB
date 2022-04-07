
package controle;

import controle.DAO.BancoDeDados;
import java.util.ArrayList;
import controle.DAO.CrecheDAO;
import modelo.Creche;
import vista.TelaCrecheReservas;

/**
 * Controlador da tela de reservas de creche.
 * @author Pedro Lucas Garcia 
 */
public class ControleCrecheReservas implements InterfaceReservas{
    // Declaracao
    private final TelaCrecheReservas telaReservas;
    
    // Construtor
    public ControleCrecheReservas(TelaCrecheReservas telaReservas) {
        this.telaReservas = telaReservas;
    }

    /**
    * Preencher a tabela com os cadastros do cliente.
    * @param creches ArrayList de Creche com todas as creches armazenadas
    */
    public void preencherTabela(ArrayList<Creche> creches){
        
        // Instanciar a tabela das reservas de creches
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        // Altera o numero de linhas da tabela a partir do zero
        TbReservas.setRowCount(0);
        int id = ControleLogin.idUsuarioLogado();
        // Percorrer creches de ArrayList
        for(Creche creche : creches){
            if(creche.getCliente().getId() == id){
                // Adicionar na TbReservas o objeto creche
                TbReservas.addRow(new Object[]{
                    // Linha a adicionar continu. embaixo
                    creche.getId(), creche.getHospitaleiro(), creche.hospitaleiro.getPreco(), creche.hospitaleiro.getCidade(),
                    creche.getFmtdDataEntrada(), creche.getFmtdDataSaida(), creche.getFmtdHoraEntrada(), creche.getFmtdHoraSaida(),
                    creche.getPet()
                });
            }
        }
    }
    
    /**
    * Atualizar a tabela com os dados de BancoDeDados.
    */
    @Override
    public void atualizarTabela(){
        // Instanciar crecheD
        CrecheDAO crecheD = new CrecheDAO();
        // Armazenar em creches todas as creches de BancoDeDados
        ArrayList<Creche> creches = crecheD.selecionarTodos();
        // Preencher a tabela com as creches em BancoDeDados
        preencherTabela(creches);
    }
    /**
     * Remover linha selecionada pelo cliente na tabela.
     */
    @Override
    public void removerLinha(){
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        int linha = telaReservas.getjTbReservas().getSelectedRow();
        int id = (int) TbReservas.getValueAt(linha, 0);
        // Instanciar crecheD
        CrecheDAO crecheD = new CrecheDAO();
        if(linha >= 0){
            for(Creche creche : BancoDeDados.creches){
                if(creche.getId() == id){
                    crecheD.deletarCreche(creche);
                    atualizarTabela();
                }
            }    
        }
    }
}
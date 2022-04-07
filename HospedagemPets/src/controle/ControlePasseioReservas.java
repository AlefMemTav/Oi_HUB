
package controle;

import controle.DAO.BancoDeDados;
import java.util.ArrayList;
import controle.DAO.PasseioDAO;
import modelo.Passeio;
import vista.TelaPasseioReservas;

/**
 * Controlador da tela de reservas de passeio.
 * @author Pedro Lucas Garcia 
 */
public class ControlePasseioReservas implements InterfaceReservas {
    // Declaracao
    private final TelaPasseioReservas telaReservas;
    
    // Construtor
    public ControlePasseioReservas(TelaPasseioReservas telaReservas) {
        this.telaReservas = telaReservas;
    }

    /**
    * Preencher a tabela com os cadastros do cliente.
    * @param passeios ArrayList de Passeio com todas os passeios armazenados
    */
    public void preencherTabela(ArrayList<Passeio> passeios){
        
        // Instanciar a tabela das reservas de passeios
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        // Altera o numero de linhas da tabela a partir do zero
        TbReservas.setRowCount(0);
        int id = ControleLogin.idUsuarioLogado();
        // Percorrer passeios de ArrayList
        for(Passeio passeio : passeios){
            if(passeio.getCliente().getId() == id){
                // Adicionar na TbReservas o objeto passeio
                TbReservas.addRow(new Object[]{
                    // Linha a adicionar continu. embaixo
                    passeio.getId(), passeio.getHospitaleiro(), passeio.hospitaleiro.getPreco(), passeio.hospitaleiro.getCidade(),
                    passeio.getFmtdDataPasseio(), passeio.getFmtdHoraPasseio(),
                    passeio.getCliente(), passeio.getPet()
                });
            }
        }
    }
    
    /**
    * Atualizar a tabela com os dados de BancoDeDados.
    */
    @Override
    public void atualizarTabela(){
        // Instanciar passeioD
        PasseioDAO passeioD = new PasseioDAO();
        // Armazenar em passeios todas as passeios de BancoDeDados
        ArrayList<Passeio> passeios = passeioD.selecionarTodos();
        // Preencher a tabela com as passeios em BancoDeDados
        preencherTabela(passeios);
    }
    /**
     * Remover linha selecionada pelo cliente na tabela.
     */
    @Override
    public void removerLinha(){
        javax.swing.table.DefaultTableModel TbReservas = (javax.swing.table.DefaultTableModel) telaReservas.getjTbReservas().getModel();
        int linha = telaReservas.getjTbReservas().getSelectedRow();
        int id = (int) TbReservas.getValueAt(linha, 0);
        // Instanciar passeioD
        PasseioDAO passeioD = new PasseioDAO();
        if(linha >= 0){
            for(Passeio passeio : BancoDeDados.passeios){
                if(passeio.getId() == id){
                    passeioD.deletarPasseio(passeio);
                    atualizarTabela();
                }
            }    
        }
    }
}


package vista;

import controle.ControleCrecheReservas;
import javax.swing.JTable;

/**
 * TelaCrecheReservas.
 * @author Pedro Lucas Garcia
 */

public class TelaCrecheReservas extends javax.swing.JFrame {
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLbFundoReservas;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTbReservas; 
    private ControleCrecheReservas controleReservas;
    /**
     * 
     */
    public TelaCrecheReservas() {
        componentes();
        // Controlador da tela de reservas
        controleReservas = new ControleCrecheReservas(this);
        //
        controleReservas.atualizarTabela();
    }
    
    @SuppressWarnings("unchecked")
    private void componentes() {
        jScrollPane = new javax.swing.JScrollPane();
        jTbReservas = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jLbFundoReservas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        setTitle("Passeios");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/vista/imagem/icone/patas_icone.png")));
        getContentPane().setLayout(null);

        jTbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Hospitaleiro", "Preço", "Endereço", "Data do passeio", "Hora do passeio", "Pet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTbReservas.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTbReservas);
        if (jTbReservas.getColumnModel().getColumnCount() > 0) {
            jTbReservas.getColumnModel().getColumn(0).setResizable(false);
            jTbReservas.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTbReservas.getColumnModel().getColumn(1).setResizable(false);
            jTbReservas.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTbReservas.getColumnModel().getColumn(2).setResizable(false);
            jTbReservas.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTbReservas.getColumnModel().getColumn(3).setResizable(false);
            jTbReservas.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTbReservas.getColumnModel().getColumn(4).setResizable(false);
            jTbReservas.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTbReservas.getColumnModel().getColumn(5).setResizable(false);
            jTbReservas.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTbReservas.getColumnModel().getColumn(6).setResizable(false);
            jTbReservas.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane);
        jScrollPane.setBounds(50, 100, 1240, 250);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(680, 600, 113, 22);

        jLbFundoReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/tired-dog-1374055.jpg"))); // NOI18N
        getContentPane().add(jLbFundoReservas);
        jLbFundoReservas.setBounds(0, 0, 1366, 768);

        pack();
        setBounds(0, 0, 1366, 768);
    }                    

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // 
        controleReservas.removerLinha();
    }                                                               
    
    /* Getters and setters */

    public JTable getjTbReservas() {
        return jTbReservas;
    }

    public void setjTbReservas(JTable jTbReservas) {
        this.jTbReservas = jTbReservas;
    }
    
}

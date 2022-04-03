
package vista;

import controle.ControleHospedReservas;
import javax.swing.JTable;

/**
 * 
 * @author Pedro Lucas Garcia
 */
public class TelaHospedReservas extends javax.swing.JFrame {
    private ControleHospedReservas controleReservas;
    /**
     * Creates new form TelaHospReservas
     */
    public TelaHospedReservas() {
        initComponents();
        // Controlador da tela de reservas
        controleReservas = new ControleHospedReservas(this);
        //
        controleReservas.atualizarTabela();
       
        setBounds(300, 300, 500, 500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTbReservas = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        getContentPane().setLayout(null);

        jTbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Hospitaleiro", "Preço", "Endereço", "Data de entrada", "Data de saída", "Hora de entrada", "Hora de saída", "Cliente TEMP", "Pet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            jTbReservas.getColumnModel().getColumn(7).setResizable(false);
            jTbReservas.getColumnModel().getColumn(7).setPreferredWidth(100);
            jTbReservas.getColumnModel().getColumn(8).setResizable(false);
            jTbReservas.getColumnModel().getColumn(8).setPreferredWidth(100);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTbReservas;
    // End of variables declaration//GEN-END:variables
    
    /* Getters and setters */
    public JTable getjTbReservas() {
        return jTbReservas;
    }

    public void setjTbReservas(JTable jTbReservas) {
        this.jTbReservas = jTbReservas;
    }
}

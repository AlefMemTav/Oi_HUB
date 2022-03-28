
package visualizar;

import controle.ControleHospedReservas;
import controle.ControleHospedagem;
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
        setBounds(300, 300, 500, 500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTbReservas = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTbReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(jTbReservas);

        getContentPane().add(jScrollPane);
        jScrollPane.setBounds(0, 80, 600, 228);

        jButtonCancelar.setText("Cancelar");
        getContentPane().add(jButtonCancelar);
        jButtonCancelar.setBounds(209, 348, 113, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents


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


package vista;

import controle.ControlePet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * TelaPet.
 * @author Pedro Lucas Garcia
 */
public class TelaPet extends javax.swing.JFrame {
    // Declaracoes
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jCmbBoxCastrado;
    private javax.swing.JComboBox<String> jCmbBoxEspecie;
    private javax.swing.JComboBox<String> jCmbBoxGenero;
    private javax.swing.JComboBox<String> jCmbBoxPets;
    private javax.swing.JComboBox<String> jCmbBoxTamanho;
    private javax.swing.JLabel jLbCastrado;
    private javax.swing.JLabel jLbEspecie;
    private javax.swing.JLabel jLbFundoPet;
    private javax.swing.JLabel jLbGenero;
    private javax.swing.JLabel jLbNome;
    private javax.swing.JLabel jLbPets;
    private javax.swing.JLabel jLbRaca;
    private javax.swing.JLabel jLbTamanho;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuVoltar;
    private javax.swing.JTextField jTxFieldNome;
    private javax.swing.JTextField jTxFieldRaca;
    private final ControlePet controlePet;
    
    public TelaPet() {
        // Controle da tela 
        controlePet = new ControlePet(this);
        // Chamar nimbus
        nimbusPet();
        // Componentes
        componentes();
        // Atualizar combo box
        this.jCmbBoxPets.removeAllItems(); // Limpar combo box
        controlePet.atualizarPets();
    }

    @SuppressWarnings("unchecked")

    private void componentes() {

        jLbPets = new javax.swing.JLabel();
        jCmbBoxPets = new javax.swing.JComboBox<>();
        jLbNome = new javax.swing.JLabel();
        jTxFieldNome = new javax.swing.JTextField();
        jLbCastrado = new javax.swing.JLabel();
        jCmbBoxCastrado = new javax.swing.JComboBox<>();
        jLbEspecie = new javax.swing.JLabel();
        jCmbBoxEspecie = new javax.swing.JComboBox<>();
        jLbGenero = new javax.swing.JLabel();
        jCmbBoxGenero = new javax.swing.JComboBox<>();
        jLbRaca = new javax.swing.JLabel();
        jTxFieldRaca = new javax.swing.JTextField();
        jCmbBoxTamanho = new javax.swing.JComboBox<>();
        jLbTamanho = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jLbFundoPet = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuVoltar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pets");
        getContentPane().setLayout(null);

        jLbPets.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbPets.setForeground(new java.awt.Color(255, 255, 255));
        jLbPets.setText("Meus pets");
        getContentPane().add(jLbPets);
        jLbPets.setBounds(300, 180, 100, 25);

        jCmbBoxPets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBoxPetsActionPerformed(evt);
            }
        });
        getContentPane().add(jCmbBoxPets);
        jCmbBoxPets.setBounds(300, 220, 150, 22);

        jLbNome.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbNome.setForeground(new java.awt.Color(255, 255, 255));
        jLbNome.setText("Nome");
        getContentPane().add(jLbNome);
        jLbNome.setBounds(300, 280, 100, 25);
        getContentPane().add(jTxFieldNome);
        jTxFieldNome.setBounds(300, 320, 150, 22);

        jLbCastrado.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbCastrado.setForeground(new java.awt.Color(255, 255, 255));
        jLbCastrado.setText("Castrado?");
        getContentPane().add(jLbCastrado);
        jLbCastrado.setBounds(550, 280, 100, 25);

        jCmbBoxCastrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        getContentPane().add(jCmbBoxCastrado);
        jCmbBoxCastrado.setBounds(550, 320, 100, 22);

        jLbEspecie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbEspecie.setForeground(new java.awt.Color(255, 255, 255));
        jLbEspecie.setText("Espécie");
        getContentPane().add(jLbEspecie);
        jLbEspecie.setBounds(750, 280, 100, 25);

        jCmbBoxEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cachorro", "Gato" }));
        getContentPane().add(jCmbBoxEspecie);
        jCmbBoxEspecie.setBounds(750, 320, 150, 22);

        jLbGenero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbGenero.setForeground(new java.awt.Color(255, 255, 255));
        jLbGenero.setText("Gênero");
        getContentPane().add(jLbGenero);
        jLbGenero.setBounds(300, 380, 100, 25);

        jCmbBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Fêmea" }));
        getContentPane().add(jCmbBoxGenero);
        jCmbBoxGenero.setBounds(300, 420, 150, 22);

        jLbRaca.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbRaca.setForeground(new java.awt.Color(255, 255, 255));
        jLbRaca.setText("Raça");
        getContentPane().add(jLbRaca);
        jLbRaca.setBounds(550, 380, 100, 25);
        getContentPane().add(jTxFieldRaca);
        jTxFieldRaca.setBounds(550, 420, 150, 22);

        jCmbBoxTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande" }));
        getContentPane().add(jCmbBoxTamanho);
        jCmbBoxTamanho.setBounds(750, 420, 150, 22);

        jLbTamanho.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbTamanho.setForeground(new java.awt.Color(255, 255, 255));
        jLbTamanho.setText("Tamanho");
        getContentPane().add(jLbTamanho);
        jLbTamanho.setBounds(750, 380, 100, 25);

        jButtonRegistrar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.setMaximumSize(new java.awt.Dimension(96, 26));
        jButtonRegistrar.setMinimumSize(new java.awt.Dimension(96, 26));
        jButtonRegistrar.setPreferredSize(new java.awt.Dimension(96, 26));
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrar);
        jButtonRegistrar.setBounds(450, 500, 100, 26);

        jLbFundoPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/tired-dog-1374055.jpg")));
        getContentPane().add(jLbFundoPet);
        jLbFundoPet.setBounds(0, 0, 1370, 740);

        jMenuVoltar.setText("Voltar");
        jMenuVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuVoltarMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuVoltar);

        setJMenuBar(jMenuBar);

        pack();
        setBounds(0, 0, 1366, 768); // EDITAR
    }
    
    /* Event */

    private void jCmbBoxPetsActionPerformed(java.awt.event.ActionEvent evt) {
        // NOTHING
    }

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        // 
        controlePet.cadastrar();
        // Atualizar combo box
        this.jCmbBoxPets.removeAllItems(); // Limpar combo box
        controlePet.atualizarPets();
    }

    private void jMenuVoltarMouseClicked(java.awt.event.MouseEvent evt) {
        //
        new TelaMenu().setVisible(true); 
        dispose();
    }

    private void nimbusPet(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    /* Getters and setters */
    public JButton getjButtonRegistrar() {
        return jButtonRegistrar;
    }

    public void setjButtonRegistrar(JButton jButtonRegistrar) {
        this.jButtonRegistrar = jButtonRegistrar;
    }

    public JComboBox<String> getjCmbBoxCastrado() {
        return jCmbBoxCastrado;
    }

    public void setjCmbBoxCastrado(JComboBox<String> jCmbBoxCastrado) {
        this.jCmbBoxCastrado = jCmbBoxCastrado;
    }

    public JComboBox<String> getjCmbBoxGenero() {
        return jCmbBoxGenero;
    }

    public void setjCmbBoxGenero(JComboBox<String> jCmbBoxGenero) {
        this.jCmbBoxGenero = jCmbBoxGenero;
    }

    public JComboBox<String> getjCmbBoxPets() {
        return jCmbBoxPets;
    }

    public void setjCmbBoxPets(JComboBox<String> jCmbBoxPets) {
        this.jCmbBoxPets = jCmbBoxPets;
    }

    public JComboBox<String> getjCmbBoxTamanho() {
        return jCmbBoxTamanho;
    }

    public void setjCmbBoxTamanho(JComboBox<String> jCmbBoxTamanho) {
        this.jCmbBoxTamanho = jCmbBoxTamanho;
    }

    public JComboBox<String> getjCmbBoxEspecie() {
        return jCmbBoxEspecie;
    }

    public void setjCmbBoxEspecie(JComboBox<String> jCmbBoxEspecie) {
        this.jCmbBoxEspecie = jCmbBoxEspecie;
    }
    
    public JTextField getjTxFieldNome() {
        return jTxFieldNome;
    }

    public void setjTxFieldNome(JTextField jTxFieldNome) {
        this.jTxFieldNome = jTxFieldNome;
    }

    public JTextField getjTxFieldRaca() {
        return jTxFieldRaca;
    }

    public void setjTxFieldRaca(JTextField jTxFieldRaca) {
        this.jTxFieldRaca = jTxFieldRaca;
    }

}

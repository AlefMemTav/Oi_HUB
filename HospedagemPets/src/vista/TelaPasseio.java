
package vista;

import controle.ControlePasseio;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * TelaPasseio.
 * @author Pedro Lucas Garcia
 */
public class TelaPasseio extends javax.swing.JFrame {
    // Declaracoes
    private javax.swing.JButton jButtonReservar;
    private javax.swing.JComboBox<String> jCmBoxHospitaleiro;
    private javax.swing.JComboBox<String> jCmbBoxPet;
    private javax.swing.JFormattedTextField jFmtdDataPasseio;
    private javax.swing.JFormattedTextField jFmtdHoraPasseio;
    private javax.swing.JLabel jLbCidade;
    private javax.swing.JLabel jLbDataPasseio;
    private javax.swing.JLabel jLbFundoMenu;
    private javax.swing.JLabel jLbHoraPasseio;
    private javax.swing.JLabel jLbHospitaleiro;
    private javax.swing.JLabel jLbPet;
    private javax.swing.JLabel jLbValor;
    private javax.swing.JLabel jLbObservacao;
    private javax.swing.JMenuBar jMenuBarMenu;
    private javax.swing.JMenu jMenuReservas;
    private javax.swing.JMenu jMenuVoltar;
    private javax.swing.JTextField jTxFieldCidade;
    private javax.swing.JTextField jTxFieldValor;
    private javax.swing.JTextArea jTxComportamento;
    private javax.swing.JScrollPane jScrollPane;
    private final ControlePasseio controlePasseio;

    /**
     * TelaHospedagem
     */
    public TelaPasseio() {
        //Instrucao
        // Chamar nimbus
        nimbusHospedagem();
        // Iniciar componentes
        componentes();
        // Criar controle de login
        controlePasseio = new ControlePasseio(this);
        // 
        controlePasseio.atualizarHospitaleiros();
        controlePasseio.atualizarPets();
    }

    @SuppressWarnings("unchecked")
 
    private void componentes() {
        // Instrucoes
        jLbHospitaleiro = new javax.swing.JLabel();
        jCmBoxHospitaleiro = new javax.swing.JComboBox<>();
        jLbPet = new javax.swing.JLabel();
        jCmbBoxPet = new javax.swing.JComboBox<>();
        jLbValor = new javax.swing.JLabel();
        jTxFieldValor = new javax.swing.JTextField();
        jLbCidade = new javax.swing.JLabel();
        jTxFieldCidade = new javax.swing.JTextField();
        jLbDataPasseio = new javax.swing.JLabel();
        jFmtdDataPasseio = new javax.swing.JFormattedTextField();
        jLbHoraPasseio = new javax.swing.JLabel();
        jFmtdHoraPasseio = new javax.swing.JFormattedTextField();
        jButtonReservar = new javax.swing.JButton();
        jLbFundoMenu = new javax.swing.JLabel();
        //jTxFieldId = new javax.swing.JTextField();
        //jTxFieldIdServico = new javax.swing.JTextField();
        jMenuBarMenu = new javax.swing.JMenuBar();
        jMenuVoltar = new javax.swing.JMenu();
        jMenuReservas = new javax.swing.JMenu();
        jLbObservacao = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTxComportamento = new javax.swing.JTextArea();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Passeio de pets");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/vista/imagem/icone/patas_icone.png")));
        getContentPane().setLayout(null);
        
        jLbHospitaleiro.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbHospitaleiro.setForeground(new java.awt.Color(255, 255, 255));
        jLbHospitaleiro.setText("Hospitaleiro");
        getContentPane().add(jLbHospitaleiro);
        jLbHospitaleiro.setBounds(300, 180, 104, 25);
        
        jCmBoxHospitaleiro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmBoxHospitaleiroItemStateChanged(evt);
            }
        });
        getContentPane().add(jCmBoxHospitaleiro);
        jCmBoxHospitaleiro.setBounds(300, 220, 150, 22);

        jLbPet.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbPet.setForeground(new java.awt.Color(255, 255, 255));
        jLbPet.setText("Pet");
        jLbPet.setToolTipText("");
        getContentPane().add(jLbPet);
        jLbPet.setBounds(750, 280, 30, 25);

        getContentPane().add(jCmbBoxPet);
        jCmbBoxPet.setBounds(750, 320, 150, 22);

        jLbValor.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbValor.setForeground(new java.awt.Color(255, 255, 255));
        jLbValor.setText("Valor");
        getContentPane().add(jLbValor);
        jLbValor.setBounds(550, 180, 45, 25);
        getContentPane().add(jTxFieldValor);
        jTxFieldValor.setBounds(550, 220, 100, 22);
        jTxFieldValor.setEditable(false);

        jLbCidade.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbCidade.setForeground(new java.awt.Color(255, 255, 255));
        jLbCidade.setText("Cidade");
        getContentPane().add(jLbCidade);
        jLbCidade.setBounds(750, 180, 60, 25);
        getContentPane().add(jTxFieldCidade);
        jTxFieldCidade.setBounds(750, 220, 150, 22);
        jTxFieldCidade.setEditable(false);

        jLbDataPasseio.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbDataPasseio.setForeground(new java.awt.Color(255, 255, 255));
        jLbDataPasseio.setText("Data do passeio");
        getContentPane().add(jLbDataPasseio);
        jLbDataPasseio.setBounds(300, 280, 140, 25);
        getContentPane().add(jFmtdDataPasseio);
        jFmtdDataPasseio.setBounds(300, 320, 150, 22);

        jLbHoraPasseio.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbHoraPasseio.setForeground(new java.awt.Color(255, 255, 255));
        jLbHoraPasseio.setText("Hora do passeio");
        getContentPane().add(jLbHoraPasseio);
        jLbHoraPasseio.setBounds(550, 280, 140, 25);
        getContentPane().add(jFmtdHoraPasseio);
        jFmtdHoraPasseio.setBounds(550, 320, 150, 22);
        
        jLbObservacao.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbObservacao.setForeground(new java.awt.Color(255, 255, 255));
        jLbObservacao.setText("Observação");
        getContentPane().add(jLbObservacao);
        jLbObservacao.setBounds(300, 380, 104, 25);
        
        jTxComportamento.setColumns(20);
        jTxComportamento.setRows(5);
        jScrollPane.setViewportView(jTxComportamento);
        
        getContentPane().add(jScrollPane);
        jScrollPane.setBounds(300, 420, 600, 50);

        jButtonReservar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonReservar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonReservar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReservar.setText("Reservar");
        jButtonReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonReservarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReservar);
        jButtonReservar.setBounds(450, 500, 100, 26);
        jLbFundoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/tired-dog-1374055.jpg")));
        getContentPane().add(jLbFundoMenu);
        jLbFundoMenu.setBounds(0, 0, 1366, 768);
        
        jMenuVoltar.setText("Voltar");
        jMenuVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuVoltarMouseClicked(evt);
            }
        });
        jMenuBarMenu.add(jMenuVoltar);

        jMenuReservas.setText("Reservas");
        jMenuReservas.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuReservasMouseClicked(evt);
            }
        });
        jMenuBarMenu.add(jMenuReservas);

        setJMenuBar(jMenuBarMenu);

        pack();
        setBounds(0, 0, 1366, 768); // EDITAR
    }
    
    /* Events */
    
    /* Mouse clicked */
    
    private void ButtonReservarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controlePasseio.cadastrar();
    } 
    
    // Menu voltar
    private void jMenuVoltarMouseClicked(java.awt.event.MouseEvent evt) {
        new TelaMenu().setVisible(true); // Ir para a tela de menu
        controlePasseio.fecharPasseio(); // Fechar tela de passeio
    }

    // Menu reservas
    private void jMenuReservasMouseClicked(java.awt.event.MouseEvent evt) {
        // Ir para tela de reservas 
        new TelaPasseioReservas().setVisible(true);
    }

    /* Item state changed */
    // Combo box hospitaleiro
    private void jCmBoxHospitaleiroItemStateChanged(java.awt.event.ItemEvent evt) {
        controlePasseio.atualizarValor(); // Atualizar campo de valor
        controlePasseio.atualizarCidade(); // Atualizar campo de cidade
    }

    /**
     * 
     */
    private void nimbusHospedagem(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaHospedagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /* Getters and setters */

    public JButton getjButtonReservar() {
        return jButtonReservar;
    }

    public void setjButtonReservar(JButton jButtonReservar) {
        this.jButtonReservar = jButtonReservar;
    }

    public JComboBox<String> getjCmBoxHospitaleiro() {
        return jCmBoxHospitaleiro;
    }

    public void setjCmBoxHospitaleiro(JComboBox<String> jCmBoxHospitaleiro) {
        this.jCmBoxHospitaleiro = jCmBoxHospitaleiro;
    }

    public JComboBox<String> getjCmbBoxPet() {
        return jCmbBoxPet;
    }

    public void setjCmbBoxPet(JComboBox<String> jCmbBoxPet) {
        this.jCmbBoxPet = jCmbBoxPet;
    }

    public JFormattedTextField getjFmtdDataPasseio() {
        return jFmtdDataPasseio;
    }

    public void setjFmtdDataPasseio(JFormattedTextField jFmtdDataPasseio) {
        this.jFmtdDataPasseio = jFmtdDataPasseio;
    }

    public JFormattedTextField getjFmtdHoraPasseio() {
        return jFmtdHoraPasseio;
    }

    public void setjFmtdHoraPasseio(JFormattedTextField jFmtdHoraPasseio) {
        this.jFmtdHoraPasseio = jFmtdHoraPasseio;
    }

    public JLabel getjLbCidade() {
        return jLbCidade;
    }

    public void setjLbCidade(JLabel jLbCidade) {
        this.jLbCidade = jLbCidade;
    }

    public JLabel getjLbDataPasseio() {
        return jLbDataPasseio;
    }

    public void setjLbDataPasseio(JLabel jLbDataPasseio) {
        this.jLbDataPasseio = jLbDataPasseio;
    }

    public JLabel getjLbFundoMenu() {
        return jLbFundoMenu;
    }

    public void setjLbFundoMenu(JLabel jLbFundoMenu) {
        this.jLbFundoMenu = jLbFundoMenu;
    }

    public JLabel getjLbHoraPasseio() {
        return jLbHoraPasseio;
    }

    public void setjLbHoraPasseio(JLabel jLbHoraPasseio) {
        this.jLbHoraPasseio = jLbHoraPasseio;
    }

    public JLabel getjLbHospitaleiro() {
        return jLbHospitaleiro;
    }

    public void setjLbHospitaleiro(JLabel jLbHospitaleiro) {
        this.jLbHospitaleiro = jLbHospitaleiro;
    }

    public JLabel getjLbPet() {
        return jLbPet;
    }

    public void setjLbPet(JLabel jLbPet) {
        this.jLbPet = jLbPet;
    }

    public JLabel getjLbValor() {
        return jLbValor;
    }

    public void setjLbValor(JLabel jLbValor) {
        this.jLbValor = jLbValor;
    }

    public JMenuBar getjMenuBarMenu() {
        return jMenuBarMenu;
    }

    public void setjMenuBarMenu(JMenuBar jMenuBarMenu) {
        this.jMenuBarMenu = jMenuBarMenu;
    }

    public JMenu getjMenuReservas() {
        return jMenuReservas;
    }

    public void setjMenuReservas(JMenu jMenuReservas) {
        this.jMenuReservas = jMenuReservas;
    }

    public JMenu getjMenuVoltar() {
        return jMenuVoltar;
    }

    public void setjMenuVoltar(JMenu jMenuVoltar) {
        this.jMenuVoltar = jMenuVoltar;
    }

    public JTextField getjTxFieldCidade() {
        return jTxFieldCidade;
    }

    public void setjTxFieldCidade(JTextField jTxFieldCidade) {
        this.jTxFieldCidade = jTxFieldCidade;
    }

    public JTextField getjTxFieldValor() {
        return jTxFieldValor;
    }

    public void setjTxFieldValor(JTextField jTxFieldValor) {
        this.jTxFieldValor = jTxFieldValor;
    }

    public JTextArea getjTxComportamento() {
        return jTxComportamento;
    }

    public void setjTxComportamento(JTextArea jTxComportamento) {
        this.jTxComportamento = jTxComportamento;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }
    
}
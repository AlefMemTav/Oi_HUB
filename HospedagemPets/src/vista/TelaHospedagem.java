
package vista;

import controle.ControleHospedagem;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/*
 * TelaHospedagem
 * @author Pedro Lucas Garcia
 */
public class TelaHospedagem extends javax.swing.JFrame {
    // Declaracoes
    private javax.swing.JButton jButtonHospedar;
    private javax.swing.JComboBox<String> jCmBoxHospitaleiro;
    private javax.swing.JComboBox<String> jCmbBoxPet;
    private javax.swing.JFormattedTextField jFmtdDataEntrada;
    private javax.swing.JFormattedTextField jFmtdDataSaida;
    private javax.swing.JFormattedTextField jFmtdHoraEntrada;
    private javax.swing.JFormattedTextField jFmtdHoraSaida;
    private javax.swing.JLabel jLbCidade;
    private javax.swing.JLabel jLbDataEntrada;
    private javax.swing.JLabel jLbDataSaida;
    private javax.swing.JLabel jLbFundoMenu;
    private javax.swing.JLabel jLbHoraEntrada;
    private javax.swing.JLabel jLbHoraSaida;
    private javax.swing.JLabel jLbHospitaleiro;
    private javax.swing.JLabel jLbPet;
    private javax.swing.JLabel jLbValor;
    private javax.swing.JMenuBar jMenuBarMenu;
    private javax.swing.JMenu jMenuReservas;
    private javax.swing.JMenu jMenuVoltar;
    private javax.swing.JTextField jTxFieldCidade;
    //private javax.swing.JTextField jTxFieldId;
    //private javax.swing.JTextField jTxFieldIdServico;
    private javax.swing.JTextField jTxFieldValor;
    private final ControleHospedagem contrHosp;

    /*
     * TelaHospedagem
     */
    public TelaHospedagem() {
        //Instrucao
        // Chamar nimbus
        nimbusHospedagem();
        // Iniciar componentes
        componentes();
        // Criar controle de login
        contrHosp = new ControleHospedagem(this);
        // 
        contrHosp.atualizarHospitaleiros();
        contrHosp.atualizarPets();
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
        jLbDataEntrada = new javax.swing.JLabel();
        jFmtdDataEntrada = new javax.swing.JFormattedTextField();
        jLbDataSaida = new javax.swing.JLabel();
        jFmtdDataSaida = new javax.swing.JFormattedTextField();
        jLbHoraEntrada = new javax.swing.JLabel();
        jFmtdHoraEntrada = new javax.swing.JFormattedTextField();
        jLbHoraSaida = new javax.swing.JLabel();
        jFmtdHoraSaida = new javax.swing.JFormattedTextField();
        jButtonHospedar = new javax.swing.JButton();
        jLbFundoMenu = new javax.swing.JLabel();
        //jTxFieldId = new javax.swing.JTextField();
        //jTxFieldIdServico = new javax.swing.JTextField();
        jMenuBarMenu = new javax.swing.JMenuBar();
        jMenuVoltar = new javax.swing.JMenu();
        jMenuReservas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospedar");
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

        jLbDataEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbDataEntrada.setForeground(new java.awt.Color(255, 255, 255));
        jLbDataEntrada.setText("Data de entrada");
        getContentPane().add(jLbDataEntrada);
        jLbDataEntrada.setBounds(300, 280, 140, 25);
        getContentPane().add(jFmtdDataEntrada);
        jFmtdDataEntrada.setBounds(300, 320, 150, 22);

        jLbDataSaida.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbDataSaida.setForeground(new java.awt.Color(255, 255, 255));
        jLbDataSaida.setText("Data de saída");
        getContentPane().add(jLbDataSaida);
        jLbDataSaida.setBounds(550, 280, 115, 25);
        getContentPane().add(jFmtdDataSaida);
        jFmtdDataSaida.setBounds(550, 320, 150, 22);

        jLbHoraEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbHoraEntrada.setForeground(new java.awt.Color(255, 255, 255));
        jLbHoraEntrada.setText("Hora de entrada");
        getContentPane().add(jLbHoraEntrada);
        jLbHoraEntrada.setBounds(300, 380, 140, 25);
        getContentPane().add(jFmtdHoraEntrada);
        jFmtdHoraEntrada.setBounds(300, 420, 150, 22);

        jLbHoraSaida.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLbHoraSaida.setForeground(new java.awt.Color(255, 255, 255));
        jLbHoraSaida.setText("Hora de saída");
        getContentPane().add(jLbHoraSaida);
        jLbHoraSaida.setBounds(550, 380, 120, 25);
        getContentPane().add(jFmtdHoraSaida);
        jFmtdHoraSaida.setBounds(550, 420, 150, 22);

        jButtonHospedar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonHospedar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonHospedar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHospedar.setText("Hospedar");
        jButtonHospedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHospedarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHospedar);
        jButtonHospedar.setBounds(450, 500, 100, 26);
        jLbFundoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/tired-dog-1374055.jpg")));
        getContentPane().add(jLbFundoMenu);
        jLbFundoMenu.setBounds(0, 0, 1366, 768);
        
        //getContentPane().add(jTxFieldId); 
        //jTxFieldId.setBounds(120, 10, 30, 22);
        //jTxFieldId.setEditable(false);
        //jTxFieldId.setText("0");
        
        //getContentPane().add(jTxFieldIdServico);
        //jTxFieldIdServico.setBounds(120, 40, 30, 22);
        //jTxFieldIdServico.setEditable(false);
        //jTxFieldIdServico.setText("1");
        
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
    
    private void ButtonHospedarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        contrHosp.reservarHospedagem();
    } 
    
    // Menu voltar
    private void jMenuVoltarMouseClicked(java.awt.event.MouseEvent evt) {
        contrHosp.irParaMenu(); // Ir para a tela de menu
        contrHosp.fecharHospedagem(); // Fechar tela de hospedagem
    }

    // Menu reservas
    private void jMenuReservasMouseClicked(java.awt.event.MouseEvent evt) {
        // Ir para tela de reservas de hospedagem
        new TelaHospedReservas().setVisible(true);
    }

    /* Item state changed */
    // Combo box hospitaleiro
    private void jCmBoxHospitaleiroItemStateChanged(java.awt.event.ItemEvent evt) {
        contrHosp.atualizarValor(); // Atualizar campo de valor
        contrHosp.atualizarCidade(); // Atualizar campo de cidade
    }

    // Nimbus look and feel
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
    // Combo box dos hospitaleiros
    public JComboBox<String> getjCmBoxHospitaleiro() {
        return jCmBoxHospitaleiro; // Get
    }
    
    public void setjCmBoxHospitaleiro(JComboBox<String> jCmBoxHospitaleiro) {
        this.jCmBoxHospitaleiro = jCmBoxHospitaleiro; // Set
    }
    // Combo box dos pets
    public JComboBox<String> getjCmbBoxPet() {
        return jCmbBoxPet; // Get
    }

    public void setjCmbBoxPet(JComboBox<String> jCmbBoxPet) {
        this.jCmbBoxPet = jCmbBoxPet; // Set
    }

    // Data de entrada formatada
    public JFormattedTextField getjFmtdDataEntrada() {
        return jFmtdDataEntrada; // Get
    }

    public void setjFmtdDataEntrada(JFormattedTextField jFmtdDataEntrada) {
        this.jFmtdDataEntrada = jFmtdDataEntrada; // Set
    }
    
    // Data de saida formatada
    public JFormattedTextField getjFmtdDataSaida() {
        return jFmtdDataSaida; // Get
    }

    public void setjFmtdDataSaida(JFormattedTextField jFmtdDataSaida) {
        this.jFmtdDataSaida = jFmtdDataSaida; // Set
    }
    
    //Hora de entrada formatada
    public JFormattedTextField getjFmtdHoraEntrada() {
        return jFmtdHoraEntrada; // Get
    }
    
    public void setjFmtdHoraEntrada(JFormattedTextField jFmtdHoraEntrada) {
        this.jFmtdHoraEntrada = jFmtdHoraEntrada; // Set
    }
    
    // Hora de saida formatada
    public JFormattedTextField getjFmtdHoraSaida() {
        return jFmtdHoraSaida; // Get
    }
    public void setjFmtdHoraSaida(JFormattedTextField jFmtdHoraSaida) {
        this.jFmtdHoraSaida = jFmtdHoraSaida; // Set
    }
    
    //Campos de texto
    //public JTextField getjTxFieldId() {
    //    return jTxFieldId; // Get
    //}

    //public void setjTxFieldId(JTextField jTxFieldId) {
    //    this.jTxFieldId = jTxFieldId; // Set
    //}
    
    public JTextField getjTxFieldCidade() {
        return jTxFieldCidade; // Get
    }

    public void setjTxFieldCidade(JTextField jTxFieldCidade) {
        this.jTxFieldCidade = jTxFieldCidade; // Set
    }
    
    public JTextField getjTxFieldValor() {
        return jTxFieldValor; // Get
    }

    public void setjTxFieldValor(JTextField jTxFieldValor) {
        this.jTxFieldValor = jTxFieldValor; // Set
    }
}

package vista;

import controle.ControleLogin;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controle.DAO.BancoDeDados;
import java.awt.Toolkit;

/**
 * TelaLogin.
 * @author Pedro Lucas Garcia
 */
public class TelaLogin extends javax.swing.JFrame {
    // Declaracoes
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabelTextoSenha;
    private javax.swing.JLabel jLbEntrar;
    private javax.swing.JLabel jLbFundoLogin;
    private javax.swing.JLabel jLbPass;
    private javax.swing.JLabel jLbTitulo;
    private javax.swing.JLabel jLbUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTxFieldUsuario;    
    private final ControleLogin controleLog;
    
    /*
     * TelaLogin
     */
    public TelaLogin() {
        // Componetes da TelaLogin
        componentes();
        // Controlador da tela de login
        controleLog = new ControleLogin(this);
        // Inicair banco de dados
        BancoDeDados.dadosIniciais();
    }

    @SuppressWarnings("unchecked")
  
    private void componentes() {
        jLabelTextoSenha = new javax.swing.JLabel();
        jLbTitulo = new javax.swing.JLabel();
        jLbEntrar = new javax.swing.JLabel();
        jLbUsuario = new javax.swing.JLabel();
        jLbPass = new javax.swing.JLabel();
        jTxFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jLbFundoLogin = new javax.swing.JLabel();

        jLabelTextoSenha.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabelTextoSenha.setText("Senha");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hospedagem de pets");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/vista/imagem/icone/patas_icone.png")));
        getContentPane().setLayout(null);

        jLbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); 
        jLbTitulo.setForeground(new java.awt.Color(255, 51, 51));
        jLbTitulo.setText("Hospedagem de pets");
        getContentPane().add(jLbTitulo);
        jLbTitulo.setBounds(420, 60, 510, 64);

        jLbEntrar.setFont(new java.awt.Font("Segoe UI", 1, 48)); 
        jLbEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jLbEntrar.setText("Entrar");
        getContentPane().add(jLbEntrar);
        jLbEntrar.setBounds(580, 100, 140, 110);

        jLbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLbUsuario.setText("Usuário");
        getContentPane().add(jLbUsuario);
        jLbUsuario.setBounds(620, 220, 60, 20);

        jLbPass.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLbPass.setText("Senha");
        getContentPane().add(jLbPass);
        jLbPass.setBounds(620, 290, 40, 20);
        getContentPane().add(jTxFieldUsuario);
        jTxFieldUsuario.setBounds(530, 250, 250, 30);
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(530, 320, 250, 30);

        jButtonEntrar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButtonEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar);
        jButtonEntrar.setBounds(600, 390, 100, 40);

        jLbFundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/tired-dog-1552084.jpg")));
        getContentPane().add(jLbFundoLogin);
        jLbFundoLogin.setBounds(0, 0, 1366, 768);

        pack();
        setBounds(0,0,1366,768); //EDITAR
    }

    /* ActionPerformed events */
    
    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        // Verificar dados de usuario e entrar caso estejam corretos
        this.controleLog.entrar();
        // TESTE
        /*System.out.println("TelaLogin: " + jTxFieldUsuario.getText());*/
        // FIM TESTE
    }

    /**
     * Principal
     */
    public static void main(String args[]) {
        // Chamar nimbus da tela de login
        nimbus();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
        // Aviso sobre login
        javax.swing.JOptionPane.showMessageDialog(null, "Use como um exemplo:\n Usuario: pedro@email.com\n Senha: senha1");
    }
    
    /* Métodos */
    
    // Nimbus look and feel 
    private static void nimbus(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    // Método painel de aviso com mensagem exibida na TelaLogin
    public static void aviso(String msg) {
        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }
  
    /* Getters and setters */
    /* Senha */
    public JPasswordField getjPasswordFieldSenha() {
        return jPasswordFieldSenha;
    }
    
    public void setjPasswordFieldSenha(JPasswordField jPasswordFieldSenha) {    
        this.jPasswordFieldSenha = jPasswordFieldSenha;
    }

    /* Usuario */
    public JTextField getjTxFieldUsuario() {
        return jTxFieldUsuario;
    }

    public void setjTxFieldUsuario(JTextField jTxFieldUsuario) {
        this.jTxFieldUsuario = jTxFieldUsuario;
    }
}
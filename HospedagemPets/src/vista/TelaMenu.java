
package vista;

import controle.ControleMenu;

/**
 * TelaMenu
 * @author Pedro Lucas Garcia
 */
public class TelaMenu extends javax.swing.JFrame {
    // Declaracoes
    private javax.swing.JLabel jLabelFundoMenu;
    private javax.swing.JMenuBar jMenuBarMenu;
    private javax.swing.JMenu jMenuHospedagem;
    private javax.swing.JMenu jMenuHospitaleiro;
    private javax.swing.JMenuItem jMenuItemCreche;
    private javax.swing.JMenuItem jMenuItemPasseio;
    private javax.swing.JMenuItem jMenuItemPet;
    private javax.swing.JMenu jMenuServicos;
    private javax.swing.JMenu jMenuUsuario;
    private final ControleMenu controleMenu;
    /**
     * TelaMenu
     */
    public TelaMenu() {
        // Chamar nimbus
        nimbusMenu();
        // Controlador da tela de menu
        controleMenu = new ControleMenu(this);
        // Componetes da tela de Menu
        componentes();
    }

    @SuppressWarnings("unchecked")

    private void componentes() {

        jLabelFundoMenu = new javax.swing.JLabel();
        jMenuBarMenu = new javax.swing.JMenuBar();
        jMenuHospedagem = new javax.swing.JMenu();
        jMenuServicos = new javax.swing.JMenu();
        jMenuItemPasseio = new javax.swing.JMenuItem();
        jMenuItemCreche = new javax.swing.JMenuItem();
        jMenuHospitaleiro = new javax.swing.JMenu();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItemPet = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Casa");
        getContentPane().setLayout(null);

        jLabelFundoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/tired-dog-1374055.jpg")));
        getContentPane().add(jLabelFundoMenu);
        jLabelFundoMenu.setBounds(0, 0, 1366, 768);

        jMenuHospedagem.setText("Hospedagem");
        jMenuHospedagem.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuHospedagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHospedagemMouseClicked(evt);
            }
        });
        jMenuBarMenu.add(jMenuHospedagem);

        jMenuServicos.setText("Serviços");
        jMenuServicos.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jMenuItemPasseio.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuItemPasseio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/icone/passeio_icone.png")));
        jMenuItemPasseio.setText("Passeio");
        jMenuServicos.add(jMenuItemPasseio);

        jMenuItemCreche.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuItemCreche.setText("Creche");
        jMenuServicos.add(jMenuItemCreche);

        jMenuBarMenu.add(jMenuServicos);

        jMenuHospitaleiro.setText("Hospitaleiro");
        jMenuHospitaleiro.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuBarMenu.add(jMenuHospitaleiro);

        jMenuUsuario.setText("Usuário");
        jMenuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jMenuItemPet.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jMenuItemPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagem/icone/pet_icone.png")));
        jMenuItemPet.setText("Pet");
        jMenuItemPet.setToolTipText("");
        jMenuItemPet.setActionCommand("Pet");
        jMenuUsuario.add(jMenuItemPet);

        jMenuBarMenu.add(jMenuUsuario);

        setJMenuBar(jMenuBarMenu);

        pack();
        setBounds(0,0,1366,768); //EDITAR
    }
 
    /* Events */
    private void jMenuHospedagemMouseClicked(java.awt.event.MouseEvent evt) {
        // Ir para a tela de hospedagem
        this.controleMenu.irParaHospedagem();
    }

    /* Metodos */
    
    // Nimbus look and feel
     private void nimbusMenu(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
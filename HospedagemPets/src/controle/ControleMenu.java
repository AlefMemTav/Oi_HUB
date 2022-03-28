
package controle;

import visualizar.TelaHospedagem;
import visualizar.TelaMenu;

/*
 *
 * @author Pedro Lucas Garcia
 */
public class ControleMenu {
    private final TelaMenu viewMenu;
    
    /* Construtor */
    public ControleMenu(TelaMenu view) {
        this.viewMenu = view;
    }
    
    // Mostar a janela hospedagem 
    public void irParaHospedagem(){
        new TelaHospedagem().setVisible(true);
        // Fechar janela menu
        this.viewMenu.dispose();
    }
    
}
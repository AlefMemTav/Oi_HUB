
package controle;

import vista.TelaCreche;
import vista.TelaHospedagem;
import vista.TelaMenu;
import vista.TelaPasseio;
import vista.TelaPet;

/**
 * Controlador da tela de menu.
 * @author Pedro Lucas Garcia
 */
public class ControleMenu {
    private final TelaMenu telaMenu;
    /**
     * 
     * @param telaMenu 
     */
    public ControleMenu(TelaMenu telaMenu) {
        this.telaMenu = telaMenu;
    }
    /**
     * Fechar TelaMenu.
     */
    public void fecharMenu(){
        // Fechar a tela menu
        this.telaMenu.dispose();
    }
    /**
     * Abrir a tela de hospedagem e fechar a tela de menu.
     */
    public void irParaHospedagem(){
        new TelaHospedagem().setVisible(true);
        fecharMenu(); 
    }
    /**
    * Abrir a tela de passeio e fechar a tela de menu.
    */
    public void irParaPasseio(){
        new TelaPasseio().setVisible(true);
        fecharMenu();
    }
    /**
    * Abrir a tela de creche e fechar a tela de menu.
    */
    public void irParaCreche(){
        new TelaCreche().setVisible(true);
        fecharMenu();
    }    
    /**
     * Abrir a tela de pet e fechar a tela de menu.
     */
    public void irParaPet(){
        // Abrir tela de pet
        new TelaPet().setVisible(true);
        fecharMenu();
    }
    
}
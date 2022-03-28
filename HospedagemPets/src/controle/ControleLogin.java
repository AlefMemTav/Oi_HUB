
package controle;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.DAO.ClienteDAO;
import modelo.DAO.UsuarioDAO;
import modelo.Usuario;
import visualizar.TelaLogin;
import visualizar.TelaMenu;

/**
 * Controlador do login
 * @author Pedro Lucas Garcia
 */
public class ControleLogin {
    private TelaLogin telaLog; // Tem como atributo a janela que gerencia: TelaLogin
    
    /* Construtor */
    public ControleLogin(TelaLogin telaLog) {
        this.telaLog = telaLog;
    }

    /* Métodos */
    public void setUsuario(Usuario usuario){
        // Pegar os dados digitados na tela de login
        String emailDigitado = usuario.getEmail();
        String senhaDigitada = usuario.getSenha();
        // 
        telaLog.getjTxFieldUsuario().setText(emailDigitado);
        telaLog.getjPasswordFieldSenha().setText(senhaDigitada);
    }
    /**
     * Pega os campos de texto de usuario na tela de login e armazena nas variaveis
     * @return Retorna usuarioDigitado
     */
    public Usuario obterUsuario(){
        // Pegar os dados digitados na tela de login
        String emailDigitado = telaLog.getjTxFieldUsuario().getText();
        String senhaDigitada = telaLog.getjPasswordFieldSenha().getText();
        
        // Instanciar um usuario com os dados digitados
        Usuario usuarioDigitado = new Usuario(emailDigitado, senhaDigitada);
        // Retornar o usuario
        return usuarioDigitado;
    }
    /**
     * Limpa os campos de texto de usuario na tela de login
     * 
     */
    public void limparTela(){
        // Limpar o campo de senha do usuario
        // telaLog.getjTxFieldUsuario().setText(""); // Pode ser util
        telaLog.getjPasswordFieldSenha().setText("");
    } 
    
    public void irParaMenu(){
        new TelaMenu().setVisible(true);
    }
    
    public void fecharLogin(){
        this.telaLog.dispose();
    }
    
    /**
     * 
     */
    public void entrar(){
        // Verifique se em TelaLogin foi chamado os dados iniciais de BancoDeDados
        // Pegar os campos de usuario da tela de login 
        Usuario usuarioAAutenticar = obterUsuario();
        // Pesquisar usuario no banco de dados
        UsuarioDAO user = new UsuarioDAO();
        Usuario userAutenticado = user.selecionarUsuario(usuarioAAutenticar);
        
        // Se encontrar usuario
        if(userAutenticado != null){
            irParaMenu(); // Abre a tela de menu e fecha a tela de login
            fecharLogin();
        }else{
            telaLog.aviso("Usuario ou senha invalidos!");
        }
    }
}
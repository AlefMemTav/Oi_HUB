
package controle;

import controle.DAO.UsuarioDAO;
import modelo.Sessao;
import modelo.Usuario;
import vista.TelaLogin;
import vista.TelaMenu;

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
    
    /**
    * Limpa os campos de texto de usuario na tela de login.
    */
    public void limparTela(){
        // Limpar o campo de senha do usuario
        // telaLog.getjTxFieldUsuario().setText(""); // Pode ser util
        telaLog.getjPasswordFieldSenha().setText("");
    } 
    
    /**
     * 
     */
    public void irParaMenu(){
        new TelaMenu().setVisible(true);
    }
    
    /**
     * 
     */
    public void fecharLogin(){
        this.telaLog.dispose();
    }
    
    /**
     * 
     * @param usuarioAutenticado 
     */
    public void setUsuario(Usuario usuarioAutenticado){
        // Pegar os dados do usuario autenticado
        String emailDigitado = usuarioAutenticado.getEmail();
        String senhaDigitada = usuarioAutenticado.getSenha();
        Usuario user = new Usuario(emailDigitado, senhaDigitada);
        
        user.setEmail(emailDigitado);
        
        System.out.println("setUsuario 1: " + user);
        
        //telaLog.getjTxFieldUsuario().setText(emailDigitado);
        //telaLog.getjPasswordFieldSenha().setText(senhaDigitada);
    }
    
    /**
     * Pega os campos de texto de usuario na tela de login e armazena nas variaveis.
     * @return Retorna usuarioDigitado
     */
    public Usuario obterUsuario(){
        // Pegar os dados digitados na tela de login 
        String emailDigitado = telaLog.getjTxFieldUsuario().getText(); // Pegar email no campo da tela de login
        String senhaDigitada = telaLog.getjPasswordFieldSenha().getText(); // Pegar senha no campo da tela de login
        
        // Instanciar um usuario com os dados digitados
        Usuario usuarioDigitado = new Usuario(emailDigitado, senhaDigitada); // O usuario digitado tem id 0
        // Retornar o usuario
        return usuarioDigitado;
    }

    /**
     * 
     */
    public void entrar(){
        // Verifique se em TelaLogin foi chamado os dados iniciais de BancoDeDados
        // Pegar os campos de usuario da tela de login 
        Usuario usuarioAAutenticar = obterUsuario();
        // Pesquisar usuario no banco de dados
        UsuarioDAO userD = new UsuarioDAO();
        Usuario userAutenticado = userD.selecionarUsuario(usuarioAAutenticar);
        
        // Se encontrar usuario
        if(userAutenticado != null){
            Sessao sessao = Sessao.getInstancia();
            sessao.setUsuario(userAutenticado);
            irParaMenu(); // Abre a tela de menu e fecha a tela de login
            fecharLogin();
        }else{
            TelaLogin.aviso("Usuario ou senha invalidos!");
        }
    }
}
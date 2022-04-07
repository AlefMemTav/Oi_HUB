/*
 * A classe Sessao guarda um usuario permitindo ao sistema retornar um usuario logado.
 */
package modelo;

/**
 * Classe Sessao.
 * @author Pedro Lucas Garcia
 */
public class Sessao {
    private static Sessao instancia = null;
    private Usuario usuario;
    /**
     * Construtor da classe Sessao.
     */
    private Sessao() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Criar uma nova sessao.
     * @return instancia da nova sessao iniciada pelo usuario
     */
    public static Sessao getInstancia(){
        if(instancia == null){
            instancia = new Sessao();
        }
        return instancia;
    }  
}

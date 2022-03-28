
package modelo.DAO;

import java.util.ArrayList;
import modelo.Usuario;

/**
 * Metodos de inserir, atualizar, buscar todos e excluir um usuario do banco de dados.
 * @author Pedro Lucas Garcia
 */
public class UsuarioDAO {
    /**
     * Insere um usuario em BancoDeDados.
     * @param user Um usuario do tipo Usuario.
     */
    public void inserirUsuario(Usuario user){
        BancoDeDados.usuarios.add(user); //Insere o objeto
    }
    
    /**
     * Procura um usuario em BancoDeDados e compara com user. Se iguais, troca o elemento em i por user.
     * @param user
     * @return Retorna true se bem-sucedido, false caso contrario.
     */
    public boolean atualizarUsuario(Usuario user){
        for(int i = 0; i < BancoDeDados.usuarios.size(); i++) {
            if(idIguais(BancoDeDados.usuarios.get(i), user)){
                BancoDeDados.usuarios.set(i, user);
                return true;
            }
        }
        return false;      
    }
    
    /**
     * Deleta um usuario em BancoDeDados buscando pelo id.
     * @param usuario
     * @return Retorna true se bem-sucedido, false caso contrário.
     */
    public boolean deletarUsuario(Usuario user){
        for (Usuario usuarioLista : BancoDeDados.usuarios) {
            if(idIguais(usuarioLista, user)){
                BancoDeDados.usuarios.remove(usuarioLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Encontra todos os usuarios em BancoDeDados.
     * @return Retorna o Arraylist de todos os usuarios.
     */
    public ArrayList<Usuario> selecionarTodos(){
        return BancoDeDados.usuarios;
    }
    
    /**
     * Encontra usuario em BancoDeDados procurando pelo email e senha.
     * @param user
     * @return Retorna usuarioLista encontrado em BancoDeDados.
     */
    public Usuario selecionarUsuario(Usuario user){
        for (Usuario usuarioLista : BancoDeDados.usuarios) {
            if(emailESenhaIguais(usuarioLista, user)){
                return usuarioLista;
            }
        }
        return null;
    }

    /**
     * Recebe dois usuarios e verifica se são iguais pelo nome e senha.
     * @param user
     * @param usuarioAPesquisar
     * @return Retorna true caso sejam iguais, false caso nao forem iguais.
     */
    private boolean emailESenhaIguais(Usuario user, Usuario usuarioAPesquisar) {
        return user.getEmail().equals(usuarioAPesquisar.getEmail()) && user.getSenha().equals(usuarioAPesquisar.getSenha());
    }

    /**
     * Compara dois usuarios pelo id.
     * @param user
     * @param usuarioAComparar
     * @return Retorna true se id dos dois usuarios forem iguais, false se nao forem.
     */
    private boolean idIguais(Usuario user, Usuario usuarioAComparar) {
        return user.getId() ==  usuarioAComparar.getId();
    }
}
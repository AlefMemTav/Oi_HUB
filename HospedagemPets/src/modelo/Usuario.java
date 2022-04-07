package modelo;
/*
    A classe Usuario fornece o id, email, nome e a senha de cada usuario.
    Ela gera herança para a classe Cliente e Funcionario.
*/
/**
 * Classe Usuario.
 * @author Pedro Lucas Garcia
 */
public class Usuario {
    private int id;
    private int nivelDeAcesso; // Nenhum para usuario comum, 1 para cliente e 2 para hospitaleiro
    private String nome;
    private String email;
    private String senha;
    private String telefone; 

    /**
     * Construtor completo da classe Usuario.
     * @param id
     * @param nome
     * @param email
     * @param senha
     * @param telefone 
     */
    public Usuario(int id, String nome, String email, String senha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }
    /**
     * Construtor da classe Usuario com id e email.
     * @param id
     * @param email 
     */
    public Usuario(int id, String email) {
        this.id = id;
        this.email = email;
    }
    /**
     * Construtor da classe Usuario com id, nome e email.
     * @param id
     * @param nome
     * @param email
     */
    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    /**
     * Construtor da classe Usuario com id, nivelDeAcesso, nome e email.
     * @param id
     * @param nivelDeAcesso
     * @param nome
     * @param email 
     */
    public Usuario(int id, int nivelDeAcesso, String nome, String email) {
        this.id = id;
        this.nivelDeAcesso = nivelDeAcesso;
        this.nome = nome;
        this.email = email;
    }
    /**
     * Construtor da classe Usuario com email e senha.
     * @param email
     * @param senha 
     */
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    /**
     * Construtor da classe Usuario com id.
     * @param id 
     */
    public Usuario(int id) {
        this.id = id;
    }
    
    /* Getters and setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
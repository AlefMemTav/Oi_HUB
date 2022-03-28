package modelo;
/*
    A classe Cliente recebe herança de Usuario, e tem também a cidade do cliente e o pet do cliente.
    
    
*/
/**
 * Classe Cliente
 * @author Pedro Lucas Garcia
 */
public class Cliente extends Usuario {
    private String cidade;
    private Pet pet;
    
    /* Construtor completo */
    public Cliente(int id, String nome, String email, String senha, String telefone, String cidade, Pet pet) {
        super(id, nome, email, senha, telefone);
        this.cidade = cidade;
        this.pet = pet;
    }
    
    /* Construtor com id, email, nome e pet */
    public Cliente(int id, String nome, String email, Pet pet) {
        super(id, email, nome);
        this.pet = pet;
    }
    
    /* Construtor com id, email, nome, cidade e pet */
    public Cliente(int id, String nome, String email, String cidade, Pet pet) {
        super(id, nome, email);
        this.cidade = cidade;
        this.pet = pet;
    }
    
    /* Getters and setters */

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
}
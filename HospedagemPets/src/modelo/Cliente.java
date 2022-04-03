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
    private Pet pet1, pet2, pet3, pet4, pet5; // Por hora, o maximo de pets que um usuario pode ter sera 5
    
    /* Construtor completo */
    public Cliente(int id, String nome, String email, String senha, String telefone, String cidade, Pet pet1, Pet pet2, Pet pet3, Pet pet4, Pet pet5) {
        super(id, nome, email, senha, telefone);
        this.cidade = cidade;
        this.pet1 = pet1;
        this.pet2 = pet2;
        this.pet3 = pet3;
        this.pet4 = pet4;
        this.pet5 = pet5;
    }
    
    /* Construtor com id, email, nome e pets */
    public Cliente(int id, String nome, String email, Pet pet1, Pet pet2, Pet pet3, Pet pet4, Pet pet5) {
        super(id, nome, email);
        this.pet1 = pet1;
        this.pet2 = pet2;
        this.pet3 = pet3;
        this.pet4 = pet4;
        this.pet5 = pet5;
    }
    
    /* Construtor com id, email, nome, cidade e pets */
    public Cliente(int id, String nome, String email, String cidade,  Pet pet1, Pet pet2, Pet pet3, Pet pet4, Pet pet5) {
        super(id, nome, email);
        this.cidade = cidade;
        this.pet1 = pet1;
        this.pet2 = pet2;
        this.pet3 = pet3;
        this.pet4 = pet4;
        this.pet5 = pet5;
    }
    
    /* Getters and setters */

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pet getPet1() {
        return pet1;
    }

    public void setPet1(Pet pet1) {
        this.pet1 = pet1;
    }

    public Pet getPet2() {
        return pet2;
    }

    public void setPet2(Pet pet2) {
        this.pet2 = pet2;
    }

    public Pet getPet3() {
        return pet3;
    }

    public void setPet3(Pet pet3) {
        this.pet3 = pet3;
    }

    public Pet getPet4() {
        return pet4;
    }

    public void setPet4(Pet pet4) {
        this.pet4 = pet4;
    }

    public Pet getPet5() {
        return pet5;
    }

    public void setPet5(Pet pet5) {
        this.pet5 = pet5;
    }
    
    @Override
    public String toString(){
        return getNome();
    }
}
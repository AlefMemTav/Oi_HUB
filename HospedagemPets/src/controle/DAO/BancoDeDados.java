
package controle.DAO;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Creche;
import modelo.Hospedagem;
import modelo.Hospitaleiro;
import modelo.Passeio;
import modelo.Pet;
import modelo.Usuario;

/**
 * Banco de dados que armazena novos elementos em ArrayList.
 * @author Pedro Lucas Garcia
 */
public class BancoDeDados {
    // Declaracao
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Cliente> clientes;
    public static ArrayList<Pet> pets;
    public static ArrayList<Hospitaleiro> hospitaleiros;
    public static ArrayList<Hospedagem> hospedagens;
    public static ArrayList<Passeio> passeios;
    public static ArrayList<Creche> creches;
    /**
     * Dados iniciais de usuario, cliente, pet, servico, hospitaleiro, hospedagem.
     */
    public static void dadosIniciais(){
        // Instrucao
        usuarios = new ArrayList<>();
        clientes = new ArrayList<>();
        pets = new ArrayList<>();
        hospitaleiros = new ArrayList<>();
        hospedagens = new ArrayList<>();
        passeios = new ArrayList<>();
        creches = new ArrayList<>();
        
        // Elementos da lista
        
        Usuario usuario1 = new Usuario(1, "Pedro Lucas", "pedro@email.com", "senha1", "61988887777");
        Usuario usuario2 = new Usuario(2, "Fabiana", "fabiana@email.com",  "senha2", "61966665555");
        Usuario usuario3 = new Usuario(3, "Arthur", "arthur@email.com", "senha3", "61944443333");
        Usuario usuario4 = new Usuario(4, "Caio Oliveira", "caio@email.com", "senha4", "6122221111");
        
        /* id do pet, id do dono, castrado, especie, genero, raca, tamanho */
        Pet pet1 = new Pet(1, 1, "Branquinha", "Nao", "Cachorro", "Femea", "Vira-lata", "Medio");
        Pet pet2 = new Pet(2, 2, "Neguinho", "Sim", "Cachorro", "Macho", "Pitbull", "Grande");
        Pet pet3 = new Pet(3, 3, "Garfield", "Nao", "Gato", "Macho", "Persa", "Grande");
        Pet pet4 = new Pet(4, 4, "Rex", "Nao", "Cachorro", "Macho", "American Bully", "Grande");
        Pet pet5 = new Pet(5, 4, "Toto", "Nao", "Cachorro", "Macho", "Salsicha", "Pequeno");
        Pet pet6 = new Pet(6, 1, "Princesa", "Nao", "Cachorro", "Femea", "Poodle", "Medio");
        
        Cliente cliente1 = new Cliente(1, "Pedro Lucas", "pedro@email.com", pet1, pet6, null, null, null);
        Cliente cliente2 = new Cliente(2, "Fabiana", "fabiana@email.com", "Mansao 3 Lago Norte Brasilia DF", pet2, null, null, null, null);
        Cliente cliente3 = new Cliente(3, "Arthur", "arthur@email.com", pet3, null, null, null, null);
        Cliente cliente4 = new Cliente(4, "Caio", "caio@email.com", pet4, pet5, null, null, null);
        
        Hospitaleiro hospitaleiro1 = new Hospitaleiro(1, 1, 2, "Pedro Lucas", "pedro@email.com", "11/12/1908", "Rua 1 Casa 2 Gama DF", "Masculino", "Casa", 1, 20);
        Hospitaleiro hospitaleiro2 = new Hospitaleiro(2, 4, 2, "Caio Oliveira", "caio@email.com", "25/03/1999", "Rua 2 Casa 1 Gama DF", "Masculino", "Casa", 1, 40);
        
        Hospedagem hospedagem1 = new Hospedagem(1, "08/03/2022", "09/03/2022", "11:00", "09:00", 1, hospitaleiro1, cliente2, pet2);
        Hospedagem hospedagem2 = new Hospedagem(2, "09/03/2022", "10/03/2022", "12:00", "06:00", 1, hospitaleiro2, cliente3, pet3);
        
        // id, comportamentoPet, dataPasseio, horaPasseio, enderecoPasseio, idServico, hospitaleiro, cliente, pet
        Passeio passeio1 = new Passeio(1, "Bom menino, muito musculoso, segurar forte para não fugir", "11/05/2022", "11:00", hospitaleiro1.getCidade(), 2, hospitaleiro1, cliente2, pet2);
        
        Creche creche1 = new Creche(1, "09/04/2022", "10/04/2022", "09:00", "12:00", 3, hospitaleiro2, cliente1, pet1);
        
        // Adicionar elementos em ArrayList
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        
        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);
        pets.add(pet5);
        pets.add(pet6);
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        
        hospitaleiros.add(hospitaleiro1);
        hospitaleiros.add(hospitaleiro2);
        
        hospedagens.add(hospedagem1);
        hospedagens.add(hospedagem2);
        
        passeios.add(passeio1);
        
        creches.add(creche1);
    }
    
    /* Getters and setters */
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        BancoDeDados.usuarios = usuarios;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        BancoDeDados.clientes = clientes;
    }

    public static ArrayList<Pet> getPets() {
        return pets;
    }

    public static void setPets(ArrayList<Pet> pets) {
        BancoDeDados.pets = pets;
    }

    public static ArrayList<Hospitaleiro> getHospitaleiros() {
        return hospitaleiros;
    }

    public static void setHospitaleiros(ArrayList<Hospitaleiro> hospitaleiros) {
        BancoDeDados.hospitaleiros = hospitaleiros;
    }

    public static ArrayList<Hospedagem> getHospedagens() {
        return hospedagens;
    }

    public static void setHospedagens(ArrayList<Hospedagem> hospedagens) {
        BancoDeDados.hospedagens = hospedagens;
    }

    public static ArrayList<Passeio> getPasseios() {
        return passeios;
    }

    public static void setPasseios(ArrayList<Passeio> passeios) {
        BancoDeDados.passeios = passeios;
    }
}

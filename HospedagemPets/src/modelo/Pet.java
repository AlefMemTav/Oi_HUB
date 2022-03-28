package modelo;

public class Pet {
    private int id;
    private int idDono;
    private String nome;
    private String castramento;
    private String especie;
    private String genero;
    private String raca;
    private String tamanho;

    public Pet(int id, int idDono, String nome, String castramento, String especie, String genero, String raca, String tamanho) {
        this.id = id;
        this.idDono = idDono;
        this.nome = nome;
        this.castramento = castramento;
        this.especie = especie;
        this.genero = genero;
        this.raca = raca;
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDono() {
        return idDono;
    }

    public void setIdDono(int idDono) {
        this.idDono = idDono;
    }
   
    public Pet(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCastramento() {
        return castramento;
    }

    public void setCastramento(String castramento) {
        this.castramento = castramento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
package br.pro.adalto.appmedca;

public class Consulta {

    public String id;
    public String nome, data;
    public Genero genero;


    public Consulta() {

    }

    public Consulta(String nome, String data, Genero genero) {
        this.nome = nome;
        this.data = data;
        this.genero = genero;
    }

    public Consulta(String id, String nome, String data, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  nome + '\n' + data + '\n' + genero.getNome();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return nome;
    }

    public void setTitulo(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return data;
    }

    public void setAutor(String data) {
        this.data = data;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}

package entities;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private String name;
    private String biography;
    private List<Livro> livrosDeSuaAutoria = new ArrayList<>();

    public Autor(String name) {
        this.name = name;
    }

    public Autor(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public List<Livro> getLivrosDeSuaAutoria() {
        return livrosDeSuaAutoria;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void addBookToAutor(Livro book){
        livrosDeSuaAutoria.add(book);
    }

    public void removeAutorBook(Livro book){
        livrosDeSuaAutoria.remove(book);
    }
}

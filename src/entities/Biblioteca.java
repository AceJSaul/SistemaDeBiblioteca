package entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String name;
    private List<Livro> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();

    public Biblioteca(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Livro> getBooks() {
        return books;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addBook(Livro book){
        books.add(book);
    }

    public void removeBook(Livro book){
        books.remove(book);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void addAutor(Autor autor){
        autores.add(autor);
    }

    public void removeAutor(Autor autor){
        autores.remove(autor);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Usuários: ");
        for (User user : users){
            sb.append(user.getName() + ", " + user.getEmail() + "\n");
        }

        sb.append("\n Livros: ");
        for (Livro livro : books){
            sb.append(livro.getTitle() + ", " + livro.getWriter() + "\n");
        }

        return sb.toString();
    }
}

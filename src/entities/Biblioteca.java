package entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String name;
    private List<Livro> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Biblioteca(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Livro> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addBook(Livro book){
        books.add(book);
    }
    public void addUser(User user){
        users.add(user);
    }
}

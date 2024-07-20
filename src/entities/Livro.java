package entities;

public class Livro {

    private String title;
    private String isbn;
    private Autor writer;

    public Livro(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Livro(String title, String isbn, Autor writer) {
        this.title = title;
        this.isbn = isbn;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getWriter() {
        return writer;
    }

    @Override
    public String toString(){
        return title + ", " + writer.getName() + ", " + isbn;
    }
}

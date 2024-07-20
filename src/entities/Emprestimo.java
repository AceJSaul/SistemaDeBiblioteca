package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {

    private DateTimeFormatter dateFt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Livro livro;
    private User usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    // Constructor com data de devolução padrão
    public Emprestimo(Livro livro, User usuario, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataEmprestimo.plusWeeks(2);
    }

    // Constructor com data de devolução customizada
    public Emprestimo(Livro livro, User usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public User getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(usuario.getName() + ", ");
        sb.append(usuario.getMatriculaNum());
        sb.append("\n");
        sb.append(livro.getTitle());
        sb.append(", ");
        sb.append(livro.getWriter().getName());
        sb.append(", ");
        sb.append(dataEmprestimo.format(dateFt));
        sb.append(", ");
        sb.append(dataDevolucao.format(dateFt));
        sb.append("\n");

        return sb.toString();
    }
}

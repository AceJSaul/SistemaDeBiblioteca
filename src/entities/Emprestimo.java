package entities;

import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private User usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao = dataEmprestimo.plusWeeks(2);

    // Constructor com data de devolução padrão
    public Emprestimo(Livro livro, User usuario, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
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
}

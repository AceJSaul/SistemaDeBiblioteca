package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int matriculaNum;
    private List<Emprestimo> emprestimoList = new ArrayList<>();

    public User(String name, int matriculaNum) {
        this.name = name;
        this.matriculaNum = matriculaNum;
    }

    public String getName() {
        return name;
    }

    public int getMatriculaNum() {
        return matriculaNum;
    }

    public List<Emprestimo> getEmprestimoList() {
        return emprestimoList;
    }

    public void addEmprestimo(Emprestimo emprestimo){
        emprestimoList.add(emprestimo);
    }

    public void removeEmprestimo(Emprestimo emprestimo){
        emprestimoList.remove(emprestimo);
    }
}

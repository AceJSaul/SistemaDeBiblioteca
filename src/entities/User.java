package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private int matriculaNum;
    private List<Emprestimo> emprestimoList = new ArrayList<>();

    public User(String name, String email, int matriculaNum) {
        this.name = name;
        this.email = email;
        this.matriculaNum = matriculaNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getMatriculaNum() {
        return matriculaNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Username: ");
        sb.append(name + "\n");
        sb.append("Email: ");
        sb.append(email + "\n");
        sb.append("Empréstimos:");

        for(Emprestimo emprestimo : emprestimoList){
            sb.append(emprestimo.showOnlyLoan() + "\n");
        }

        return sb.toString();
    }
}

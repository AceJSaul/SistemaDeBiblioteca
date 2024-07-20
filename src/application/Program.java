package application;

import entities.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    public static Scanner sc = new Scanner(System.in);
    public static Biblioteca mainBiblioteca = new Biblioteca("Biblioteca");

    public static void main(String[] args){
        System.out.print("Nome da Biblioteca: ");

        showMenu();

        int userChoice = sc.nextInt();

        while (userChoice != 9){
            switch (userChoice){
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    removeUser();
                    break;
                case 5:
                    emprestar();
                    break;
                case 6:
                    listaDeLivros();
                    break;
                case 7:
                    listaDeUsers();
                    break;
                case 8:
                    listaDeEmprestimos();
                    break;
            }

            System.out.println();
            showMenu();
            userChoice = sc.nextInt();
        }

    }

    public static void showMenu(){
        System.out.println("Digite a operação desejada:");
        System.out.println("1 - Adicionar livro à biblioteca");
        System.out.println("2 - Retirar livro da biblioteca");
        System.out.println("3 - Adicionar usuário à biblioteca");
        System.out.println("4 - Remover usuário da biblioteca");
        System.out.println("5 - Realizar Empréstimo");
        System.out.println("6 - Mostrar lista de livros");
        System.out.println("7 - Mostrar lista de usuários");
        System.out.println("8 - Mostrar lista de empréstimos");
        System.out.println("9 - Sair.");

        System.out.println();
    }

    public static void addBook(){
        sc.nextLine();
        System.out.print("Nome do livro: ");
        String bookName = sc.nextLine();
        System.out.print("Código ISBN: ");
        String isbn = sc.nextLine();

        // Criando Autor
        System.out.print("Autor: ");
        String nomeDoAutor = sc.nextLine();

        boolean isAuthorRegistered = false;
        for(Autor autor : mainBiblioteca.getAutores()){
            if(autor.getName().equals(nomeDoAutor)){
                Livro newLivro = new Livro(bookName, isbn, autor);
                mainBiblioteca.addBook(newLivro);

                isAuthorRegistered = true;

                if(autor.getBiography() == null){
                    System.out.print("Deseja adicionar biografia do autor?(s/n) ");
                    String userResponse = sc.nextLine();

                    if (userResponse.toLowerCase().equals("s") || userResponse.toLowerCase().equals("sim")){
                        autor.setBiography(sc.nextLine());
                    }
                }
                break;
            }
        }

        if(!isAuthorRegistered){
            System.out.print("Deseja adicionar biografia do autor?(s/n) ");
            String userResponse = sc.nextLine();

            Autor autor;
            if (userResponse.toLowerCase().equals("s") || userResponse.toLowerCase().equals("sim")){
                String biography = sc.nextLine();
                autor = new Autor(nomeDoAutor, biography);
            }
            else{
                autor = new Autor(nomeDoAutor);
            }
            // Adicionando autor à biblioteca
            mainBiblioteca.addAutor(autor);
            // Adicionando livro à lista de livros da biblioteca
            Livro newLivro = new Livro(bookName, isbn, autor);
            mainBiblioteca.addBook(newLivro);
            System.out.println("Livro adicionado com sucesso");
        }
    }

    public static void removeBook(){
        sc.nextLine();
        System.out.print("Qual o título do livro que deseja retirar? ");
        String livroTitle = sc.nextLine();

        for (Livro livro : mainBiblioteca.getBooks()){
            if (livroTitle.equals(livro.getTitle())){
                mainBiblioteca.removeBook(livro);
                System.out.println("Livro retirado com sucesso");
                break;
            }
        }
    }

    public static void addUser(){
        sc.nextLine();
        System.out.print("Nome do Usuário: ");
        String userName = sc.nextLine();
        System.out.print("Email do Usuário: ");
        String email = sc.nextLine();
        System.out.print("Número de matrícula: ");
        int matriculaNum = sc.nextInt();

        User usuario = new User(userName, email, matriculaNum);
        mainBiblioteca.addUser(usuario);
        System.out.println("Usuário adicionado!");
    }

    public static void removeUser(){
        sc.nextLine();
        System.out.println("Número de matrícula do usuário que deseja remover: ");
        int numeroARemover = sc.nextInt();

        for (User usuario : mainBiblioteca.getUsers()){
            if (usuario.getMatriculaNum() == numeroARemover){
                mainBiblioteca.removeUser(usuario);
                mainBiblioteca.getEmprestimos().removeIf(emprestimo -> emprestimo.getUsuario() == usuario);
                System.out.println("Usuário removido");
                break;
            }
        }
    }

    public static void emprestar(){
        sc.nextLine();

        System.out.print("Código do livro será emprestado: ");
        String codigoDoLivroEmprestado = sc.nextLine();

        // Procurando Livro
        Livro livroAEmprestar;
        for (Livro livro : mainBiblioteca.getBooks()){
            if (livro.getIsbn().equals(codigoDoLivroEmprestado)){
                livroAEmprestar = livro;
                // Identificando usuário
                System.out.print("Número da matrícula do usuário do empréstimo: ");
                int userMatricula = sc.nextInt();
                sc.nextLine();
                System.out.print("Data do empréstimo (dd/mm/yyyy): ");
                String dataDeEmprestimo = sc.nextLine();

                // Convertendo a String data para LocalTime
                String[] date = dataDeEmprestimo.split("/");
                LocalDate dataDeEmprestar = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

                // Procurando usuário a quem emprestar
                for (User usuario : mainBiblioteca.getUsers()){
                    if (usuario.getMatriculaNum() == userMatricula){
                        Emprestimo emprestimoUser = new Emprestimo(livroAEmprestar, usuario, dataDeEmprestar);
                        usuario.addEmprestimo(emprestimoUser);
                        mainBiblioteca.addEmprestimo(emprestimoUser);
                        System.out.println("Empréstimo realizado!");
                        break;
                    }
                }
            }
        }
    }

    public static void listaDeLivros(){
        for (Livro livro : mainBiblioteca.getBooks()){
            System.out.println(livro);
        }
    }

    public static void listaDeUsers(){
        for (User user : mainBiblioteca.getUsers()){
            System.out.println(user);
        }
    }

    public static void listaDeEmprestimos(){
        for (Emprestimo emprestimo : mainBiblioteca.getEmprestimos()){
            System.out.println(emprestimo);
        }
    }
}

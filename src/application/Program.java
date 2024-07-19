package application;

import entities.Autor;
import entities.Biblioteca;
import entities.Livro;
import entities.User;

import java.util.Scanner;

public class Program {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.print("Nome da Biblioteca: ");
        String nomeDaBiblioteca = sc.nextLine();
        Biblioteca mainBiblioteca = new Biblioteca(nomeDaBiblioteca);

        showMenu();

        int userChoice = sc.nextInt();

        while (userChoice != 9){
            switch (userChoice){
                case 1:
                    addBook(mainBiblioteca);
                    break;
                case 2:
                    removeBook(mainBiblioteca);
                    break;
                case 3:
                    addUser(mainBiblioteca);
                    break;
                case 4:
                    removeUser(mainBiblioteca);
                    break;

            }


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

    public static void addBook(Biblioteca biblioteca){
        sc.nextLine();
        System.out.print("Nome do livro: ");
        String bookName = sc.nextLine();
        System.out.print("Código ISBN: ");
        String isbn = sc.nextLine();

        // Criando Autor
        System.out.print("Autor: ");
        String nomeDoAutor = sc.nextLine();

        boolean isAuthorRegistered = false;
        for(Autor autor : biblioteca.getAutores()){
            if(autor.getName().equals(nomeDoAutor)){
                Livro newLivro = new Livro(bookName, isbn, autor);
                biblioteca.addBook(newLivro);

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
            biblioteca.addAutor(autor);
            // Adicionando livro à lista de livros da biblioteca
            Livro newLivro = new Livro(bookName, isbn, autor);
            biblioteca.addBook(newLivro);
            System.out.println("Livro adicionado com sucesso");
        }
    }

    public static void removeBook(Biblioteca biblioteca){
        sc.nextLine();
        System.out.print("Qual o título do livro que deseja retirar? ");
        String livroTitle = sc.nextLine();

        for (Livro livro : biblioteca.getBooks()){
            if (livroTitle.equals(livro.getTitle())){
                biblioteca.removeBook(livro);
                System.out.println("Livro retirado com sucesso");
                break;
            }
        }
    }

    public static void addUser(Biblioteca biblioteca){
        sc.nextLine();
        System.out.print("Nome do Usuário: ");
        String userName = sc.nextLine();
        System.out.print("Email do Usuário: ");
        String email = sc.nextLine();
        System.out.print("Número de matrícula: ");
        int matriculaNum = sc.nextInt();

        User usuario = new User(userName, email, matriculaNum);
        biblioteca.addUser(usuario);
    }

    public static void removeUser(Biblioteca biblioteca){
        sc.nextLine();
        System.out.println("Número de matrícula do usuário que deseja remover: ");
        int numeroARemover = sc.nextInt();

        for (User usuario : biblioteca.getUsers()){
            if (usuario.getMatriculaNum() == numeroARemover){
                biblioteca.removeUser(usuario);
                System.out.println("Usuário removido");
                break;
            }
        }
    }

    public static void emprestar(Biblioteca biblioteca){

    }
}

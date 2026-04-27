package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Livros iniciais
        livros.add(new Livro("Senhor dos Aneis", "Tolkien", "Fantasia", 1954, 1, true));
        livros.add(new Livro("Pai Rico Pai Pobre", "Kiyosaki", "Finanças", 1997, 2, true));
        livros.add(new Livro("A Cabana", "William Young", "Ficção", 2007, 3, true));

        // Usuários iniciais
        usuarios.add(new Usuario("Ana", 1));
        usuarios.add(new Usuario("Carlos", 2));

        int opcao;

        do {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Emprestar livro");
            System.out.println("3 - Devolver livro");
            System.out.println("4 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- LIVROS ---");
                    for (Livro l : livros) {
                        System.out.println("----------------------");
                        l.mostrarInformacoes();
                    }
                    break;

                case 2:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuarioE = sc.nextInt();
                    System.out.print("Digite o ID do livro: ");
                    int idLivroE = sc.nextInt();

                    Usuario usuarioE = null;
                    Livro livroE = null;

                    for (Usuario u : usuarios)
                        if (u.getIdentificador() == idUsuarioE) usuarioE = u;

                    for (Livro l : livros)
                        if (l.getIdentificador() == idLivroE) livroE = l;

                    if (usuarioE != null && livroE != null) {
                        usuarioE.pegarLivro(livroE);
                    } else {
                        System.out.println("Usuário ou livro não encontrado!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuarioD = sc.nextInt();
                    System.out.print("Digite o ID do livro: ");
                    int idLivroD = sc.nextInt();

                    Usuario usuarioD = null;
                    Livro livroD = null;

                    for (Usuario u : usuarios)
                        if (u.getIdentificador() == idUsuarioD) usuarioD = u;

                    for (Livro l : livros)
                        if (l.getIdentificador() == idLivroD) livroD = l;

                    if (usuarioD != null && livroD != null) {
                        usuarioD.devolverLivro(livroD);
                    } else {
                        System.out.println("Usuário ou livro não encontrado!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- USUÁRIOS ---");
                    for (Usuario u : usuarios) {
                        System.out.println("----------------------");
                        u.mostrarInformacoes();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
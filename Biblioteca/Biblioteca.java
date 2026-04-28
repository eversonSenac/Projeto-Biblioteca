package Biblioteca;

import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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

            try {
                switch (opcao) {

                    case 1:
                        System.out.println("\n--- LIVROS ---");
                        System.out.println(SupabaseClient.getLivros());
                        break;

                    case 2:
                        System.out.print("Digite o ID do livro: ");
                        int idEmprestar = sc.nextInt();
                        SupabaseClient.emprestarLivro(idEmprestar);
                        break;

                    case 3:
                        System.out.print("Digite o ID do livro: ");
                        int idDevolver = sc.nextInt();
                        SupabaseClient.devolverLivro(idDevolver);
                        break;

                    case 4:
                        System.out.println("\n--- USUÁRIOS ---");
                        System.out.println(SupabaseClient.getUsuarios());
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("❌ Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}
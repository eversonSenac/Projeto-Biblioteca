package Biblioteca;

public class Livro {

    String titulo;
    String autor;
    String genero;
    int anoPublicacao;
    int identificador;
    boolean disponivel;

    public Livro(String titulo, String autor, String genero, int anoPublicacao, int identificador, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.identificador = identificador;
        this.disponivel = disponivel;
    }

    public void mostrarInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("ID: " + identificador);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não disponível para empréstimo!");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Livro já está disponível!");
        }
    }

    public int getIdentificador() { return identificador; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public boolean isDisponivel() { return disponivel; }
}
package Biblioteca;

import java.util.ArrayList;

public class Usuario {

    String nome;
    int identificador;
    ArrayList<Livro> livrosEmprestados;

    public Usuario(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
        this.livrosEmprestados = new ArrayList<>();
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + identificador);
        System.out.println("Livros emprestados: " + livrosEmprestados.size());
    }

    public void pegarLivro(Livro livro) {
        livrosEmprestados.add(livro);
        livro.emprestar();
    }

    public void devolverLivro(Livro livro) {
        livrosEmprestados.remove(livro);
        livro.devolver();
    }

    public int getIdentificador() { return identificador; }
    public String getNome() { return nome; }
    public ArrayList<Livro> getLivrosEmprestados() { return livrosEmprestados; }
}
package Biblioteca;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SupabaseClient {

    private static final String URL = "https://kbktnfmeznoqpkrsgfln.supabase.co";
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imtia3RuZm1lem5vcXBrcnNnZmxuIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzY5Nzc5OTIsImV4cCI6MjA5MjU1Mzk5Mn0.zbIsEPCfQRe7yaChbSDsGNuwHSEgl2yWcoTg1EdIk2c";

    private static HttpClient client = HttpClient.newHttpClient();

    // Buscar todos os livros
    public static String getLivros() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(URL + "/rest/v1/livros?select=*"))
            .header("apikey", API_KEY)
            .header("Authorization", "Bearer " + API_KEY)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Buscar todos os usuários
    public static String getUsuarios() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(URL + "/rest/v1/usuarios?select=*"))
            .header("apikey", API_KEY)
            .header("Authorization", "Bearer " + API_KEY)
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // Emprestar livro (atualiza disponivel para false)
    public static void emprestarLivro(int id) throws Exception {
        String body = "{\"disponivel\": false}";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(URL + "/rest/v1/livros?id=eq." + id))
            .header("apikey", API_KEY)
            .header("Authorization", "Bearer " + API_KEY)
            .header("Content-Type", "application/json")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
            .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("✅ Livro emprestado no banco!");
    }

    // Devolver livro (atualiza disponivel para true)
    public static void devolverLivro(int id) throws Exception {
        String body = "{\"disponivel\": true}";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(URL + "/rest/v1/livros?id=eq." + id))
            .header("apikey", API_KEY)
            .header("Authorization", "Bearer " + API_KEY)
            .header("Content-Type", "application/json")
            .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
            .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("✅ Livro devolvido no banco!");
    }
}
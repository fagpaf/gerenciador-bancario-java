package Lista.q1;

public class MainJavaTunes {
    public static void main(String[] args) {
        Musica musica = new Musica("Bohemian Rhapsody", "Queen", 354, "Rock");
        Podcast podcast = new Podcast("DevCast", "TechBR", 3600, 42);
        AudioLivro audioLivro = new AudioLivro("O Senhor dos Anéis", "J.R.R. Tolkien", 54000, "Mauro Ramos");

        System.out.println("--- Testando Reproduções ---");
        musica.reproduzir();
        podcast.reproduzir();
        audioLivro.reproduzir();
        
        System.out.println("\n--- Testando Sobrecarga ---");
        musica.reproduzir(1.5);

        System.out.println("\n--- Testando Avaliações ---");
        musica.avaliar(5);
        musica.avaliar(4);
        musica.avaliar(5);
        System.out.println("Média da música (" + musica.titulo + "): " + musica.getMediaAvaliacoes());

        audioLivro.avaliar(4);
        audioLivro.avaliar(4);
        audioLivro.avaliar(3);
        System.out.println("Média do audiolivro (" + audioLivro.titulo + "): " + audioLivro.getMediaAvaliacoes());

        System.out.println("\n--- Contador Global ---");
        System.out.println("Total de reproduções na plataforma: " + Midia.getTotalReproducoes());
    }
}

package Lista.q1;

public class Podcast extends Midia {
    private int episodio;

    public Podcast(String titulo, String autor, int duracaoEmSegundos, int episodio) {
        super(titulo, autor, duracaoEmSegundos);
        this.episodio = episodio;
    }

    @Override
    public void reproduzir() {
        incrementarReproducoes();
        System.out.println("Tocando podcast: " + titulo + " - Ep " + episodio);
    }

    @Override
    public String tipoDeMidia() {
        return "Podcast";
    }
}
package Lista.q1;

abstract class Midia {
    protected String titulo;
    protected String autor;
    protected int duracaoEmSegundos;
    private static int totalReproducoes = 0;

    public Midia(String titulo, String autor, int duracaoEmSegundos) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracaoEmSegundos = duracaoEmSegundos;
    }

    public abstract void reproduzir();
    public abstract String tipoDeMidia();

    public String getDuracaoFormatada() {
        int minutos = duracaoEmSegundos / 60;
        int segundos = duracaoEmSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public static int getTotalReproducoes() {
        return totalReproducoes;
    }

    protected void incrementarReproducoes() {
        totalReproducoes++;
    }
}
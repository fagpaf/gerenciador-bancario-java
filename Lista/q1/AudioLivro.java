package Lista.q1;

import java.util.ArrayList;
import java.util.List;

class AudioLivro extends Midia implements Avaliavel {
    private String narrador;
    private List<Integer> notas;

    public AudioLivro(String titulo, String autor, int duracaoEmSegundos, String narrador) {
        super(titulo, autor, duracaoEmSegundos);
        this.narrador = narrador;
        this.notas = new ArrayList<>();
    }

    @Override
    public void reproduzir() {
        incrementarReproducoes();
        System.out.println("Lendo audiolivro: " + titulo + " (Narrador: " + narrador + ")");
    }

    @Override
    public String tipoDeMidia() {
        return "Audiolivro";
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 1 && nota <= 5) notas.add(nota);
    }

    @Override
    public double getMediaAvaliacoes() {
        if (notas.isEmpty()) return 0.0;
        double soma = 0;
        for (int n : notas) soma += n;
        return soma / notas.size();
    }
}

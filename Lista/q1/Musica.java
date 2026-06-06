package Lista.q1;

import java.util.ArrayList;
import java.util.List;

class Musica extends Midia implements Avaliavel {
    private String genero;
    private List<Integer> notas;

    public Musica(String titulo, String autor, int duracaoEmSegundos, String genero) {
        super(titulo, autor, duracaoEmSegundos);
        this.genero = genero;
        this.notas = new ArrayList<>();
    }

    @Override
    public void reproduzir() {
        incrementarReproducoes();
        System.out.println("Tocando música: " + titulo + " de " + autor);
    }

    // Sobrecarga de método
    public void reproduzir(double velocidade) {
        incrementarReproducoes();
        System.out.println("Tocando música: " + titulo + " na velocidade " + velocidade + "x");
    }

    @Override
    public String tipoDeMidia() {
        return "Música";
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 1 && nota <= 5) {
            notas.add(nota);
        } else {
            System.out.println("Nota inválida! Use valores de 1 a 5.");
        }
    }

    @Override
    public double getMediaAvaliacoes() {
        if (notas.isEmpty()) return 0.0;
        double soma = 0;
        for (int n : notas) soma += n;
        return soma / notas.size();
    }
}
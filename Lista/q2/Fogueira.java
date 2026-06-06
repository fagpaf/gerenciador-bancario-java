package Lista.q2;

class Fogueira implements Restauracao {
    private double eficiencia;

    public Fogueira(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public void restaurar(Personagem personagem, double quantidadeRecuperada) {
        personagem.setVidaAtual(personagem.getVidaAtual() + quantidadeRecuperada);
        System.out.println("Vida restaurada! Vida atual: " + personagem.getVidaAtual() + "/" + personagem.getVidaMaxima());
        calcularDuracao(quantidadeRecuperada);
    }

    @Override
    public void calcularDuracao(double quantidadeRecuperada) {
        double tempo = quantidadeRecuperada / eficiencia;
        System.out.println("Duração do descanso na fogueira: " + String.format("%.2f", tempo) + " segundos.\n");
    }
}
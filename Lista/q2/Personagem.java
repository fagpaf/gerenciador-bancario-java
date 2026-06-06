package Lista.q2;

enum TipoEnergia {
    MANA, ESTAMINA
}

class Personagem {
    private double vidaAtual;
    private double vidaMaxima;
    private double energiaAtual;
    private double energiaMaxima;
    private TipoEnergia tipo;

    public Personagem(double vidaMaxima, double energiaMaxima, TipoEnergia tipo) {
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima / 2; // Começa com metade para testes
        this.energiaMaxima = energiaMaxima;
        this.energiaAtual = energiaMaxima / 2;
        this.tipo = tipo;
    }

    public double getVidaAtual() { return vidaAtual; }
    public void setVidaAtual(double vidaAtual) { this.vidaAtual = Math.min(vidaAtual, vidaMaxima); }
    public double getVidaMaxima() { return vidaMaxima; }

    public double getEnergiaAtual() { return energiaAtual; }
    public void setEnergiaAtual(double energiaAtual) { this.energiaAtual = Math.min(energiaAtual, energiaMaxima); }
    public double getEnergiaMaxima() { return energiaMaxima; }

    public TipoEnergia getTipo() { return tipo; }
}
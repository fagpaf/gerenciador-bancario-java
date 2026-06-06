package Lista.q2;

class Acampamento implements Restauracao{
    private double eficiencia;

    public Acampamento(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public void restaurar(Personagem personagem, double quantidadeRecuperada) throws EnergiaIncompativelException {
        if (personagem.getTipo() != TipoEnergia.ESTAMINA) {
            throw new EnergiaIncompativelException("Erro: O personagem não utiliza ESTAMINA!");
        }
        personagem.setEnergiaAtual(personagem.getEnergiaAtual() + quantidadeRecuperada);
        System.out.println("Estamina restaurada! Energia atual: " + personagem.getEnergiaAtual() + "/" + personagem.getEnergiaMaxima());
        calcularDuracao(quantidadeRecuperada);
    }

    @Override
    public void calcularDuracao(double quantidadeRecuperada) {
        double tempo = quantidadeRecuperada / eficiencia;
        System.out.println("Duração do descanso no Acampamento: " + String.format("%.2f", tempo) + " segundos.\n");
    }
}
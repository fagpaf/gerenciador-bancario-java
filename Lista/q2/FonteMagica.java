package Lista.q2;

class FonteMagica implements Restauracao {
    private double eficiencia;

    public FonteMagica(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    @Override
    public void restaurar(Personagem personagem, double quantidadeRecuperada) throws EnergiaIncompativelException {
        if (personagem.getTipo() != TipoEnergia.MANA) {
            throw new EnergiaIncompativelException("Erro: O personagem não utiliza MANA!");
        }
        personagem.setEnergiaAtual(personagem.getEnergiaAtual() + quantidadeRecuperada);
        System.out.println("Mana restaurada! Energia atual: " + personagem.getEnergiaAtual() + "/" + personagem.getEnergiaMaxima());
        calcularDuracao(quantidadeRecuperada);
    }

    @Override
    public void calcularDuracao(double quantidadeRecuperada) {
        double tempo = quantidadeRecuperada / eficiencia;
        System.out.println("Duração do descanso na Fonte Mágica: " + String.format("%.2f", tempo) + " segundos.\n");
    }
}

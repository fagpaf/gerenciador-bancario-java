package Lista.q3;

class Reitor extends Funcionario implements Bonificavel {
    private double gratificacaoCargo;

    public Reitor(String nome, String cpf, double salarioBase, double gratificacaoCargo) {
        super(nome, cpf, salarioBase);
        this.gratificacaoCargo = gratificacaoCargo;
    }

    @Override
    public double calcularSalarioLiquido() {
        double bruto = salarioBase + gratificacaoCargo;
        return bruto - (bruto * 0.11);
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.20;
    }
}


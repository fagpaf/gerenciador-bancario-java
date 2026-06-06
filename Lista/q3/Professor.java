package Lista.q3;

class Professor extends Funcionario implements Bonificavel {
    private int titulacao;

    public Professor(String nome, String cpf, double salarioBase, int titulacao) {
        super(nome, cpf, salarioBase);
        this.titulacao = titulacao;
    }

    @Override
    public double calcularSalarioLiquido() {
        double bruto = salarioBase + (salarioBase * 0.10 * titulacao);
        return bruto - (bruto * 0.11); // Desconto INSS
    }

    @Override
    public double calcularBonus() {
        return salarioBase * 0.05 * titulacao;
    }
}
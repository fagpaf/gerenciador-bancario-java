package Lista.q3;

class TecnicoAdministrativo extends Funcionario {
    private int nivel;

    public TecnicoAdministrativo(String nome, String cpf, double salarioBase, int nivel) {
        super(nome, cpf, salarioBase);
        this.nivel = nivel;
    }

    @Override
    public double calcularSalarioLiquido() {
        double bruto = salarioBase + (nivel * 200.00);
        return bruto - (bruto * 0.11);
    }
}
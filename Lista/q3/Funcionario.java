package Lista.q3;

abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salarioBase;
    private static int totalFuncionarios = 0;

    public Funcionario(String nome, String cpf, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        totalFuncionarios++;
    }

    public abstract double calcularSalarioLiquido();

    public void aumentarSalario(double valor) {
        this.salarioBase += valor;
    }

    public void aumentarSalario(double valor, boolean ehPercentual) {
        if (ehPercentual) {
            this.salarioBase += this.salarioBase * (valor / 100.0);
        } else {
            aumentarSalario(valor);
        }
    }

    public static int getTotalFuncionarios() {
        return totalFuncionarios;
    }
    
    public String getNome() { return nome; }
}
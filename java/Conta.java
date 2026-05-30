public class Conta {
    protected String numero;
    private double saldo;

    // Construtor sem saldo inical
    public Conta(String numeroInicial) {
        this.numero = numeroInicial;
        this.saldo = 0.0;
    }

    // Construtor com um depósito inicial 
    public Conta(String numeroInicial, double saldoInicial) {
        this.numero = numeroInicial;
        this.saldo = saldoInicial;
    }

    // Retorna o próprio objeto atualizado
    public Conta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Conta setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public void debitar(double valor) {
        saldo -= valor;
    }
}

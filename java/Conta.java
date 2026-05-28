public class Conta {
    protected String numero;
    private double saldo;

    // CONSTRUTOR: Tem o mesmo nome da classe e NÃO tem tipo de retorno
    public Conta(String numeroInicial) {
        this.numero = numeroInicial;
        this.saldo = 0.0;
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

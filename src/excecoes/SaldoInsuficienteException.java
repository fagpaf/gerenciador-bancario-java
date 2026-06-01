package excecoes;
public class SaldoInsuficienteException extends Exception{
    private double saldo;
    private String numero;

    public SaldoInsuficienteException(String numero, double saldo) {
        super("Saldo Insuficiente na conta: " + numero );
        this.numero = numero;
        this.saldo = saldo;
    }

    public double getSaldo() {return this.saldo;}
    public String getNumero() {return this.numero;}
}

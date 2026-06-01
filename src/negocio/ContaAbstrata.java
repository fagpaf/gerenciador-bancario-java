package negocio;
import excecoes.SaldoInsuficienteException;
/*
Uma classe abstrata é uma classe que não pode ser instanciada (ou seja, você não pode dar new nela),
mas que serve de superclasse para outras classes.
*/

public abstract class ContaAbstrata {
    private String numero;
    private double saldo;

    public ContaAbstrata(String numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public String getNumero() {return this.numero;}

    public double getSaldo() {return this.saldo;}

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void creditar(double valor) {
        this.saldo = this.saldo + valor;
    }

    public abstract void debitar(double valor) throws SaldoInsuficienteException;
}
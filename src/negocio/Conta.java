package negocio;

import excecoes.SaldoInsuficienteException;

public class Conta extends ContaAbstrata {
    public Conta(String numeroInicial) {
        super(numeroInicial);
    }

    @Override
    public void debitar(double valor) throws SaldoInsuficienteException {
        if (this.getSaldo() < valor) { throw new SaldoInsuficienteException(this.getNumero(), this.getSaldo());}
        
        super.setSaldo(this.getSaldo() - valor);
    }
}

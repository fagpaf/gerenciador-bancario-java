package negocio;

import excecoes.SaldoInsuficienteException;

public class ContaImposto extends ContaAbstrata {
    // Existe apenas uma cópia na memória E o valor é imutável.
    private static final double CPMF = 0.005;

    public ContaImposto(String numero) {
        super(numero);
    }

    @Override
    public void debitar(double valor) throws SaldoInsuficienteException{
        if (this.getSaldo() < valor) { throw new SaldoInsuficienteException(this.getNumero(), this.getSaldo());}

        double imposto = valor * CPMF;
        double total = valor + imposto;
        super.setSaldo(this.getSaldo() - total);
    }
}

public class Conta extends ContaAbstrata {
    public Conta(String numeroInicial) {
        super(numeroInicial);
    }

    @Override
    public void debitar(double valor) {
        super.setSaldo(this.getSaldo() - valor);
    }
}

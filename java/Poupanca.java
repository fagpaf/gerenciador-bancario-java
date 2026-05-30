public class Poupanca extends Conta {

    public Poupanca(String numero) {
        super(numero);
    }

    public void renderJuros(double taxa) {
        double juros = taxa * getSaldo();
        creditar(juros);
    }
}

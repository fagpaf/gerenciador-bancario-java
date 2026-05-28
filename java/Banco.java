import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;
    private int idx;

    public Banco() {
        this.contas = new ArrayList<Conta>(100);
        this.idx = 0;

        for (int i = 0; i < 100; i++) {this.contas.add(null);}
    }

    public void cadastrar(Conta novaConta) {
        if (idx < 100) {
            this.contas.set(idx, novaConta);
            this.idx++;
        } else {
            System.out.println("Erro: O banco já atingiu o limite de 100 contas!");
        }
    }

    public void creditar(String numero, double valor) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                contaAtual.creditar(valor);
                return; // Achou e alterou, pode sair do método
            }
        }
        System.out.println("Erro: Conta " + numero + " não encontrada!");
    }

    public void debitar(String numero, double valor) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                contaAtual.debitar(valor);
                return;
            }
        }
        System.out.println("Erro: Conta " + numero + " não encontrada!");
    }

    public double getSaldo(String numero) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                return contaAtual.getSaldo();
            }
        }
        System.out.println("Erro: Conta " + numero + " não encontrada!");
        return -1;
    }

}
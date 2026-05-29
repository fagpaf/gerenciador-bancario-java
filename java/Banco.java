import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas;
    private int idx;
    private double taxa;

    public Banco() {
        this.contas = new ArrayList<Conta>(100);
        this.idx = 0;
        this.taxa = 0.15;

        for (int i = 0; i < 100; i++) {this.contas.add(null);}
    }

    public void cadastrar(Conta novaConta) {
        if (idx < 100) {
            this.contas.set(idx, novaConta);
            this.idx++;
        } else {
            System.out.println("O banco atingiu o limite de 100 contas!");
        }
    }

    public void creditar(String numero, double valor) {
        // Percorre o array de contas usando o índice atual
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            // Encontrou a conta com o número certo?
            if (contaAtual.getNumero().equals(numero)) {
                contaAtual.creditar(valor);
                return; // Achou e alterou, pode sair do método
            }
        }
        printError(numero);
    }

    public void debitar(String numero, double valor) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                contaAtual.debitar(valor);
                return;
            }
        }
        printError(numero);
    }

    public void renderJuros(String numero) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                // Verificando se a conta realmente é uma Poupanca
                if (contaAtual instanceof Poupanca) {
                    ((Poupanca) contaAtual).renderJuros(this.taxa); 
                    return;
                } 
                else {
                    throw new RuntimeException("Não é do tipo Poupança!");
                }
            }
        }
        printError(numero);
    }

    public void renderBonus(String numero) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                // Verificando se é uma conta do tipo Especial
                if (contaAtual instanceof ContaEspecial) {
                    // Faz o "Casting" (conversão) para o Java liberar os métodos da ContaEspecial
                    ContaEspecial especialAtual = (ContaEspecial) contaAtual;
                    especialAtual.renderBonus();
                    return;
                }
                else {
                    throw new RuntimeException("Não é do tipo Especial");
                }
            }
        }
        System.out.println("Erro: Conta especial não encontrada!");
    }

    public void transferir(String numeroPagador, String numeroRecebedor, double valor) {
        Conta pagador = null;
        Conta recebedor = null;
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numeroPagador)) {
                pagador = contaAtual;
            }

            if (contaAtual.getNumero().equals(numeroRecebedor)) {
                recebedor = contaAtual;
            }
        
        if (pagador == null || recebedor == null) {
            System.out.println("Erro: Verififque o numero das Contas");
            return;
        }
        
        pagador.debitar(valor);
        recebedor.creditar(valor);
        }
    }

    public double getSaldo(String numero) {
        for (int i = 0; i < this.idx; i++) {
            Conta contaAtual = this.contas.get(i);
            if (contaAtual.getNumero().equals(numero)) {
                return contaAtual.getSaldo();
            }
        }
        printError(numero);
        return -1;
    }

    public void printError(String numero) {
        System.out.println("Erro: Conta " + numero + " não encontrada!");
    }


}
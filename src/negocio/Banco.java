package negocio;
import repositorio.RepositorioContas;

public class Banco {
    // Atributo crucial para desacoplar o Banco do tipo de armazenamento
    private RepositorioContas contas;
    private double taxa;

    // O construtor recebe qualquer implementação de RepositorioContas
    public Banco(RepositorioContas repositorio) {
        this.contas = repositorio;
        this.taxa = 0.02;
    }    

    public void creditar(String numero, double valor) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta == null) {
            printError(numero);
        }
        conta.creditar(valor);
    }

    public void debitar(String numero, double valor) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta == null) {
            printError(numero);
        }
        conta.debitar(valor);
    }

    public void renderJuros(String numero) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta == null) {
            printError(numero);
        }

        if (conta instanceof Poupanca) {
            ((Poupanca) conta).renderJuros(this.taxa);
        } else {
            throw new RuntimeException("Erro: Conta " + numero + " não é do tipo Poupança!");
        }
    }

    public void renderBonus(String numero) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta == null) {
            printError(numero);
        }
        
        if (conta instanceof ContaEspecial) {
            ((ContaEspecial) conta).renderBonus();
        } else {
            throw new RuntimeException("Erro: Conta " + numero + " não é do tipo Especial!");
        }
    }

    public void transferir(String numeroPagador, String numeroRecebedor, double valor) {
        ContaAbstrata pagador = contas.procurar(numeroPagador);
        if (pagador == null) {
            printError(numeroPagador);
        }

        ContaAbstrata recebedor = contas.procurar(numeroRecebedor);
        if (recebedor == null) {
            printError(numeroRecebedor);
        }
        
        if (pagador == recebedor) {
            throw new RuntimeException("Erro: Não é possível transferir para a mesma conta!");
        }
        
        pagador.debitar(valor);
        recebedor.creditar(valor);
    }

    public double getSaldo(String numero) {
        ContaAbstrata conta = contas.procurar(numero);
        if (conta == null) {
            printError(numero);
        }
        return conta.getSaldo();
    }

    public void printError(String numero) {
        throw new RuntimeException("Erro: Conta " + numero + " não encontrada!");
    }
}
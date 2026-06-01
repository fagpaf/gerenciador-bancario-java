package repositorio;
import java.util.ArrayList;

import negocio.ContaAbstrata;

public class RepositorioContasArray implements RepositorioContas {
    
    private ArrayList<ContaAbstrata> contas;

    public RepositorioContasArray() {
        this.contas = new ArrayList<ContaAbstrata>();
    }

    public void inserir(ContaAbstrata novaConta) {
        // Se o array é maior ou igual a 100 e se a consta já existe no array
        if (this.contas.size() >= 100 || existe(novaConta.getNumero())) {
            printError(novaConta.getNumero());
        } 
        this.contas.add(novaConta);
    }

    public ContaAbstrata procurar(String numero) {
        for (ContaAbstrata contaAtual : this.contas) {
            if (contaAtual.getNumero().equals(numero)) {
                return contaAtual;
            }
        }
        return null;
    }

    public void remover(String numero) {
        ContaAbstrata contaAtual = procurar(numero);
        if (contaAtual == null) {
            printError(numero);
        }
        this.contas.remove(contaAtual);
    }

    public void atualizar(ContaAbstrata conta) {
        ContaAbstrata contaAntiga = procurar(conta.getNumero());
        if (contaAntiga == null) {
            printError(conta.getNumero());
        }
        this.contas.remove(contaAntiga);
        this.contas.add(conta);
    }

    public boolean existe(String numero) {
        ContaAbstrata contaAtual = procurar(numero);
        if (contaAtual == null) {
            return false;
        }
        return true;
    }

    public void printError(String numero) {
        throw new RuntimeException("Erro: Conta " + numero + " não encontrada!");
    }

}
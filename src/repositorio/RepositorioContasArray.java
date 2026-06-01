package repositorio;
import java.util.ArrayList;
import excecoes.ContaNaoEncontradaException;
import negocio.ContaAbstrata;

public class RepositorioContasArray implements RepositorioContas {
    
    private ArrayList<ContaAbstrata> contas;

    public RepositorioContasArray() {
        this.contas = new ArrayList<ContaAbstrata>();
    }

    public void inserir(ContaAbstrata novaConta) throws ContaNaoEncontradaException {
        // Se o array é maior ou igual a 100 e se a consta já existe no array
        if (this.contas.size() >= 100 || existe(novaConta.getNumero())) {
            throw new ContaNaoEncontradaException(novaConta.getNumero());
        } 
        this.contas.add(novaConta);
    }

    public ContaAbstrata procurar(String numero) throws ContaNaoEncontradaException {
        for (ContaAbstrata contaAtual : this.contas) {
            if (contaAtual.getNumero().equals(numero)) {
                return contaAtual;
            }
        }
        throw new ContaNaoEncontradaException(numero);
    }

    public void remover(String numero) throws ContaNaoEncontradaException {
        ContaAbstrata contaAtual = procurar(numero);
        this.contas.remove(contaAtual);
    }

    public void atualizar(ContaAbstrata conta) throws ContaNaoEncontradaException {
        ContaAbstrata contaAntiga = procurar(conta.getNumero());
        if (contaAntiga == null) {
            throw new ContaNaoEncontradaException(conta.getNumero());
        }
        this.contas.remove(contaAntiga);
        this.contas.add(conta);
    }

    public boolean existe(String numero) throws ContaNaoEncontradaException {
        try {
            // Se a conta for encontrada o código continua
            procurar(numero);
            return true;
        } 
        catch (ContaNaoEncontradaException e) {return false;}
    }
}
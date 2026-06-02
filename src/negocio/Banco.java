package negocio;
import repositorio.RepositorioContas;
import excecoes.*;

public class Banco {
    // Atributo crucial para desacoplar o Banco do tipo de armazenamento
    private RepositorioContas contas;
    private double taxa;

    // O construtor recebe qualquer implementação de RepositorioContas
    public Banco(RepositorioContas repositorio) {
        this.contas = repositorio;
        this.taxa = 0.02;
    }    

    public void creditar(String numero, double valor) throws ContaNaoEncontradaException{
        ContaAbstrata conta = contas.procurar(numero);
        conta.creditar(valor);
    }

    public void debitar(String numero, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException{
        ContaAbstrata conta = contas.procurar(numero);
        conta.debitar(valor);
    }

    public void renderJuros(String numero) throws ContaNaoEncontradaException, TipoContaInvalidoException{
        ContaAbstrata conta = contas.procurar(numero);

        // Se a conta não for do tipo Poupanca
        if (!(conta instanceof Poupanca)) {
            throw new TipoContaInvalidoException(numero, "Erro: Conta " + numero + " não é do tipo Poupança!");
        }

        ((Poupanca) conta).renderJuros(this.taxa);
    }

    public void renderBonus(String numero) throws ContaNaoEncontradaException, TipoContaInvalidoException{
        ContaAbstrata conta = contas.procurar(numero);

        // Se a conta não for Especial 
        if (!(conta instanceof ContaEspecial)) { 
            throw new TipoContaInvalidoException(numero, "Erro: Conta " + numero + " não é do tipo Especial!");
        }

        ((ContaEspecial) conta).renderBonus();
    }

    public void transferir(String numeroPagador, String numeroRecebedor, double valor) throws ContaNaoEncontradaException, SaldoInsuficienteException, TransferenciaMesmaContaException{
        ContaAbstrata pagador = contas.procurar(numeroPagador);
        ContaAbstrata recebedor = contas.procurar(numeroRecebedor);
        
        if (pagador == recebedor) {throw new TransferenciaMesmaContaException(numeroPagador);}
        
        pagador.debitar(valor);
        recebedor.creditar(valor);
    }

    public double getSaldo(String numero) throws ContaNaoEncontradaException{
        ContaAbstrata conta = contas.procurar(numero);
        return conta.getSaldo();
    }
}
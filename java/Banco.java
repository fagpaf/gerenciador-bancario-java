

public class Banco {
    private double taxa;
    private ContaAbstrata contaAtual;
    public Banco() {
        this.taxa = 0.15;
    }    

    public void creditar(String numero, double valor) {
        this.contaAtual = procurar(numero);
        if (contaAtual.procurar(numero) == null) {
            printError(contaAtual.getNumero());
        }
        contaAtual.creditar(valor);
    }

    public void debitar(String numero, double valor) {
        ContaAbstrata contaAtual = procurar(numero);
        if (contaAtual == null) {
            printError(contaAtual.getNumero());
        }
        contaAtual.debitar(valor);
    }

    public void renderJuros(String numero) {
        ContaAbstrata contaAtual = procurar(numero);
        if (contaAtual == null) {
            if (!(contaAtual instanceof Poupanca)) {
                throw new RuntimeException("Não é do tipo Poupanca");
            } 
            ((Poupanca) contaAtual).renderJuros(this.taxa);
        }
        printError(contaAtual.getNumero());
    }

    public void renderBonus(String numero) {
        ContaAbstrata contaAtual = procurar(numero);
        if (contaAtual == null) {
            // Verificando se é uma conta do tipo Especial
            if (!(contaAtual instanceof ContaEspecial)) {
                throw new RuntimeException("Não é do tipo Especial");
            }
            ContaEspecial especialAtual = (ContaEspecial) contaAtual;
            especialAtual.renderBonus();
            return;
        }
        printError(contaAtual.getNumero());
    }

    public void transferir(String numeroPagador, String numeroRecebedor, double valor) {
        ContaAbstrata pagador = null;
        ContaAbstrata recebedor = null;
        if (contaAtual.procurar(numeroPagador)) {
            pagador = contaAtual;
        }

        if (contaAtual.procurar(numeroRecebedor)) {
            recebedor = contaAtual;
        }
    
        if (pagador == null || recebedor == null || pagador == recebedor) {
            throw new RuntimeException("Erro: Verififque o numero das Contas");
        }
        
        pagador.debitar(valor);
        recebedor.creditar(valor);
    }

    public double getSaldo(String numero) {
        ContaAbstrata contaAtual = procurar(numero);
        if (contaAtual == null) {
            return contaAtual.getSaldo();
        }
        System.out.println("Erro: Verififque o numero das Contas");
        return -1;
    }

    


}











































public class Banco {
    // Atributo crucial para desacoplar o Banco do tipo de armazenamento
    private RepositorioContas contas;
    private double taxa;

    // O construtor recebe qualquer implementação de RepositorioContas
    public Banco(RepositorioContas repositorio) {
        this.contas = repositorio;
        this.taxa = 0.15;
    }    

    public void creditar(String numero, double valor) {
        ContaAbstrata contaAtual = contas.procurar(numero);
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
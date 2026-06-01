import negocio.Banco;
import negocio.Conta;
import negocio.ContaAbstrata;
import negocio.ContaEspecial;
import negocio.ContaImposto;
import negocio.Poupanca;
import repositorio.RepositorioContas;
import repositorio.RepositorioContasArray;

public class Main {
    public static void main(String[] args) {
        // 1. PRIMEIRA MUDANÇA CRUCIAL: Criar o repositório primeiro
        RepositorioContas repositorio = new RepositorioContasArray();

        // 2. Injetar o repositório no construtor do Banco
        Banco banco = new Banco(repositorio);

        // 3. Criando as contas usando o tipo genérico ContaAbstrata (Polimorfismo)
        // Certifique-se de que os nomes das suas classes coincidem (ex: ContaImpostoM ou ContaImposto)
        ContaAbstrata c1 = new ContaImposto("111-1"); 
        ContaAbstrata c2 = new Conta("222-2");
        
        // Mantemos p3 como Poupanca para os testes específicos locais que você fez no código antigo
        Poupanca p3 = new Poupanca("333-3"); 

        // Teste avulso que estava no seu código original
        ContaAbstrata conta = new ContaEspecial("21.342-7");
        conta.creditar(500.00);
        conta.debitar(100.00);
        if (conta instanceof ContaEspecial) {
            ((ContaEspecial) conta).renderBonus();
        }
        System.out.println("Saldo da conta avulsa Especial: R$ " + conta.getSaldo());

        // 4. Cadastrando as contas através do REPOSITÓRIO
        repositorio.inserir(c1);
        repositorio.inserir(c2);
        repositorio.inserir(p3); // Aceita Poupança porque ela herda de ContaAbstrata

        // 5. Testando o método CREDITAR pelo Banco
        banco.creditar("111-1", 1000.0);
        banco.creditar("222-2", 500.0);
        banco.creditar("333-3", 2000.0);

        // 6. Testando o método DEBITAR pelo Banco
        banco.debitar("111-1", 200.0);  
        banco.debitar("222-2", 100.0);   
        banco.debitar("333-3", 500.0);   

        // 7. Testando rendimento de Juros (Usando o novo método polimórfico do Banco!)
        // Lembra que no Banco nós implementamos o renderJuros(numero)? Use ele!
        banco.renderJuros("333-3"); // Ele vai usar a taxa padrão do banco (0.15)

        // Se quiser testar o método direto no objeto p3 como estava antes, também funciona:
        p3.renderJuros(0.10);

        // Teste de débito direto no objeto c1
        c1.debitar(100);

        // 8. Exibindo os resultados finais consultando o Banco
        System.out.println("\n--- RESULTADOS FINAIS ---");
        System.out.println("Saldo Final da Conta 111-1: R$ " + banco.getSaldo("111-1"));
        System.out.println("Saldo Final da Conta 222-2: R$ " + banco.getSaldo("222-2"));
        System.out.println("Saldo Final da Poupança 333-3: R$ " + banco.getSaldo("333-3"));
    }
}

/*
javac -d bin Main.java
java -cp bin Main
*/
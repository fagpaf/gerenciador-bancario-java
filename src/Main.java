import excecoes.*;
import negocio.*;
import repositorio.*;

public class Main {
    public static void main(String[] args) {
        // 1. Criar o repositório primeiro
        RepositorioContas repositorio = new RepositorioContasArray();

        // 2. Injetar o repositório no construtor do Banco
        Banco banco = new Banco(repositorio);

        // 3. Criando as contas usando o tipo genérico ContaAbstrata (Polimorfismo)
        ContaAbstrata c1 = new ContaImposto("111-1"); 
        ContaAbstrata c2 = new Conta("222-2");
        Poupanca p3 = new Poupanca("333-3"); 

        // Teste avulso que estava no seu código original
        ContaAbstrata conta = new ContaEspecial("21.342-7");
        try {
            conta.creditar(500.00);
            conta.debitar(100.00);
            if (conta instanceof ContaEspecial) {
                ((ContaEspecial) conta).renderBonus();
            }
            System.out.println("Saldo da conta avulsa Especial: R$ " + conta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro na conta avulsa: " + e.getMessage());
        }

        // 4. Cadastrando as contas através do REPOSITÓRIO
        try {
            repositorio.inserir(c1);
            repositorio.inserir(c2);
            repositorio.inserir(p3); 
        } catch (ContaNaoEncontradaException e) {
            e.getMessage();
        }
        

        System.out.println("\n=== EXECUTANDO OPERAÇÕES NO BANCO ===");

        // 5 e 6. Testando CREDITAR e DEBITAR pelo Banco (Protegido por Try-Catch)
        try {
            // Créditos
            banco.creditar("111-1", 1000.0);
            banco.creditar("222-2", 500.0);
            banco.creditar("333-3", 2000.0);

            // Débitos
            banco.debitar("111-1", 200.0);  
            banco.debitar("222-2", 100.0);   
            banco.debitar("333-3", 500.0);   
            
            System.out.println("Créditos e débitos realizados com sucesso!");
        } catch (ContaNaoEncontradaException | SaldoInsuficienteException e) {
            System.out.println("Erro ao movimentar contas: " + e.getMessage());
        }

        // 7. Testando rendimento de Juros pelo Banco
        try {
            banco.renderJuros("333-3"); // Vai usar a taxa de 0.02 que está no seu Banco.java
            System.out.println("Juros aplicados com sucesso via Banco na conta 333-3.");
        } catch (ContaNaoEncontradaException | TipoContaInvalidoException e) {
            System.out.println("Erro ao render juros: " + e.getMessage());
        }

        // Teste de juros direto no objeto p3 (como o método na classe Poupança não faz "throws", roda direto)
        p3.renderJuros(0.10);

        // Teste de débito direto no objeto c1
        try {
            c1.debitar(100);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro no débito direto da c1: " + e.getMessage());
        }

        // ------------------------------------------------------------------
        // CASO DE TESTE FORÇADO: Testando se a sua nova exceção de tipo funciona
        // Tentando render Juros na conta "222-2" que é Conta Normal (Deve dar erro)
        // ------------------------------------------------------------------
        try {
            System.out.println("\n[Teste Forçado] Tentando render juros na conta comum 222-2...");
            banco.renderJuros("222-2");
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (TipoContaInvalidoException e) {
            System.out.println("Exceção capturada com sucesso! -> " + e.getMessage());
        }

        // 8. Exibindo os resultados finais consultando o Banco
        System.out.println("\n--- RESULTADOS FINAIS ---");
        try {
            System.out.println("Saldo Final da Conta 111-1: R$ " + banco.getSaldo("111-1"));
            System.out.println("Saldo Final da Conta 222-2: R$ " + banco.getSaldo("222-2"));
            System.out.println("Saldo Final da Poupança 333-3: R$ " + banco.getSaldo("333-3"));
        } catch (ContaNaoEncontradaException e) {
            System.out.println("Erro ao buscar saldos finais: " + e.getMessage());
        }
    }
}

/*
javac -d bin Main.java
java -cp bin Main
*/
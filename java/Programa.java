public class Programa {
    public static void main(String[] args) {
        // Criando o banco
        Banco banco = new Banco();

        // Criando Contas normais e Poupanças (Polimorfismo: Poupança é uma Conta!)
        ContaImposto c1 = new ContaImposto("111-1");
        Conta c2 = new Conta("222-2");
        Poupanca p3 = new Poupanca("333-3"); // Criada direto como Poupança para usarmos o juros depois


        Conta conta;
        conta = new ContaEspecial("21.342-7");
        ((Conta)conta).creditar(500.00);
        conta.debitar(100.00);
        if (conta instanceof ContaEspecial) {
        ((ContaEspecial) conta).renderBonus();
        }
        System.out.println(conta.getSaldo());


        // 1. Testando os cadastros
        banco.cadastrar(c1);
        banco.cadastrar(c2);
        banco.cadastrar(p3); // O banco aceita Poupanca porque ela herda de Conta!

        // 2. Testando o método CREDITAR 3 vezes (uma em cada conta)
        banco.creditar("111-1", 1000.0);
        banco.creditar("222-2", 500.0);
        banco.creditar("333-3", 2000.0); // Creditando na poupança pelo Banco

        // 3. Testando o método DEBITAR 3 vezes (uma em cada conta)
        banco. debitar("111-1", 200.0);  // Deve sobrar 800
        banco.debitar("222-2", 100.0);   // Deve sobrar 400
        banco.debitar("333-3", 500.0);   // Deve sobrar 1500

        // Bônus: Fazendo a poupança render juros direto no objeto dela
        // Taxa de 10% (0.10) sobre o saldo atual dela de 1500 (deve render +150 e ir para 1650)
        p3.renderJuros(0.10);

        c1.debitar(100);
        // 4. Testando o método GETSALDO 3 vezes para exibir os resultados
        System.out.println("--- RESULTADOS FINAIS ---");
        System.out.println("Saldo Final da Conta 111-1: R$ " + banco.getSaldo("111-1"));
        System.out.println("Saldo Final da Conta 222-2: R$ " + banco.getSaldo("222-2"));
        System.out.println("Saldo Final da Poupança 333-3: R$ " + banco.getSaldo("333-3"));
    }
}

/*
javac -d . Banco.java Programa.java Conta.java Poupanca.java ContaEspecial.java
java banco.Programa
*/
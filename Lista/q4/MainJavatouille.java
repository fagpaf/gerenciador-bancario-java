package Lista.q4;

public class MainJavatouille {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- TESTE 1: Balcão com Pouco Espaço ---");
        executarCenario(new Balcao("Balcão Estreito", 2), 3, 3);
 
        System.out.println("\n--- TESTE 2: Aprendizes muito mais rápidos que os Chefes ---");
        executarCenario(new Balcao("Balcão Padrão", 10), 5, 1);
 
        System.out.println("\n--- TESTE 3: Chefes muito mais rápidos que os Aprendizes ---");
        executarCenario(new Balcao("Balcão Padrão", 10), 1, 5);
    }
 
    private static void executarCenario(Balcao balcao, int desempenhoAprendiz, int desempenhoChefe)
            throws InterruptedException {
        Thread aprendizThread = new Thread(new Aprendiz(balcao, desempenhoAprendiz));
        Thread chefeThread   = new Thread(new Chefe(balcao, desempenhoChefe));
 
        aprendizThread.start();
        chefeThread.start();
 
        aprendizThread.join();
        chefeThread.join();
        System.out.println("Cenário finalizado.");
    }
}

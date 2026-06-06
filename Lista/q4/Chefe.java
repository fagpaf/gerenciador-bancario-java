package Lista.q4;

class Chefe implements Runnable {
    private Balcao balcao;
    private int desempenho;
 
    public Chefe(Balcao balcao, int desempenho) {
        this.balcao = balcao;
        this.desempenho = desempenho;
    }
 
    @Override
    public void run() {
        try {
            // Consome até o Aprendiz sinalizar que terminou E o balcão esvaziar
            while (balcao.retirar(null)) {
                Thread.sleep(600);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

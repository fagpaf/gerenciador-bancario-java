package Lista.q4;

class Aprendiz implements Runnable {
    private Balcao balcao;
    private int desempenho;
 
    public Aprendiz(Balcao balcao, int desempenho) {
        this.balcao = balcao;
        this.desempenho = desempenho;
    }
 
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < desempenho; j++) {
                    Ingrediente ing = new Ingrediente("Tomate cortado #" + (i * desempenho + j));
                    balcao.colocar(ing);
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Sempre sinaliza o encerramento, mesmo se interrompido
            balcao.encerrarProducao();
        }
    }
}

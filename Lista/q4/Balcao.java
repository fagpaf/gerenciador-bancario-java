package Lista.q4;
import java.util.LinkedList;
import java.util.Queue;

class Balcao {
    private String nome;
    private int capacidade;
    private Queue<Ingrediente> filaIngredientes;
 
    // Controle de encerramento: sinaliza ao Chefe que o Aprendiz terminou
    private boolean producaoEncerrada = false;
 
    public Balcao(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.filaIngredientes = new LinkedList<>();
    }
 
    public synchronized void colocar(Ingrediente ingrediente) throws InterruptedException {
        while (filaIngredientes.size() >= capacidade) {
            System.out.println("Balcão cheio! Aprendiz aguardando espaço...");
            wait();
        }
        filaIngredientes.add(ingrediente);
        System.out.println("Aprendiz colocou: " + ingrediente.getNome()
                + " | Quantidade no balcão: " + filaIngredientes.size());
        notifyAll();
    }
 
    /**
     * Sinaliza que o Aprendiz encerrou a produção.
     * Acorda o Chefe caso esteja esperando em wait() no retirar().
     */
    public synchronized void encerrarProducao() {
        producaoEncerrada = true;
        notifyAll();
    }
 
    /**
     * Retorna true se ainda há trabalho a fazer:
     * o balcão não está vazio OU a produção ainda está em andamento.
     */
    public synchronized boolean retirar(Ingrediente ingredienteDesejado) throws InterruptedException {
        // Espera enquanto o balcão estiver vazio E a produção ainda estiver ativa
        while (filaIngredientes.isEmpty() && !producaoEncerrada) {
            System.out.println("Balcão vazio! Chefe aguardando ingredientes...");
            wait();
        }
 
        // Produção encerrada e balcão vazio: não há mais nada a consumir
        if (filaIngredientes.isEmpty()) {
            return false;
        }
 
        Ingrediente ingredienteRetirado = filaIngredientes.poll();
        System.out.println("Chefe consumiu: " + ingredienteRetirado.getNome()
                + " | Quantidade no balcão: " + filaIngredientes.size());
        notifyAll();
        return true;
    }
}

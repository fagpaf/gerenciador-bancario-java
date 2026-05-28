import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Você pode usar a classe Conta direto, sem import nenhum no topo!
        Conta minhaConta = new Conta("123-X");
        Produto arroz = new Produto("arroz", 4, 10);
        Produto feijao = new Produto("feijao", 7, 17);
        Produto macarrao = new Produto("macarrao", 9.50, 4);
        
        minhaConta.creditar(500.5);

       // 1. Criando a lista de compras
        ArrayList<Produto> listaDeCompras = new ArrayList<>();
        
        // 2. Adicionando os produtos na lista (supondo que vai comprar 1 de cada neste exemplo)
        listaDeCompras.add(arroz);
        listaDeCompras.add(feijao);
        listaDeCompras.add(macarrao);
        
        // 3. Calculando o total varrendo a lista com um laço (for-each)
        double totalCompra = 0;
        for (Produto p : listaDeCompras) {
            // Soma o preço do produto atual ao total
            totalCompra += p.getPreco(); 
            
            // Dá baixa de 1 unidade no estoque de cada um
            p.setQtd(p.getQtd() - 1); 
        }
        
        minhaConta.debitar(totalCompra);

        System.out.println("Total da lista de compras: R$ " + totalCompra);
        
        System.out.println("Saldo final da conta: R$ " + minhaConta.getSaldo());
        System.out.println("Estoque atual do arroz: " + arroz.getQtd());
        System.out.println("Estoque atual do feijao: " + feijao.getQtd());
        System.out.println("Estoque atual do macarrao: " + macarrao.getQtd());
    }
}
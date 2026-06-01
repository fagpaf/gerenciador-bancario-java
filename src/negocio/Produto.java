package negocio;
public class Produto {
    private String descricao;
    private double preco;
    private int qtd;

    // Construtor
    public Produto(String descricao, double precoInicial, int qtdInicial) {
        this.descricao = descricao;
        this.preco = precoInicial;
        this.qtd = qtdInicial;
    }

    // Setters com Method Chaining
    public Produto setQtd(int qtd) {
        this.qtd = qtd;
        return this;
    }

    public Produto setPreco(double preco ) {
        this.preco = preco;
        return this;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public int getQtd() {return qtd;}

    public double getPreco() {return preco;}

    public String getDescricao() {return descricao;}
}
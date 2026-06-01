package excecoes;
public class ContaNaoEncontradaException extends Exception{
    private String numero;

    public ContaNaoEncontradaException(String numero) {
        super("Conta " + numero + "não encontrada");
        this.numero = numero;
    }

    public String getNumero() {return this.numero;}
}

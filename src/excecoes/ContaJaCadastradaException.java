package excecoes;
public class ContaJaCadastradaException extends Exception{
    private String numero;

    public ContaJaCadastradaException(String numero) {
        super("Esta conta " + numero + "ja foi cadastrada");
        this.numero = numero;
    }

    public String getNumero() {return this.numero;}
}

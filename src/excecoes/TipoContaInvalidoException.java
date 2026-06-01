package excecoes;

public class TipoContaInvalidoException extends Exception {
    private String numero;

    public TipoContaInvalidoException(String numero, String mensagem) {
        super(mensagem);
        this.numero = numero;
    }

    public String getNumero() {return this.numero;}
}

package excecoes;

public class TransferenciaMesmaContaException extends Exception{
    private String numero;

    public TransferenciaMesmaContaException(String numero) {
        super("Não é possível transferir para a mesma conta!");
        this.numero = numero;
    }
    
    public String getNumero() {return this.numero;}
}

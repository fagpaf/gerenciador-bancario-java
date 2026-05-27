package curso;
public class Curso {
    protected String codigo;
    protected String nomeCurso;

    public Curso (String nomeInicial, String cod) {
        this.nomeCurso = nomeInicial;
        this.codigo = cod;
    }

    // Setter's e Getter's
    public Curso setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public Curso setNomeCurso(String nome) {
        this.nomeCurso = nome;
        return this;
    }

    public String getCodigo() {return codigo;}

    public String getNomeCurso() {return nomeCurso;}
}

package curso;
public class Aluno extends Curso {
    private String nomeAluno;
    private int CPF;
    private int idade;

    public Aluno(String nomeCurso, String codigo, String nomeAluno, int CPF, int idade) {
        super(nomeCurso, codigo);
        this.nomeAluno = nomeAluno;
        this.CPF = CPF;
        this.idade = idade;
    }

    // Setter's e Getter's
    public Aluno setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
        return this;
    } 

    public Aluno setCPF(int CPF) {
        this.CPF = CPF;
        return this;
    }

    public Aluno setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public int getCPF() {return CPF;}

    public int getIdade() {return idade;}

    public String getNomeAluno() {return nomeAluno;}
}

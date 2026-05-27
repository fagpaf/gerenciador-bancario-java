package curso;

public class TestaAluno {
    // 1. Todo código executável PRECISA estar dentro do método main!
    public static void main(String[] args) {
        
        // Cria o objeto Curso
        Curso cc = new Curso("Computer Science", "MIT042");
        
        // Cria o objeto Aluno (passando os dados do curso que você criou acima)
        // ATENÇÃO: Mudei o CPF de 01234567 para 1234567 porque o Java acha que 
        // números começados com 0 são "Octais" (base 8) e daria erro de compilação!
        Aluno a1 = new Aluno(cc.getNomeCurso(), cc.getCodigo(), "Flavio Araujo", 1234567, 24);

        // 2. Agora o print funciona!
        System.out.println("--- Dados do Aluno ---");
        System.out.println("Nome do Aluno: " + a1.getNomeAluno());
        System.out.println("Idade: " + a1.getIdade());
        System.out.println("CPF: " + a1.getCPF());
        
        // Como Aluno herda de Curso, você pode chamar os métodos do pai direto no objeto do filho:
        System.out.println("\n--- Dados do Curso (Vindos da Herança) ---");
        System.out.println("Código do Curso: " + a1.getCodigo());
        System.out.println("Nome do Curso: " + a1.getNomeCurso());
    }
}

/*
Comando para rodar: 
javac -d . Curso.java Aluno.java TestaAluno.java
java curso.TestaAluno
*/

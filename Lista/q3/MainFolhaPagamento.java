package Lista.q3;

import java.util.ArrayList;
import java.util.List;

public class MainFolhaPagamento {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        
        Funcionario prof = new Professor("Dr. Alan Turing", "111", 5000.0, 3);
        Funcionario tecnico = new TecnicoAdministrativo("Margaret Hamilton", "222", 3000.0, 4);
        Funcionario reitor = new Reitor("Ada Lovelace", "333", 15000.0, 5000.0);

        funcionarios.add(prof);
        funcionarios.add(tecnico);
        funcionarios.add(reitor);

        System.out.println("--- Salários Líquidos Iniciais ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + ": R$ " + String.format("%.2f", f.calcularSalarioLiquido()));
        }

        System.out.println("\n--- Aumentos de Salário ---");
        prof.aumentarSalario(500.0); // Valor fixo
        System.out.println("Novo salário líquido de " + prof.getNome() + ": R$ " + String.format("%.2f", prof.calcularSalarioLiquido()));

        tecnico.aumentarSalario(10.0, true); // 10%
        System.out.println("Novo salário líquido de " + tecnico.getNome() + ": R$ " + String.format("%.2f", tecnico.calcularSalarioLiquido()));

        System.out.println("\n--- Bônus dos Funcionários Bonificáveis ---");
        for (Funcionario f : funcionarios) {
            if (f instanceof Bonificavel) {
                Bonificavel b = (Bonificavel) f;
                System.out.println(f.getNome() + " receberá bônus de: R$ " + String.format("%.2f", b.calcularBonus()));
            }
        }

        System.out.println("\n--- Total de Funcionários ---");
        System.out.println("Funcionários cadastrados: " + Funcionario.getTotalFuncionarios());
    }
}

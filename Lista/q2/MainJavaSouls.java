package Lista.q2;

public class MainJavaSouls {
    public static void main(String[] args) {
        Personagem mago = new Personagem(100, 200, TipoEnergia.MANA);
        Personagem guerreiro = new Personagem(150, 100, TipoEnergia.ESTAMINA);

        Fogueira fogueira = new Fogueira(10.0);
        FonteMagica fonte = new FonteMagica(20.0);
        Acampamento acampamento = new Acampamento(15.0);

        System.out.println("--- Restauração de Vida ---");
        fogueira.restaurar(mago, 30);

        System.out.println("--- Restauração de Energia Bem Sucedido ---");
        try {
            fonte.restaurar(mago, 50);
            acampamento.restaurar(guerreiro, 40);
        } catch (EnergiaIncompativelException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--- Restauração de Energia Incompatível ---");
        try {
            // Guerreiro usa estamina, tentar usar Fonte Mágica deve falhar
            fonte.restaurar(guerreiro, 50);
        } catch (EnergiaIncompativelException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }
    }
}
package rpg.armas;
import rpg.personagens.Personagem;

public class AdagaSombria implements Arma {
    @Override
    public String getNome() { return "Adaga Sombria"; }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 10;
        int custoMana = 10;

        if (atacante.getMana() < custoMana) {
            System.out.println(atacante.getNome() + " sem mana!");
            return;
        }
        atacante.gastarMana(custoMana);
        
        if (Math.random() < 0.15) {
            danoBase *= 2;
            System.out.println("💥 ACERTO CRÍTICO!");
        }

        System.out.println(atacante.getNome() + " faz um ataque rápido com a " + getNome() + "!");
        alvo.receberDano(danoBase);
    }
}
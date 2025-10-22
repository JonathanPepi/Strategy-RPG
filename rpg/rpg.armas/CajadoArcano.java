package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.Queimadura;

public class CajadoArcano implements Arma {
    @Override
    public String getNome() {
        return "Cajado Arcano";
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 8;
        int custoMana = 25;

        if (atacante.getMana() < custoMana) {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
            return;
        }
        atacante.gastarMana(custoMana);
        System.out.println(atacante.getNome() + " conjura Bola de Fogo em " + alvo.getNome() + "!");
        alvo.receberDano(danoBase);

        // Efeito Especial: Causa queimadura
        alvo.adicionarStatusEffect(new Queimadura(2));
    }
}
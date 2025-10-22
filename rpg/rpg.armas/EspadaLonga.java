package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.Sangramento;

public class EspadaLonga implements Arma {
    @Override
    public String getNome() {
        return "Espada Longa";
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 15;
        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com a " + getNome() + "!");
        alvo.receberDano(danoBase);

        // Efeito Especial: 30% de chance de causar sangramento
        if (Math.random() < 0.30) {
            alvo.adicionarStatusEffect(new Sangramento(3));
        }
    }
}
package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.Sangramento;

public class EspadaLonga implements Arma {
    @Override
    public String getNome() { return "Espada Longa"; }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 15;
        
        if (Math.random() < 0.15) {
            danoBase *= 2;
            System.out.println("💥 ACERTO CRÍTICO!");
        }

        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com a " + getNome() + "!");
        alvo.receberDano(danoBase);

        if (Math.random() < 0.30) {
            alvo.adicionarStatusEffect(new Sangramento(3));
        }
    }
}
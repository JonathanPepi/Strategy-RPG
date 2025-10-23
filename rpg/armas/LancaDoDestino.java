package rpg.armas;

import rpg.personagens.Personagem;

public class LancaDoDestino implements Arma {

    @Override
    public String getNome() {
        return "Lança do Destino";
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 16;
        
        if (Math.random() < 0.15) {
            danoBase *= 2;
            System.out.println("💥 ACERTO CRÍTICO!");
        }
        
        System.out.println(atacante.getNome() + " ataca com a " + getNome() + "!");


        int danoNormal = danoBase / 2;
        int danoVerdadeiro = danoBase / 2;
        
        System.out.println("✨ A lança perfura as defesas de " + alvo.getNome() + "!");
        alvo.receberDano(danoNormal); 
        alvo.receberDanoDireto(danoVerdadeiro); 
    }
}
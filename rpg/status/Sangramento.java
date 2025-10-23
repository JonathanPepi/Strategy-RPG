package rpg.status;

import rpg.personagens.Personagem;

public class Sangramento extends StatusEffect {
    public Sangramento(int duracao) {
        super("Sangramento", duracao);
    }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        int danoSangramento = 5;
        System.out.println("🩸 " + alvo.getNome() + " sofre " + danoSangramento + " de dano por sangramento.");
        alvo.receberDanoDireto(danoSangramento); 
    }
}
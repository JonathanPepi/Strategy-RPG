package rpg.status;

import rpg.personagens.Personagem;

public class Queimadura extends StatusEffect {
    public Queimadura(int duracao) {
        super("Queimadura", duracao);
    }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        int danoQueimadura = 10;
        System.out.println("🔥 " + alvo.getNome() + " sofre " + danoQueimadura + " de dano por queimadura.");
        alvo.receberDanoDireto(danoQueimadura);
    }
}
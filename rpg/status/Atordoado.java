package rpg.status;

import rpg.personagens.Personagem;

public class Atordoado extends StatusEffect {
    public Atordoado(int duracao) {
        super("Atordoado", duracao);
    }

    @Override
    public void aplicarEfeito(Personagem alvo) {
        System.out.println("😵 " + alvo.getNome() + " está atordoado e não pode agir!");
    }
}

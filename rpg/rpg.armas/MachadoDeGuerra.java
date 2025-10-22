package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.Atordoado;

public class MachadoDeGuerra implements Arma {
    @Override
    public String getNome() {
        return "Machado de Guerra";
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 18;
        int custoMana = 5;

        if (atacante.getMana() < custoMana) {
            System.out.println(atacante.getNome() + " não tem mana para o golpe!");
            return;
        }
        atacante.gastarMana(custoMana);
        System.out.println(atacante.getNome() + " desfere um golpe esmagador em " + alvo.getNome() + "!");
        alvo.receberDano(danoBase);
        
        // Efeito Especial: 25% de chance de atordoar
        if (Math.random() < 0.25) {
            alvo.adicionarStatusEffect(new Atordoado(1));
        }
    }
}
package rpg.armas;

import rpg.personagens.Personagem;


public interface Arma {
    void usar(Personagem atacante, Personagem alvo);
    String getNome();
}
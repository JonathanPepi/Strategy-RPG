package rpg.armas;

import rpg.personagens.Personagem;

/**
 * Interface Strategy: Define o método que todas as armas devem implementar.
 * Cada arma representa uma "estratégia" de ataque diferente.
 */
public interface Arma {
    void usar(Personagem atacante, Personagem alvo);
    String getNome();
}
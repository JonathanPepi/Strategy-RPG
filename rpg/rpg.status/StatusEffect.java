package rpg.status;

import rpg.personagens.Personagem;

public abstract class StatusEffect {
    protected String nome;
    protected int duracao;

    public StatusEffect(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public void decrementarDuracao() {
        this.duracao--;
    }

    public boolean isFinalizado() {
        return duracao <= 0;
    }

    public String getNome() {
        return nome;
    }

    // Método que será implementado por cada efeito específico
    public abstract void aplicarEfeito(Personagem alvo);
}
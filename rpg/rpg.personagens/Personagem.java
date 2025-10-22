package rpg.personagens;

import rpg.armas.Arma;
import rpg.status.StatusEffect;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class Personagem {
    protected String nome;
    protected int forca, destreza, inteligencia;
    protected int vida, vidaMaxima;
    protected int mana, manaMaxima;
    private Arma armaEquipada;
    private List<StatusEffect> statusEffects = new ArrayList<>();

    public Personagem(String nome, int forca, int destreza, int inteligencia, int vida, int mana) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vidaMaxima = vida;
        this.vida = vida;
        this.manaMaxima = mana;
        this.mana = mana;
    }

    public void atacar(Personagem alvo) {
        if (armaEquipada == null) {
            System.out.println(nome + " está desarmado e não pode atacar!");
            return;
        }
        System.out.println("\n--- Turno de " + this.nome + " ---");
        armaEquipada.usar(this, alvo);
    }

    public void equiparArma(Arma arma) {
        // Implementar lógica de requisitos aqui se desejar
        this.armaEquipada = arma;
        System.out.println(nome + " equipou " + arma.getNome() + ".");
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
    }
    
    // Dano que não é afetado por passivas (de status, etc.)
    public void receberDanoDireto(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }

    public void adicionarStatusEffect(StatusEffect efeito) {
        this.statusEffects.add(efeito);
        System.out.println("Efeito '" + efeito.getNome() + "' aplicado em " + this.nome);
    }
    
    public void processarInicioTurno() {
        // Aplica passivas de regeneração (Mago)
        aplicarPassivasDeTurno();

        // Itera e aplica efeitos de status
        Iterator<StatusEffect> iterator = statusEffects.iterator();
        while(iterator.hasNext()) {
            StatusEffect efeito = iterator.next();
            efeito.aplicarEfeito(this);
            efeito.decrementarDuracao();
            if (efeito.isFinalizado()) {
                System.out.println("Efeito '" + efeito.getNome() + "' em " + this.nome + " terminou.");
                iterator.remove();
            }
        }
    }

    public boolean isAtordoado() {
        return statusEffects.stream().anyMatch(e -> e.getNome().equals("Atordoado"));
    }
    
    // Método para ser sobrescrito por classes com passivas de turno
    protected void aplicarPassivasDeTurno() {}

    public boolean estaVivo() {
        return this.vida > 0;
    }
    
    public String getNome() { return nome; }
    public int getMana() { return mana; }
    public void gastarMana(int custo) { this.mana -= custo; }

    public void exibirStatus() {
        System.out.printf(" > %s | HP: %d/%d | MP: %d/%d\n", nome, vida, vidaMaxima, mana, manaMaxima);
    }
}
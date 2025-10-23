package rpg.personagens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rpg.armas.Arma;
import rpg.status.StatusEffect;

public abstract class Personagem {
    protected String nome;
    protected int forca, destreza, inteligencia;
    protected int vida, vidaMaxima;
    protected int mana, manaMaxima;
    private Arma armaEquipada;
    private List<StatusEffect> statusEffects = new ArrayList<>();
    
   
    private List<Arma> inventario = new ArrayList<>();

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
        if (isAtordoado()) {
            System.out.println("😵 " + this.nome + " está atordoado e não pode atacar!");
            return;
        }
        if (armaEquipada == null) {
            System.out.println(nome + " está desarmado e não pode atacar!");
            return;
        }
        System.out.println("--- Turno de " + this.nome + " ---");
        armaEquipada.usar(this, alvo);
    }
    
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
    }
    
    public void receberDanoDireto(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
    }
    
   
    public void adicionarArmaAoInventario(Arma arma) {
        this.inventario.add(arma);
        if (this.armaEquipada == null) {
            equiparArma(0);
        }
    }

    public void equiparArma(int indiceInventario) {
        if (indiceInventario >= 0 && indiceInventario < inventario.size()) {
            this.armaEquipada = inventario.get(indiceInventario);
            System.out.println("🔧 " + nome + " equipou " + this.armaEquipada.getNome() + ".");
        } else {
            System.out.println("Índice de arma inválido!");
        }
    }

    public void adicionarStatusEffect(StatusEffect efeito) {
        this.statusEffects.add(efeito);
        System.out.println("Efeito '" + efeito.getNome() + "' aplicado em " + this.nome);
    }
    

    public String getNome() { return nome; }
    public Arma getArmaEquipada() { return armaEquipada; }
    public int getMana() { return mana; }
    public void gastarMana(int custo) { this.mana -= custo; }
    public boolean estaVivo() { return this.vida > 0; }
    public boolean isAtordoado() { return statusEffects.stream().anyMatch(e -> e.getNome().equals("Atordoado")); }
    protected void aplicarPassivasDeTurno() {}

    public void processarInicioTurno() {
        aplicarPassivasDeTurno();
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

    public void exibirStatus() {
        System.out.printf(" > %s | HP: %d/%d | MP: %d/%d | Arma: %s\n", 
            nome, vida, vidaMaxima, mana, manaMaxima, armaEquipada != null ? armaEquipada.getNome() : "Nenhuma");
    }
}
package rpg.personagens;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 5, 7, 18, 70, 150);
    }

    @Override
    protected void aplicarPassivasDeTurno() {
        this.mana += 10; 
        if (this.mana > this.manaMaxima) {
            this.mana = this.manaMaxima;
        }
        System.out.println("🌀 " + this.nome + " regenerou 10 de mana.");
    }
}
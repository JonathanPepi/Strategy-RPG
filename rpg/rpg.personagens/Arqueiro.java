package rpg.personagens;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 8, 15, 7, 90, 80);
    }

    @Override
    public void receberDano(int dano) {
        if (Math.random() < 0.25) { // Passiva "Esquiva" - 25% de chance
            System.out.println("🍃 " + this.nome + " se esquivou do ataque!");
        } else {
            super.receberDano(dano);
        }
    }
}
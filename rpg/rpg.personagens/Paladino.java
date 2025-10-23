package rpg.personagens;

public class Paladino extends Personagem {

    public Paladino(String nome) {
        super(nome, 12, 8, 10, 110, 70);
    }
    
    @Override
    protected void aplicarPassivasDeTurno() {
        int cura = 5;
        this.vida += cura; 
        if (this.vida > this.vidaMaxima) {
            this.vida = this.vidaMaxima;
        }
        System.out.println("🌟 " + this.nome + " se curou em " + cura + " HP pela sua aura divina.");
    }
}
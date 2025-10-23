package rpg.personagens;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 15, 8, 5, 120, 50);
    }

    @Override
    public void receberDano(int dano) {
        int danoReduzido = (int) (dano * 0.80); 
        System.out.println("🛡️ Pele Dura do Guerreiro reduz o dano!");
        super.receberDano(danoReduzido);
    }
}
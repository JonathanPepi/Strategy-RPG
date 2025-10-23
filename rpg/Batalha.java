package rpg;

import rpg.armas.CajadoArcano;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;

public class Batalha {
    private Personagem p1;
    private Personagem p2;
    private int turno;

    public Batalha(Personagem p1, Personagem p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.turno = 1;
    }

    public void iniciar() {
        System.out.println("\n========= O COMBATE COMEÇA! ==========");
        p1.exibirStatus();
        p2.exibirStatus();

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n>>>>>>>>>>>> TURNO " + turno + " <<<<<<<<<<<<");

            executarTurno(p1, p2);
            if (!p2.estaVivo()) break; 

            executarTurno(p2, p1);
            
            System.out.println("\n--- Fim do Turno " + turno + " ---");
            p1.exibirStatus();
            p2.exibirStatus();

            turno++;
            
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        anunciarVencedor();
    }
    
    private void executarTurno(Personagem atacante, Personagem alvo) {
        atacante.processarInicioTurno();
        
        if (atacante instanceof Mago && atacante.getMana() < 25 && atacante.getArmaEquipada() instanceof CajadoArcano) {
            System.out.println("O Mago está com pouca mana e decide trocar de arma!");
            atacante.equiparArma(1); 
        }
        
        atacante.atacar(alvo);
    }
    
    private void anunciarVencedor() {
        System.out.println("\n========== O COMBATE TERMINOU! ==========");
        if (p1.estaVivo()) {
            System.out.println("🏆 O vencedor é " + p1.getNome() + "!");
        } else {
            System.out.println("🏆 O vencedor é " + p2.getNome() + "!");
        }
        p1.exibirStatus();
        p2.exibirStatus();
    }
}
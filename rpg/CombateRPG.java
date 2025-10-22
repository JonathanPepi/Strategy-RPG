package rpg;

import rpg.armas.*;
import rpg.personagens.*;

public class CombateRPG {
    public static void main(String[] args) {
        // 1. Criação dos Personagens
        Personagem guerreiro = new Guerreiro("Sir Gideon");
        Personagem mago = new Mago("Eldrin");

        // 2. Criação das Armas
        Arma machado = new MachadoDeGuerra();
        Arma cajado = new CajadoArcano();

        // 3. Equipando as armas (A estratégia é definida aqui)
        guerreiro.equiparArma(machado);
        mago.equiparArma(cajado);
        
        System.out.println("\n========= O COMBATE COMEÇA! ==========");
        guerreiro.exibirStatus();
        mago.exibirStatus();

        int turno = 1;
        
        // 4. Loop de Combate
        while (guerreiro.estaVivo() && mago.estaVivo()) {
            System.out.println("\n>>>>>>>>>>>> TURNO " + turno + " <<<<<<<<<<<<");

            // Turno do Guerreiro
            if (guerreiro.estaVivo()) {
                guerreiro.processarInicioTurno();
                if (!guerreiro.isAtordoado()) {
                    guerreiro.atacar(mago);
                }
            }
            
            // Turno do Mago
            if (mago.estaVivo()) {
                mago.processarInicioTurno();
                 if (!mago.isAtordoado()) {
                    mago.atacar(guerreiro);
                }
            }
            
            System.out.println("\n--- Fim do Turno " + turno + " ---");
            guerreiro.exibirStatus();
            mago.exibirStatus();

            turno++;
            
            // Pausa para melhor visualização
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 5. Resultado Final
        System.out.println("\n========== O COMBATE TERMINOU! ==========");
        if (guerreiro.estaVivo()) {
            System.out.println("🏆 O vencedor é " + guerreiro.getNome() + "!");
        } else {
            System.out.println("🏆 O vencedor é " + mago.getNome() + "!");
        }
    }
}
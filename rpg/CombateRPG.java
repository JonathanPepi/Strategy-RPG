package rpg;

import rpg.armas.*;
import rpg.personagens.*;

public class CombateRPG {
    public static void main(String[] args) {
        Personagem paladino = new Paladino("Arthur");
        Personagem mago = new Mago("Eldrin");

        Arma lanca = new LancaDoDestino();
        Arma cajado = new CajadoArcano();
        Arma adaga = new AdagaSombria(); 

        paladino.adicionarArmaAoInventario(lanca);
        
        mago.adicionarArmaAoInventario(cajado);
        mago.adicionarArmaAoInventario(adaga); 

        Batalha batalhaEpica = new Batalha(paladino, mago);
        batalhaEpica.iniciar();
    }
}
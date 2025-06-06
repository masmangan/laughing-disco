import java.util.Random;

/**
 * Um jogo de cartas.
 * 
 * @author marco.mangan@pucrs.br
 */
public class BlackJack2App
{


        // TODO: mostrar cartas em um retangulo
        //
        //  //=====\\
        //  || A   ||
        //  ||     || 
        //  ||   A ||
        //  \\=====//
        //    
    

    /**
     * Game - Jogo
     */
    public static double status(Card[] c, Card[] h) {
        double result;
        int sc = c[0].getGameValue() + c[1].getGameValue();
        if (c[2] != null)
            sc += c[2].getGameValue();
        int sh = h[0].getGameValue() + h[1].getGameValue() + h[2].getGameValue();

        if (c[2] == null)
            System.out.printf("Cartas do computador: %s, %s (%d)%n", c[0].getValueFace(), c[1].getValueFace(), sc );  // mostra a carta
        else
            System.out.printf("Cartas do computador: %s, %s, %s (%d)%n", c[0].getValueFace(), c[1].getValueFace(), c[2].getValueFace(), sc );  // mostra a carta
        System.out.printf("   Cartas do jogador: %s, %s, %s (%d)%n", h[0].getValueFace(), h[1].getValueFace(), h[2].getValueFace(), sh );

        // TODO: permitir dobrar o valor da aposta!
        // atribuir valor para vitoria, perda e empate
        if (sh > 21) {
            System.out.printf("Voce perdeu! Tente de novo! (Acima de 21!)");
            result = - 100.0;
        } else if (sc > 21) {
            System.out.printf("Voce ganhou! Parabens! (Acima de 21!)");
            result = 100.0;
        } else if (sh > sc) {
            System.out.printf("Voce ganhou! Parabens!");
            result = 100.0;
        } else if (sc > sh) {
            System.out.printf("Voce perdeu! Tente de novo!");
            result = - 100.0;
        } else {
            System.out.printf("Empate! Vamos novamente!");
            result = 0.0;
        }

        return result;
    }

    /**
     * Game - jogo
     */
    public static void deal(Card[] c, Card[] h, Game g) {
        c[0] = g.deal();  
        h[0] = g.deal();

        c[1] = g.deal();  
        h[1] = g.deal();        
        // TODO: detectar Blackjack com duas cartas!

        // TODO: mostrar as cartas de cada jogador, apenas a primeira do computador

        if (c[0].getGameValue() + c[1].getGameValue() <= 18) {
            c[2] = g.deal();  
        } else {
            c[2] = null;
        }
        // TODO: tornar a terceira carta opcional para o humano
        h[2] = g.deal();        

    }

    /**
     * App - Aplicativo
     */
    public static void main(String[] args)
    {
        Game g = new Game();    // mover comandos do jogo para outra classe
        

        Card[] c = new Card[3];
        Card[] h = new Card[3];

        double balance = 1000.0; // TODO: permitir informar um valor

        while (true) {
            // criar um valor inicial, repetir enquanto o saldo eh positivo
            System.out.printf("\nSaldo: R$ %.2f\n",  balance);
            if (balance <= 0) {
                break;
            }
            // TODO: criar um valor inicial, repetir ateh que o jogador escolha parar

            deal(c, h, g);
            balance += status(c, h);

        }
    }
}

import java.util.Random;

/**
 * Um jogo de cartas.
 * 
 * @author marco.mangan@pucrs.br
 */
public class BlackJack
{
    /**
     * Gera uma carta, sem naipe.
     * 
     * @param r um gerador de numeros aleatorios.
     * @return um inteiro entre 1 e 13
     */
    public static int getCard(Random r) {
        return r.nextInt(13) + 1;
    }

    /**
     * Retorna um texto que representa o valor da carta.
     * 
     * @param c a carta a ser representada.
     * @return um texto com as letras A, J, Q, K ou um
     * numero entre 2 e 10.
     */
    public static String face(int c) {
        // TODO: mostrar cartas em um retangulo
        //
        //  //=====\\
        //  || A   ||
        //  ||     || 
        //  ||   A ||
        //  \\=====//
        //
        String cf;
        if ( c == 1)
            cf = "A";
        else if ( c == 11 )
            cf = "J";
        else if ( c == 12 )
            cf = "Q";
        else if ( c == 13 )
            cf = "K";
        else
            cf = "" + c; 
        return cf;
    }

    /**
     * Retorna o valor individual da carta no jogo BlackJack.
     * @param c a carta a ser representada.
     * @return um valor de 1 até 10
     */
    public static int value(int c) {
        int v;
        if (c >= 11)    // cartas com face valem 10 (J, Q e K)
            v = 10;
        else
            v = c; 
        return v;
    }

    public static double status(int[] c, int[] h) {
        double result;
        int sc = value(c[0]) + value(c[1]) + value(c[2]);
        int sh = value(h[0]) + value(h[1]) + value(h[2]);

        System.out.printf("Cartas do computador: %s, %s, %s (%d)%n", face(c[0]), face(c[1]), face(c[2]), sc );  // mostra a carta
        System.out.printf("   Cartas do jogador: %s, %s, %s (%d)%n", face(h[0]), face(h[1]), face(h[2]), sh );

        
        // TODO: permitir dobrar o valor da aposta!
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

    public static void main(String[] args)
    {
        Random r;           // gerador de numeros aleatorios

        int[] c = new int[3];
        int[] h = new int[3];

        r = new Random();   // cria uma gerador de numeros

        double balance = 1000.0; // TODO: permitir informar um valor
        
        while (true) {
            // TODO: criar um valor inicial, repetir enquanto o saldo e positivo
            System.out.printf("\nSaldo: R$ %.2f\n",  balance);
            if (balance <= 0) {
                break;
            }
            // TODO: criar um valor inicial, repetir ateh que o jogador escolha parar
            // TODO: criar um valor inicial, atribuir valor para vitoria, perda e empate

            c[0] = getCard(r);  
            h[0] = getCard(r);

            c[1] = getCard(r);  
            h[1] = getCard(r);        
            // TODO: detectar Blackjack com duas cartas!

            // TODO: mostrar as cartas de cada jogador, apenas a primeira do computador

            // TODO: tornar a terceira carta opcional
            c[2] = getCard(r);  
            h[2] = getCard(r);        

            balance += status(c, h);

        }
    }
}


public class Card
{
    public static final int DIAMONDS = 1;
    public static final int CLUBS = 2;
    public static final int HEARTS = 3;
    public static final int SPADES = 4;   
    
    private int suit;
    private int value;

    public Card(int suit, int value) {
        if (suit < 1 || suit > 4)
            throw new IllegalArgumentException("Invalid Suit!");
        if (value < 1 || value > 13)
            throw new IllegalArgumentException("Invalid Value!");
        this.suit = suit;
        this.value = value;
    }

    /**
     * Retorna um texto que representa o valor da carta.
     * 
     * @return um texto com as letras A, J, Q, K ou um
     * numero entre 2 e 10.
     */
    public String getValueFace() {
        String cf;
        if ( this.value == 1)
            cf = "A";
        else if ( this.value == 11 )
            cf = "J";
        else if ( this.value == 12 )
            cf = "Q";
        else if ( this.value == 13 )
            cf = "K";
        else
            cf = "" + this.value; 
        return cf;
    }    

    public String getSuitFace() {
       String cf;
        if ( this.suit == DIAMONDS)
            cf = "♦"; // Diamonds Ouro Vermelho
        else if ( this.suit == CLUBS)
            cf = "♣"; // Clubs Paus Preto
        else if ( this.suit == HEARTS )
            cf = "♥"; // Hearts Copas
        else // if ( this.value == SPADES )
            cf = "♠"; // Spades Espadas
        return cf;
    }    
    
    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }    

    /**
     * Retorna o valor individual da carta no jogo BlackJack2App.
     * @return um valor de 1 até 10
     */
    public int getGameValue() {
        int c = this.value;
        int v;
        if (c >= 11)    // cartas com face valem 10 (J, Q e K)
            v = 10;
        else
            v = c; 
        return v;
    }

    public String toString() {
        return String.format("%s suit=%d value=%d", super.toString(), suit, value);
    }
    
}

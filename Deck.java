import java.util.Random;

public class Deck
{
    private Card[] cards;
    private int deal;
    
    public Deck() {
        cards = new Card[52];
        int i = 0;
        for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
            for (int value = 1; value <= 13; value++) {
                Card c = new Card(suit, value);
                cards[i] = c;
                i++;
            }
        }
        shuffle();
        deal = 0;
    }
    
    private void shuffle() {
        Random r = new Random();
        for (int i = 2; i < 52; i++) {
            int pos = r.nextInt(i);
            Card tmp = cards[i];
            cards[i] = cards[pos];
            cards[pos] = tmp;
        }
    }

    public Card deal() {
        // jogo longo!
        if (deal >= 52) {
            shuffle();
            deal = 0;
        }
        return cards[deal++];
    }
}

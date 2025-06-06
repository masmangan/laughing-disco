
public class Game
{
    private Deck deck;

    public Game()
    {
        deck = new Deck();
    }

    public Card deal() {
        return deck.deal();
    }
}

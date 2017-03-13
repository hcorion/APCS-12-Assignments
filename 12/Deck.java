import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	private ArrayList<Card> cards;
    public static int MAX_DECK_SIZE = 52;
        
    // The deck really shouldn't need to know these things
    // it should be in the card class, but according to the assignment I don't need to change the Card class.
    private static String[] suits       = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private static String[] ranks       = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    private static int[] pointValue     = { 2,     3,       4,      5,      6,     7,       8,       9,      10,    10,     10,      10,     11};

	public Deck() 
    {
		cards = new ArrayList<Card>();
        for (String suit: suits )
        {
            for (int i = 0; i < ranks.length; i++)
            {
                cards.add(new Card(suit, ranks[i], pointValue[i]) );
            }
        }

        // Shuffle the deck.
        shuffle();
	}

    public String toString()
    {
        String complete = "";
        for ( Card card: cards)
        {
            if ( card != null )
            {
                complete+="[" + card.getSuit() + ", " + card.getRank() + ", " + card.getValue() + "]\n";
            } else
            {
                complete+="WARNING this card is null!\n";
            }
            
        }
        return complete;
    }

    private void shuffle()
    {
        Random rand = new Random();
        
        for (int i = 0; i < MAX_DECK_SIZE; i++)
        {
            // Let's get the first element in the array and then delete it.
            Card card = cards.get(0);
            cards.remove(card);

            // Now put the first element in the array in a random spot in the deck.
            int num = rand.nextInt(MAX_DECK_SIZE);
            cards.add(num, card);
        }
    }
}
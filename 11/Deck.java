// Lab11bv100.java
// This is the 100 point version.
// Zion Nimchuk
// March 6, 2017
// APCS, Chris Robinson
// This program creates a standard deck of cards, shuffles them and then prints them out to the console.

import java.util.Random;

public class Deck
{
    private Card[] cards;
    public static int MAX_DECK_SIZE = 52;
	private int size;
    
    // The deck really shouldn't need to know these things
    // it should be in the card class, but according to the assignment I don't need to change the Card class.
    private static String[] suits       = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private static String[] ranks       = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    private static int[] pointValue     = { 2,     3,       4,      5,      6,     7,       8,       9,      10,    10,     10,      10,     11};

	public Deck() 
    {
		cards = new Card[MAX_DECK_SIZE];
        int iterator = 0;
        for (int x = 0; x < suits.length; x++)
        {
            String suit = suits[x];
            for (int i = 0; i < ranks.length; i++)
            {
                cards[iterator] = new Card(suit, ranks[i], pointValue[i]);
                iterator++;
            }
        }

        // Shuffle the deck.
        shuffle();
	}

    public String toString()
    {
        String complete = "";
        for ( int i = 0; i < cards.length; i++)
        {
            if ( cards[i] != null )
            {
                complete+="[" + cards[i].suit() + ", " + cards[i].rank() + ", " + cards[i].pointValue() + "]\n";
            } else
            {
                complete+="WARNING card #" + i + " is null!\n";
            }
            
        }
        return complete;
    }

    // shiftCards shifts all the cards at index <point> down one and overwrites the number in the first index. Leaving a null object at <point>
    private void shiftCards(int point)
    {
        Card[] newCards = new Card[MAX_DECK_SIZE];
        
        for (int i = 1; i < point+1; i++ )
        {
            newCards[i-1] = cards[i];
        }
        for (int i = point+1; i < MAX_DECK_SIZE; i++ )
        {
            newCards[i] = cards[i];
        }
        cards = newCards;
    }

    private void shuffle()
    {
        Random rand = new Random();
        
        for (int i = 0; i < MAX_DECK_SIZE; i++)
        {
            int num = rand.nextInt(MAX_DECK_SIZE);

            // We need to store this because the shiftCard method is going to get rid of the object in the first slot.
            Card card = cards[0];

            shiftCards(num);
            cards[num] = card;
        }
    }
}
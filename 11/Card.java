// Card.java
// The <Card> class is identical to the <Card03> class.
// In this "Elevens Lab" version it will used by the <Deck> class.
// //////////////////////////////////////////////////////////
// This program is designed to explain the "Elevens" lab created
// by Michael Clancy, Robert Glen Martin and Judith Hromcik.
// Divided into stages and altered August 2014 by Leon Schram.
// A re-definition of the <toString> method is added to the <Card> class.


public class Card
{
   private String suit;
   private String rank;
   private int pointValue;

   public Card(String s, String r, int pV)
   {
      suit = s;
      rank = r;
      pointValue = pV;
   }

   public String suit()      { return suit; }
   public String rank()      { return rank; }
   public int pointValue()   { return pointValue; }
 	
   public boolean matches(Card otherCard) 
   {
		return otherCard.suit().equals(this.suit())
			 && otherCard.rank().equals(this.rank())
			 && otherCard.pointValue() == this.pointValue();
	}
  
   public String toString()
   {
      return rank + " of " + suit + " (point value = " + pointValue + ")";
   }
}


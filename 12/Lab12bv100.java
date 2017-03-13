// Lab12bv100.java
// This is the 100 point version
// Zion Nimchuk
// March 13, 2017
// This program simulates a simple chatbot with random questions and some context sensitive questions regarding family and the word no.

 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab12bv100
{
	public static void main(String[] args)
	{
		MagpieLab12b maggie = new MagpieLab12b();

		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();

		while (!statement.equals("Bye"))
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}
}


class MagpieLab12b
{
	private static String[] responses = {
		"What is your favourite country to visit?", "I wish it was not so humid.", "I like historical fiction books and movies.",
		"What is your favourite holiday?", "Have you seena a movie recently?", "Do you play any games?", "What kind of music do you listen to?",
		"What is your favourite country to visit?", "Where do you live?", "Interesting, tell me more.", "Hmmm.", "Do you really think so?", "You don't say."};

	// I assume when you say dynamic array you meant an ArrayList, not just a non-static array.
	private ArrayList<String> familyResponses = new ArrayList<String>(Arrays.asList("Tell me more about your family.", "Does your famliy live close together?", "Where were you born?", "Tell me more about your parents.", "Do you live with your family?", "Do you have any siblings?", "How old are your parents?", "Are you married?", "How old are your siblings?", "Are you an only child?")) ;

	private static String[] familyTriggers = {
		"mother", "mom", "momma", "mum",
		"father", "dad", "daddy", "pop", 
		"sister", "sis",
		"brother", "bro", 
		"cousin", "family", "parent", "sibling"};

	private Random rand;

	public MagpieLab12b()
	{
		rand = new Random();
	}
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	public String getResponse(String statement)
	{
		if (statement.indexOf("no") >= 0)
		{
			return "Why so negative?";
		}
		else
		{
			boolean familyRelated = false;
			for( String str : familyTriggers)
			{
				if (statement.indexOf(str) >= 0)
				{
					familyRelated = true;
					break;
				}
			}
			if (familyRelated)
			{
				return familyResponses.get(rand.nextInt( familyResponses.size() ));
			}
			else
			{
				return getRandomResponse();
			}
		}
	}

	private String getRandomResponse()
	{
		return responses[rand.nextInt(responses.length)];
	}
}
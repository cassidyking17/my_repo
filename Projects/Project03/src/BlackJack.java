import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
	// create a new deck of cards
			CardDeck deck = new CardDeck();
			Scanner scan = new Scanner(System.in);
			int response1;
			int total = 0;
		
			deck.shuffle();
			// the players cards
			Card a = deck.nextCard();
			Card b = deck.nextCard();
			System.out.println("Your cards are: \n" + a.getRank() + " of " + a.getSuit() + "s and a " + b.getRank() + " of "
					+ b.getSuit() + "s");
			// the dealers cards
			Card c = deck.nextCard();
			Card d = deck.nextCard();
			System.out.println("One of the dealers cards is: \n" + c.getRank() + " of " + c.getSuit() + "s");
			// takes in to account if the ace should be a 1 or 11-gives the player the
			// choice
			if (a.rank.getValue() == 11 || b.rank.getValue() == 11) {
				System.out.println("An ace can either be 1 or 11. Which do you want it to be?");
				response1 = scan.nextInt();
				if (response1 == 1 && a.rank.getValue() == 11)
					total = total + 1 + b.rank.getValue();
				else if (response1 == 1 && b.rank.getValue() == 11)
					total = total + 1 + a.rank.getValue();
				else if (response1 == 1 && b.rank.getValue() == 11)
					total = total + 1 + a.rank.getValue();
				else if (response1 == 11 && a.rank.getValue() == 11)
					total = total + 11 + b.rank.getValue();
			} else
				// if there is no ace, adds the two cards to get the total
				total = a.rank.getValue() + b.rank.getValue();
			System.out.println("Your total is: " + total);
			// seeing what the user wants to do
			System.out.println("Do you want to hit or stay?");
			String response2 = scan.next();
			Card e;
			while (response2.equalsIgnoreCase("hit")) {
				// if they chose to hit, gives them another card
				e = deck.nextCard();
				System.out.println("You got a " + e.getRank() + " of " + e.getSuit() + "s");
				// bust if the players cards go over 21
				if (total + e.rank.getValue() > 21) {
					System.out.println("You lose. Try again");
					System.exit(0);
					// if the new card is an ace, give the player the option of it being a 1 or 11
				} else if (e.rank.getValue() == 11) {
					System.out.println("An ace can either be 1 or 11. Which do you want it to be?");
					response1 = scan.nextInt();
					if (response1 == 1)
						total = total + 1;
					else
						total = total + 11;
				} else
					// if the card is not an ace and the value does not excede 21, adds the new card
					// to the total
					total = total + e.rank.getValue();
				System.out.println("Your new total is: " + total);
				System.out.println("Do you want to hit or stay?");
				response2 = scan.next();
				// continues the loop until the player goes over 21 or chooses to stay
			}
			// the dealers turn
			System.out.println("The dealers other card is a: " + d.getRank() + " of " + d.getSuit() + "s");
			int dealerTotal = c.rank.getValue() + d.rank.getValue();
			System.out.println("The dealers total is: " + dealerTotal);
			Card f;
			// if the dealers total is less than 17, they will hit
			if (dealerTotal < 17)
				response2 = "hit";
			while (response2.equalsIgnoreCase("hit")) {
				// gives the dealer a new card
				f = deck.nextCard();
				System.out.println("The dealer chose to hit and got a " + f.getRank() + " of " + f.getSuit() + "s");
				if (c.rank.getValue() + d.rank.getValue() + f.rank.getValue() > 21) {
					// if the dealer busts, then the player wins
					System.out.println("The dealer lost. You win!");
					System.exit(0);
				} else {
					if (f.rank.getValue() == 11) {
						// if the dealer gets an ace and would bust with the value being 11, the card
						// will count as value of 1
						if (11 + dealerTotal > 21)
							dealerTotal = 1 + c.rank.getValue() + d.rank.getValue();
						else
							// if the value would be less than of equal to 21 with the ace counting as 11,
							// that will be the value of the card
							dealerTotal = 11 + c.rank.getValue() + d.rank.getValue();
					} else
						// if the new card is not an ace, adds the new card to the total
						dealerTotal = dealerTotal + f.rank.getValue();
					System.out.println("The dealers new total is: " + dealerTotal);
				}
				// if the dealers total is still less than 17, they will hit again
				if (dealerTotal < 17)
					response2 = "hit";
				else
					response2 = "stay";
			}
			// the different outcomes based on the dealer and user totals
			if (dealerTotal > 21)
				System.out.println("The dealer went over 21, you win!");
			else if (dealerTotal > total)
				System.out.println("You lose.");
			else if (total > dealerTotal)
				System.out.println("You win!");
			else if (dealerTotal == total)
				System.out.println("It's a tie.");
		}

}

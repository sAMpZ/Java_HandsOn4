import java.util.InputMismatchException;
import java.util.Scanner;

class Person {

	String name;

	public Person(String name) {

		this.name = name;

	}

	// method to get persons input
	public int getInput(int cards, Scanner scanner) {

		int card_number = -1;

		while (card_number == -1) {
			try {
				System.out.printf("Enter a number between 1 and %d", cards);
				card_number = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("You did not enter an integer");
				scanner.next();
				getInput(cards, scanner);
			}
			// if out of range the out of range number is still being returned
			if (card_number < 1 || cards < card_number) {

				System.out.println("Out of range, try again");
				getInput(cards, scanner);

			}

		}

		return card_number;
	}

}

public class Game {

	public void choose(String[] cards, int number, String name) {

		String message = null;
		switch (number) {
		case 1:
			message = cards[0];
			break;
		case 2:
			message = cards[1];
			break;
		case 3:
			message = cards[2];
			break;
		case 4:
			message = cards[3];
			break;
		case 5:
			message = cards[4];
			break;
		case 6:
			message = cards[5];
			break;
		case 7:
			message = cards[6];
			break;
		case 8:
			message = cards[7];
			break;
		case 9:
			message = cards[8];
			break;
		case 10:
			message = cards[9];
			break;
		}
		System.out.printf("%s choose card number %d, its message is " + message
				+ "\n", name, number);
	}

	public static void main(String[] args) {

		//array of messages
		String[] cards = { "This is card 1", "This is card 2",
				"This is card 3", "This is card 4", "This is card 5",
				"This is card 6", "This is card 7", "This is card 8",
				"This is card 9", "This is card 10" };
		
		int numCards = cards.length;

		Scanner scanner = new Scanner(System.in);

		//jacks game
		Person person1 = new Person("Jack");
		Game game1 = new Game();
		
		int person1_card = person1.getInput(numCards, scanner);
		game1.choose(cards, person1_card, person1.name);

		//jills game
		Person person2 = new Person("Jill");
		Game game2 = new Game();

		int person2_card = person2.getInput(numCards, scanner);
		game2.choose(cards, person2_card, person2.name);

		scanner.close();

	}
}

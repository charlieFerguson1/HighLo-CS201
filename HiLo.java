import java.util.Random;
import java.util.Scanner;

public class HiLo {

	/*
	 * main: contains the whole program. using two do while loops the game is played
	 * and contained.
	 * 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		boolean inGame = true; // used for the outer do while loop
		int leave = 0; // used for the inner do while loop

		System.out.println("Welcome to the Hi-Lo Guessing Game"); // welcomes user to game
		do {
			System.out.println("Enter a number for the upper bound of a range: "); // prompts for the upper bound for
																					// this game
			int upperBound = scan.nextInt();
			int target = ran.nextInt(upperBound); // generates a random number to be used as the target using random
													// class

			while (target == 0) // ensures that target is not 0, if it is then it regenerates the target number
			{
				target = ran.nextInt(upperBound);
			}

			int guess = 0;
			int numGuesses = 0; // keeps track of the number of guesses

			do {

				System.out.println("Enter a guess or type 0 to quit: "); // prompts for the users input
				guess = scan.nextInt();

				if (guess > upperBound || guess < 0) // checks if the guess is either greater than the upper bound or
														// lower then 0
				{
					System.out.println("Guess is outside of bounds");
				}

				else if (guess == 0) {
					System.out.println("You quit the game.");
					inGame = false;
				}

				else if (guess == target) // the user won, congratulates them and asks if they want to play again
				{
					numGuesses++; // increments numGuess by to keep track of your next guess
					System.out.println("You win! It took you " + numGuesses + " guesses to guess correctly");
					inGame = false; // since the user won the game, this individual game is over
				}

				else {
					if (guess > target) 
						System.out.println("Your guess was too high!");
					 
					else 
						System.out.println("Your guess was too low!");
					
					numGuesses++; // increments numGuess by to keep track of your next guess
					System.out.println("number of guesses: " + numGuesses);

				}

			} while (inGame); // guessing loop, this loop stays open while the user is still guessing

			System.out.println("Want to play again?");
			System.out.println("Type 1 to play again or 0 to quit."); // any number other than 1 will quit the game

			leave = scan.nextInt();

		} while (leave == 1); // if this remains true, it will restart the game process(the smaller loop) if
								// it is no longer true, the user has opted to "leave" the game.
		scan.close();
		System.out.println("Thanks for playing!");
	}
}

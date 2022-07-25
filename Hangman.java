import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	private static final String ANSI_RED = "\033[0;31m";
	private static final String ANSI_GREEN = "\033[0;32m";
	private static final String ANSI_CYAN = "\033[0;36m";
	private static final String ANSI_RESET = "\u001B[0m";

	public static String get_word() {

		Random rand = new Random();
		String[] word_list = { "red", "orange", "yellow", "green", "blue", "indigo", "purple" };
		String word = word_list[rand.nextInt(word_list.length)];
		word = word.toUpperCase();
		return word;

	}

	public static void play(String word) {

		Scanner scan = new Scanner(System.in);

		String symbol = "*";
		String word_completion = new String(new char[word.length()]).replace("\0", symbol);
		boolean guessed = false;
		ArrayList<String> guessed_letters = new ArrayList<String>();
		int tries = 6;

		System.out.println("Let's play Hangman!");
		display_Hangman(tries);
		System.out.println("Your word (" + word.length() + " letters): " + word_completion);
		System.out.println();

		while (!guessed && tries > 0) {
			System.out.print("Please type your guess: ");
			String guess = scan.nextLine();
			guess = guess.toUpperCase();

			if (guess.length() == 1 && guess.matches("[a-zA-Z]+")) {
				if (guessed_letters.contains(guess)) {
					System.out.println("You already guessed the letter " + guess + ". Please try again!");
				} else if (!(word.contains(guess))) {
					System.out.println(guess + " is not in the WORD. Please try again!");
					tries = tries - 1;
					guessed_letters.add(guess);
				} else {
					System.out.println("Good Job! " + guess + " is in the WORD.");
					guessed_letters.add(guess);
					char[] ch1 = word.toCharArray();
					char[] ch2 = word_completion.toCharArray();
					for (int i = 0; i < ch1.length; i++) {
						if (guess.equals("" + ch1[i])) {
							ch2[i] = ch1[i];
						}
					}
					word_completion = String.valueOf(ch2);

					if (!word_completion.contains(symbol)) {
						guessed = true;
					}
				}
			}

			else if (guess.length() == word.length() && guess.matches("[a-zA-Z]+")) {
				if (guessed_letters.contains(guess)) {
					System.out.println("You already guessed the letter " + guess + ". Please try again!");
				} else if (!guess.equals(word)) {
					System.out.println(guess + " is not the WORD. Please try again!");
					tries = tries - 1;
					guessed_letters.add(guess);
				} else {
					word_completion = word;
					guessed = true;
				}
			}

			else {
				System.out.println("Not a valid guess. Please try again!");
			}

			display_Hangman(tries);
			System.out.println("Your word (" + word.length() + " letters): " + word_completion);
			System.out.println();

		}

		if (guessed) {
			System.out.println("Congrats! You guessed the WORD. You win!");
		} else {
			System.out.println("Sorry, you have ran out of tries. The WORD was " + word + ". Maybe next time!");
		}

	}

	public static void display_Hangman(int count) {

		if (count == 6) {
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 6");
		}

		if (count == 5) {
			System.out.println("");
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "      |  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 5");
		}

		if (count == 4) {
			System.out.println("");
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "     _|_ " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |     |  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |_ _ _|" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 4");
		}

		if (count == 3) {
			System.out.println("");
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |    " + ANSI_CYAN + "       _|_  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |    " + ANSI_CYAN + "     |     |  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |    " + ANSI_CYAN + "     |_ _ _|" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |    " + ANSI_CYAN + "        |" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |    " + ANSI_CYAN + "        |" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |    " + ANSI_CYAN + "        |" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 3");
		}

		if (count == 2) {
			System.out.println("");
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "     _|_  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |     |  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |_ _ _|" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "    --|--" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   || | ||   " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "      |" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |   ");
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 2");
		}

		if (count == 1) {
			System.out.println("");
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "     _|_  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |     |  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |_ _ _|" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "    --|--" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   || | ||   " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "      |" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "  ' /' '\\' " + ANSI_RESET);
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 1");
		}

		if (count == 0) {
			System.out.println("");
			System.out.println(ANSI_GREEN + "   _______________   ");
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "     _|_ " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   | . . |  " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   |_ - _|" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "    --|--" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   || | ||   " + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "      |" + ANSI_RESET);
			System.out.println(ANSI_RED + "   |      " + ANSI_CYAN + "   '/' '\\' " + ANSI_RESET);
			System.out.println(ANSI_GREEN + "  _|_" + ANSI_RESET);
			System.out.println();
			System.out.println("Chances available: 0");
		}
	}

	public static void main(String[] args) {
		String word = get_word();
		play(word);
	}

}

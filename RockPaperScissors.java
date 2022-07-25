import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	private static String rock = "🪨(Rock)";
	private static String paper = "📰(Paper)";
	private static String scissors = "✂(Scissors)";
	
	public static void play() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("What is your choice? \n'R' for " + rock + ", 'P' for " + paper + ", 'S' for " + scissors + "\n>> ");
		String user = scan.next();
		user = user.toUpperCase();
		
		String[] comp_list = {"R", "P", "S"};
		String computer = comp_list[rand.nextInt(3)];
		
		if (user.equals(computer)) {
			System.out.println("It is a tie. You and the computer have both chosen " + return_word(user) + ".");
		}
		else {
			if ((user.equals("R") && computer.equals("S")) || (user.equals("P") && computer.equals("R")) || (user.equals("S") && computer.equals("P"))) {
				System.out.println("You chose " + return_word(user) + " and the computer chose " + return_word(computer) + ".\nYou won!");
			}
			else {
				System.out.println("You chose " + return_word(user) + " and the computer chose " + return_word(computer) + ".\nYou lose :(");
			}
		}
	}
	
	public static String return_word(String choice) {
		
		if (choice.equals("R")) {
			return rock;
		}
		else if (choice.equals("P")) {
			return paper;
		}
		else if (choice.equals("S")) {
			return scissors;
		}
		
		return "";
		
	}
	
	public static void main(String[] args) {
		play();
	}

}

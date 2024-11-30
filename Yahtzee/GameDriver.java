//CS110 FINAL
//Brendan Vogel
//I'd like to be evaluated for early submission, as well as having a usable "player" class. This would equal 20 extra points.
//Importing scanner
import java.util.Scanner;
/**
 * The main method of the GameDriver class prompts the user to input the names of two players, creates a Game object, 
 * and calls the playGame() method to start the game.
 *
 * @param args an array of command-line arguments for the program (not used)
 */
public class GameDriver
{
   public static void main(String [] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("Input player 1's name:");
      String player1 = input.nextLine();
      System.out.println("Input player 2's name:");
      String player2 = input.nextLine();
      Game g = new Game(player1, player2);
      g.playGame();
   }
}
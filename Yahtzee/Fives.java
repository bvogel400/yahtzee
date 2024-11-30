//CS 110 FINAL
//Brendan Vogel
/**
 * The Fives class represents a category of the same name in the game of Yahtzee. 
 * It calculates the score for a given roll of the dice where the score is 
 * the sum of the dice showing the value of 5.
 */

public class Fives extends Category
{
   public int evaluate(Dice d)
   {
   /**
     * Evaluates the given Dice object for the Fives category and returns the corresponding score.
     * The score is calculated by multiplying the number of dice with the value  5 by 5.
     * @param d the Dice object to evaluate
     * @return the score for the Fives category
     */
      int total = d.count(5);
      total = total * 5;
      return total;
   }
}  
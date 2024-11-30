//CS 110 FINAL
//Brendan Vogel
/**
 * The Sixes class represents a category of the same name in the game of Yahtzee. 
 * It calculates the score for a given roll of the dice where the score is 
 * the sum of the dice showing the value of 6.
 */
public class Sixes extends Category
{
   public int evaluate(Dice d)
   {
   /**
     * Evaluates the given Dice object for the Fives category and returns the corresponding score.
     * The score is calculated by multiplying the number of dice with the value 6 by 6.
     * @param d the Dice object to evaluate
     * @return the score for the Sixes category
     */
      int total = d.count(6);
      total = total * 6;
      return total;
   }
}  
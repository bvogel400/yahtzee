//CS110 FINAL
//Brendan Vogel
/**
 * The Fours class represents a category of the same name in the game of Yahtzee. 
 * It calculates the score for a given roll of the dice where the score is 
 * the sum of the dice showing the value of 4.
 */
public class Fours extends Category
{
   /**
     * Evaluates the given Dice object for the Fours category and returns the corresponding score.
     * The score is calculated by multiplying the number of dice with the value 4 by 4.
     * @param d the Dice object to evaluate
     * @return the score for the Fours category
     */
   public int evaluate(Dice d)
   {
      int total = d.count(4);
      total = total * 4;
      return total;
   }
}  
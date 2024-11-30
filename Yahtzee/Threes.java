//CS110 FINAL
//Brendan Vogel
/**
 * The Threes class represents a category of the same name in the game of Yahtzee. 
 * It calculates the score for a given roll of the dice where the score is 
 * the sum of the dice showing the value of 3.
 */
public class Threes extends Category
{
   /**
     * Evaluates the given dice roll for this category.
     * @param d the dice roll to evaluate
     * @return the score for this category based on the given dice roll
     */
   public int evaluate(Dice d)
   {
      int total = d.count(3);
      total = total * 3;
      return total;
   }
}  
//CS110 FINAL
//Brendan Vogel
/**
 * A class representing the "Twos" category in the game of Yahtzee.
 * The objective of the "Twos" category is to score the sum of all dice with a value of 2.
 */
public class Twos extends Category
{
   /**
     * Calculates and returns the score for the "Twos" category based on the values of the dice.
     * @param d the set of dice to be evaluated
     * @return the score for the "Twos" category
     */
   public int evaluate(Dice d)
   {
      int total = d.count(2);
      total = total * 2;
      return total;
   }
}  
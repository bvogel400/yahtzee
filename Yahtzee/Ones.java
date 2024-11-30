//CS110 FINAL
//Brendan Vogel
/**
 * The Ones category class, which represents the "Ones" category of a Yahtzee game.
 * This category scores the sum of all dice showing the number 1.
 */
public class Ones extends Category
{
   /**
    * Evaluates a set of dice for the Ones category.
    * Returns the total sum of all dice showing the number 1.
    *
    * @param d the set of dice to be evaluated
    * @return the total sum of all dice showing the number 1
    */
   public int evaluate(Dice d)
   {
      int total = d.count(1);
      return total;
   }
}
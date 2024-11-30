//CS110 FINAL
//Brendan Vogel
/**
 * A subclass of Category that evaluates a dice roll for a Yahtzee.
 */
public class Yahtzee extends Category
{
   /**
   * Evaluates a dice roll for a Yahtzee.
   *
   * @param d The dice roll to evaluate.
   * @return The score for a Yahtzee, which is 50 if all the dice show the same value and 0 otherwise.
   */
   public int evaluate(Dice d)
   {
      int total = 1;
      int init;
      int score = 0;
      for(init = 1; init <= 5; init++)
      {
         int count = d.count(total);
         if (count == 5)
         {
            score = 50;
            total++;
         }
         else
         {
            total++;
         }
      }
      return score;
   }
}  
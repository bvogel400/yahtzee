//CS110 FINAL
//Brendan Vogel
/**
 * A class representing the Three of a Kind category in the game of Yahtzee.
 * 
 * In  ofThree a Kind category, the player scores the sum of the three dice if there are three dice with the same value,
 * otherwise the score is 0.
 */
public class ThreeOfAKind extends Category
{
   /**
     * Evaluates a given set of dice for Three of a Kind category and returns the score.
     *
     * @param d the Dice object representing the set of dice to be evaluated
     * @return the score obtained from the dice set in Three of a Kind category
     */
   public int evaluate(Dice d)
   {
      int total = 1;
      int init;
      int score = 0;
      for(init = 1; init <= 6; init++)
      {
         int count = d.count(total);
         if (count == 3)
         {
            score = total * 3;
         }
         else
         {
            total++;
         }
      }
      return score;
   }
}  
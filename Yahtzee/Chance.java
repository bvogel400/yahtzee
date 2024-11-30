//CS110 FINAL
//Brendan Vogel
public class Chance extends Category
{
    /**
    * Calculates the score for the given dice according to the Chance category rules.
    * The score is the sum of all dice values.
    * 
    * @param d the Dice object containing the dice to be evaluated.
    * @return the score for the given dice.
    */
   public int evaluate(Dice d)
   {
      int total = 0;
      int score = 0;
      int init;
      for (init = 0; init <= 4; init++)
      {
         Die die = d.getDie(total);
         int val = die.getValue();
         score = score + val;
         total++;
      }
      return score;
   }
}  
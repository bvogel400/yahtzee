//CS110 FINAL
//Brendan Vogel
/**
 * FullHouse is a subclass of Category that represents the Full House score category in the game of Yahtzee.
 * A Full House is a roll that contains three of a kind and a pair.
 * If the dice satisfy this condition, the score is 25.
 * If not, the score is 0.
 */
public class FullHouse extends Category
{
   /**
    * This method evaluates a given set of dice for a Full House score.
    * @param d A Dice object representing the dice to be evaluated.
    * @return An integer representing the score for a Full House.
    */
   public int evaluate(Dice d)
   {
      int total = 1;
      int score = 0;
      int totals = 1;
      int init;
      int init2;
      boolean b = false;
      for(init = 1; init <= 6; init++)
      {
         int count = d.count(total);
         if (count == 3)
         {
            score = score + 1;
            total++;
            b = true;
         }
         else
         {
            total++;
         }
      }
      for(init2 = 1; init2 <= 6; init2++)
      {
         int counts = d.count(totals);
         if (counts == 2 && b == true)
         {
            score = score + 1;
            totals++;
         }
         else
         {
            totals++;
         }
      }
      if (score == 2)
      {
         score = 25;
      }
      else
      {
         score = 0;
      }
      return score;
   }
}  
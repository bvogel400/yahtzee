//CS110 FINAL
//Brendan Vogel
public class SmallStraight extends Category
{
   /**
    * This method evaluates the given dice and returns the score
    * for a small straight category, which is 30 if the dice contain
    * at least four consecutive numbers.
    *
    * @param d the Dice object to be evaluated
    * @return the score for a small straight category
    */
   public int evaluate(Dice d)
   {
      int score = 0;
      if (d.count(1) >= 1 && 
          d.count(2) >= 1 && 
          d.count(3) >= 1 && 
          d.count(4) >= 1)
      {
         score = 30;
      }
      if (d.count(2) >= 1 && 
          d.count(3) >= 1 && 
          d.count(4) >= 1 && 
          d.count(5) >= 1)
      {
         score = 30;
      }
      if (d.count(3) >= 1 && 
          d.count(4) >= 1 && 
          d.count(5) >= 1 && 
          d.count(6) >= 1)
      {
         score = 30;
      }   
      return score;
   }
}  
//CS110 FINAL
//Brendan Vogel
/**
 * Represents a category in yahtzee that can be scored.
 */
public abstract class Category
{
   private int score;
   private boolean used;
   /**
     * Sets the score for this category based on the given dice.
     * Marks this category as used.
     * @param d the dice to evaluate
     */
   public abstract int evaluate(Dice d);
   /**
     * Sets the score for this category based on the given dice.
     * Marks this category as used.
     * @param d the dice to evaluate
     */
   public void addValue(Dice d)
   {
      score = evaluate(d);
      used = true;
   }
   /**
     * Returns the score earned for this category.
     * @return the score earned for this category
     */
   public int getScore()
   {
      return score;
   }
   /**
     * Returns whether this category has been used.
     * @return true if this category has been used, false otherwise
     */
   public boolean getUsed()
   {
      return used;
   }
}
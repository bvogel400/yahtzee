//CS110 FINAL
//Brendan Vogel
import java.util.Random;
/**
 * The Die class represents a single six-sided die used in a game.
 */
public class Die
{
   private int value;
   private final int SIDES=6;
   private Random r;
   /**
     * Constructs a new Die object with a random value between 1 and 6.
     */
   public Die()
   {
      r = new Random();
      value = r.nextInt(SIDES) + 1;
   }
   /**
     * Rolls the die and sets the value to a random number between 1 and 6.
     */
   public void roll()
   {
      value = r.nextInt(SIDES) + 1;
   }
   /**
     * Returns the current value of the die.
     *
     * @return The current value of the die.
     */
   public int getValue()
   {
      return value;
   }
   /**
     * Overridden toString method
     * @return toString
     */
   @Override
   public String toString()
   {
      return String.format("%s", value);
   }
}
      
      
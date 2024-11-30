//CS110 FINAL
//Brendan Vogel
/**
 * The DiceRoll class represents a roll of five dice. It extends the Dice class.
 */
public class DiceRoll extends Dice
{
   private final int NUM_DIE=5;
   /**
    * Constructs a DiceRoll object with five dice.
    */
   public DiceRoll()
   {
      super();
      // Add five new Die objects to the dice list
      int index;
      for (index = 1; index <= NUM_DIE; index++)
      {
         Die d = new Die();
         dice.add(d);
      }
   }
    /**
    * Rolls all five dice by replacing each die with a new random value.
    */
   public void toss()
   {
      int count = 0;
      for (Die val : dice)
      {
         Die p = new Die();
         dice.set(count, p);
         count++;
      }
   }
}
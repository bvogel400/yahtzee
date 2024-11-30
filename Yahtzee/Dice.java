//CS110 FINAL
//Brendan Vogel
import java.util.ArrayList;

/**
 * Represents a set of dice.
 */
public class Dice
{
   protected ArrayList<Die> dice;
   protected final int DEF_CAP=5;
   /**
     * Constructs a Dice object with a specified number of dice.
     * 
     * @param num the number of dice in the set
     */
   public Dice()
   {
      dice = new ArrayList<Die>(DEF_CAP);
   }
   /**
     * Constructs a Dice object with a specified number of dice.
     * 
     * @param num the number of dice in the set
     */
   public Dice(int num)
   {
      dice = new ArrayList<Die>(num);
   }
   /**
     * Adds a die to the set.
     * 
     * @param d the die to add
     */
   public void addDie(Die d)
   {
      d = new Die();
      dice.add(d);
   }
   /**
     * Returns the number of dice in the set.
     * 
     * @return the number of dice
     */
   public int getNumDice()
   {
      int numDice;
      numDice = dice.size();
      return numDice;
   }
   /**
     * Returns the die at a specified index.
     * 
     * @param i the index of the die to retrieve
     * @return the die at the specified index
     */
   public Die getDie(int i)
   {
      return dice.get(i);
   }
   /**
     * Removes the die at a specified index.
     * 
     * @param i the index of the die to remove
     */
   public void removeDie(int i)
   {
      dice.remove(i);
   }
   /**
     * Counts the number of dice in the set with a specified value.
     * 
     * @param val the value to count
     * @return the number of dice with the specified value
     */
   public int count(int val)
   {
      int count = 0;
      for (Die index : dice)
      {
         int get = index.getValue();
         if (get == val)
         {
            count++;
         }
      }
      return count;
   }
   /**
     * Returns the sum of the values of all dice in the set.
     * 
     * @return the sum of the values of all dice
     */
   public int sum()
   {
      int total = 0;
      for (Die val : dice)
      {
         int get = val.getValue();
         total = total + get;
      }
      return total;
   }
   /**
     * Determines if the set contains a die with a specified value.
     * 
     * @param val the value to check for
     * @return true if the set contains a die with the specified value, false
     *         otherwise
     */
   private boolean contains(int val)
   {
      boolean q = true;
      int count = 0;
      for (Die index: dice)
      {
         int get = index.getValue();
         if (get == val)
         {
            q = true;
         }
         else
         {
            q = false;
         }
      }
      return q;
   }
   /**
     * Overridden toString method
     * @return toString
     */
   @Override
   public String toString()
   {
      String list = "";
      int count = 1;
      for (Die val : dice)
      {
         int get = val.getValue();
         list = list + String.format("%s: value %s\n", count, get);
         count++;
      }
      return list;
   }
}
      
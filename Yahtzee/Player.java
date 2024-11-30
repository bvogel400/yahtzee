//CS110 FINAL
//Brendan Vogel
/**
 * Represents a player in a game of Yahtzee.
 */
public class Player
{
   public ScoreCard scorecard;
   public String name;
   public DiceRoll dice;
   /**
     * Constructs a new player with the given name.
     *
     * @param name the name of the player
     */
   public Player(String n)
   {
      name = n;
      scorecard = new ScoreCard();
      dice = new DiceRoll();
   }
   /**
     * Returns the scorecard for this player.
     *
     * @return the scorecard
     */
   public ScoreCard getScoreCard()
   {
      return scorecard;
   }
   /**
     * Returns the name of this player.
     *
     * @return the name
     */
   public String getName()
   {
      return name;
   }
   /**
     * Sets the name of this player.
     *
     * @param name the new name
     */
   public void setName(String n)
   {
      name = n;
   }
   /**
     * Returns the dice roll for this player.
     *
     * @return the dice roll
     */
   public DiceRoll getDice()
   {
      return dice;
   }
}
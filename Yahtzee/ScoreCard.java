//CS110 FINAL
//Brendan Vogel
import java.util.ArrayList;
/**
 * A ScoreCard class to keep track of the scores for a game of Yahtzee.
 * The scorecard contains a list of categories and their corresponding scores.
 */
public class ScoreCard
{
   private ArrayList<Category> scorecard = new ArrayList<Category>();
   private final int yahtzeeBonus=100;
   private final int NUM_CATS=13;
   /**
     * Constructs a new ScoreCard object and adds all categories to the scorecard.
     */
   public ScoreCard()
   {
      Category Ones = new Ones();
      scorecard.add(Ones);
      Category Twos = new Twos();
      scorecard.add(Twos);
      Category Threes = new Threes();
      scorecard.add(Threes);
      Category Fours = new Fours();
      scorecard.add(Fours);
      Category Fives = new Fives();
      scorecard.add(Fives);
      Category Sixes = new Sixes();
      scorecard.add(Sixes);
      Category ThreeOfAKind = new ThreeOfAKind();
      scorecard.add(ThreeOfAKind);
      Category FourOfAKind = new FourOfAKind();
      scorecard.add(FourOfAKind);
      Category FullHouse = new FullHouse();
      scorecard.add(FullHouse);    
      Category SmallStraight = new SmallStraight();
      scorecard.add(SmallStraight);
      Category LargeStraight = new LargeStraight();
      scorecard.add(LargeStraight);
      Category Yahtzee = new Yahtzee();
      scorecard.add(Yahtzee);
      Category Chance = new Chance();
      scorecard.add(Chance);
   }
   /**
     * Records the score for the given category and dice.
     * @param cv the category to record the score for
     * @param d the dice to evaluate for the score
     */
   public void choose(CategoryValue cv, Dice d)
   {
      Category val = scorecard.get(cv.getValue());
      val.addValue(d);
   }
   /**
     * Evaluates the score for the given category and dice.
     * @param cv the category to evaluate the score for
     * @param d the dice to evaluate for the score
     * @return the score for the given category and dice
     */
   public int getEvaluation(CategoryValue cv, Dice d)
   {
      Category val = scorecard.get(cv.getValue());
      int score = val.evaluate(d);
      return score;
   }
   /**
     * Checks if the given category has already been scored.
     * @param cv the category to check if scored
     * @return true if the given category has already been scored, false otherwise
     */
   public boolean checkScored(CategoryValue cv)
   {
      Category val = scorecard.get(cv.getValue());
      boolean used = val.getUsed();
      return used;
   }
   /**
     * Gets the score for the given category.
     * @param cv the category to get the score for
     * @return the score for the given category
     */
   public int getCategoryScore(CategoryValue cv)
   {
      Category val = scorecard.get(cv.getValue());
      int score = val.getScore();
      return score;
   }
   /**
     * Calculates the total score for the upper section of the scorecard.
     * @return the total score for the upper section of the scorecard
     */
   public int scoreTop()
   {
      CategoryValue ONES = CategoryValue.ONES;
      CategoryValue TWOS = CategoryValue.TWOS;
      CategoryValue THREES = CategoryValue.THREES;
      CategoryValue FOURS = CategoryValue.FOURS;
      CategoryValue FIVES = CategoryValue.FIVES;
      CategoryValue SIXES = CategoryValue.SIXES;
      int score;
      score = getCategoryScore(ONES) + 
              getCategoryScore(TWOS) + 
              getCategoryScore(THREES) + 
              getCategoryScore(FOURS) + 
              getCategoryScore(FIVES) + 
              getCategoryScore(SIXES);
      return score;
   }/**
     * Calculates the total score for the lower section of the scorecard.
     * @return the total score for the lower section of the scorecard
     */
   public int scoreBottom()
   {
      CategoryValue THREE_OF_A_KIND = CategoryValue.THREE_OF_A_KIND;
      CategoryValue FOUR_OF_A_KIND = CategoryValue.FOUR_OF_A_KIND;
      CategoryValue FULL_HOUSE = CategoryValue.FULL_HOUSE;
      CategoryValue SM_STRAIGHT = CategoryValue.SM_STRAIGHT;
      CategoryValue LG_STRAIGHT = CategoryValue.LG_STRAIGHT;
      CategoryValue YAHTZEE = CategoryValue.YAHTZEE;
      CategoryValue CHANCE = CategoryValue.CHANCE;
      int score = getCategoryScore(THREE_OF_A_KIND) + 
              getCategoryScore(FOUR_OF_A_KIND) + 
              getCategoryScore(FULL_HOUSE) + 
              getCategoryScore(SM_STRAIGHT) + 
              getCategoryScore(LG_STRAIGHT) + 
              getCategoryScore(YAHTZEE) +
              getCategoryScore(CHANCE);
      return score;
   }
   /**
     * Calculates the total score of the scorecard.
     * @return the total score for the scorecard
     */
   public int score()
   {
      int scoreBottom = scoreBottom();
      int scoreTop = scoreTop();
      int score = scoreTop + scoreBottom;
      return score;
   }
   /**
     * Overridden toString method
     * @return toString
     */
   @Override
   public String toString()
   {
      return String.format("Current Scorecard:\nOnes: %s\nTwos: %s\nThrees: %s\nFours: %s\nFives: %s\nSixes: %s\nThree of a Kind: %s\nFour of a Kind: %s\nFull House: %s\nSmall Straight: %s\nLarge Straight: %s\nYahtzee: %s\nChance: %s\nUpper Total: %s\nLower Total: %s\nTotal: %s\n", 
      getCategoryScore(CategoryValue.ONES),
      getCategoryScore(CategoryValue.TWOS),
      getCategoryScore(CategoryValue.THREES), 
      getCategoryScore(CategoryValue.FOURS), 
      getCategoryScore(CategoryValue.FIVES), 
      getCategoryScore(CategoryValue.SIXES), 
      getCategoryScore(CategoryValue.THREE_OF_A_KIND), 
      getCategoryScore(CategoryValue.FOUR_OF_A_KIND), 
      getCategoryScore(CategoryValue.FULL_HOUSE), 
      getCategoryScore(CategoryValue.SM_STRAIGHT), 
      getCategoryScore(CategoryValue.LG_STRAIGHT), 
      getCategoryScore(CategoryValue.YAHTZEE), 
      getCategoryScore(CategoryValue.CHANCE), 
      scoreTop(),
      scoreBottom(),
      score());
   }
}
      
      
      
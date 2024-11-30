//CS110 FINAL
//Brendan Vogel
import java.util.Scanner;
/**
 * The Game class represents a game of Yahtzee between two players. It contains methods for playing the game,
 * displaying the header and instructions, and handling the rounds.
 */
public class Game
{
   private Player player1;
   private Player player2;
   private String endLoop;
     /**
    * Constructs a new Game object with the specified player names.
    *
    * @param p1 the name of player 1
    * @param p2 the name of player 2
    */
   public Game(String p1, String p2)
   {
      player1 = new Player(p1);
      player2 = new Player(p2);
      this.endLoop = endLoop;
   }

    /**
    * Plays the game of Yahtzee between two players.
    */

   public void playGame()
   {
      int m;
      Header();
      Instructions();
      for (m = 1; m <= 13; m++)
      {
         Round(player1);
         Round(player2);
         DiceRoll p1d = player1.getDice();
         DiceRoll p2d = player2.getDice();
         p1d.toss();
         p2d.toss();
      }
      ScoreCard p1s = player1.getScoreCard();
      ScoreCard p2s = player2.getScoreCard();
      int p1score = p1s.score();
      int p2score = p2s.score();
      if (p1score > p2score)
      {
         System.out.printf("\n%s wins!", player1.getName());
      }
      else if (p2score > p1score)
      {
         System.out.printf("\n%s wins!", player2.getName());
      }
      else
      {
         System.out.printf("\n%s and %s tied!", player1.getName(), player2.getName());
      }
   }
   /**
    * Displays the game header.
    */   
   public void Header()
   {
      System.out.println("\n******************\nWELCOME TO YAHTZEE\n******************\n");
   }
   /**
    * Displays the game instructions.
    */
   public void Instructions()
   {
      System.out.println("There are 13 rounds, each player gets 1 turn each round.");
      System.out.println("Each round, each player rolls 5 dice.");
      System.out.println("You can then choose to keep any amount of the 5 dice you rolled, and reroll the rest.");
      System.out.println("When picking the dice you'd like to reroll, input the number that corresponds to the dice (Not the dice's value).");
      System.out.println("If you'd like to save all your die, input none.");
      System.out.println("If you'd like to reroll another die, say yes when prompted 'Would you like to reroll another die.");
      System.out.println("If you'd like to score your die and choose a category, say no when prompted 'Would you like to reroll another die.'");
      System.out.println("Have Fun!");
   }
   /**
    * Handles a round of the game for the specified player.
    *
    * @param p the player whose turn it is
    */
   public void Round(Player p)
   {
      System.out.printf("\n%s's turn:\n", p.getName());
      ScoreCard ps = p.getScoreCard();
      System.out.println(ps);
      System.out.println("Dice:");
      DiceRoll pd = p.getDice();
      int r;
      for (r = 1; r <= 2; r++)
      {
         pd = Reroller(pd);
      }
      System.out.println("Dice:");
      System.out.println(pd);
      ps = PointChoice(ps, pd);
   }
   /**
    * Rerolls a certain die
    *
    * @param pd the player whose turn it is' dice
    */   
   public DiceRoll reroll(DiceRoll pd)
   {
      Scanner input = new Scanner(System.in);
      int end = 1;
      while (end == 1)
      {
         System.out.println(pd);
         System.out.println("Choose a die to reroll (input none if you want to keep them all):");
         endLoop = input.next();
         if (endLoop.equals("1") && pd.getNumDice() >= 1)
         {
            pd.removeDie(0);
            end = 2;
         }
         else if (endLoop.equals("2") && pd.getNumDice() >= 2)
         {
            pd.removeDie(1);
            end = 2;
         }
         else if (endLoop.equals("3") && pd.getNumDice() >= 3)
         {
            pd.removeDie(2);
            end = 2;
         }
         else if (endLoop.equals("4") && pd.getNumDice() >= 4)
         {
            pd.removeDie(3);
            end = 2;
         }
         else if (endLoop.equals("5") && pd.getNumDice() >= 5)
         {
            pd.removeDie(4);
            end = 2;
         }
         else if (endLoop.equals("none"))
         {
            end = 2;
         }
         else if (pd.getNumDice() == 0)
         {
            end = 2;
         }
         else
         {
            System.out.println("Please enter valid input");
         }
      }
      
      return pd;
   }
   /**
    * Rerolls however many dice the player chooses
    *
    * @param pd the player whose turn it is' dice
    */   
   public DiceRoll Reroller(DiceRoll pd)
   {
      pd = reroll(pd);
      Scanner input = new Scanner(System.in);
      int repeat = 1;
      int count = 1;
      while (repeat == 1)
      {  
            System.out.println("");
            System.out.println("Dice saved:");
            System.out.println(pd);
            System.out.printf("\nReroll chance %s:\n", count);
               System.out.println("Would you like to reroll any of these dice?");
               String reroll = input.next();
               if (reroll.equals("yes"))
               {
                  pd = RerollYes(pd);
                  count++;
               }
               else if (reroll.equals("no"))
               {
                  pd = RerollNo(pd);
                  repeat = 2;
               }
               else
               {
                  System.out.println("Please input yes or no");
               }
      }
      return pd;
   }
      /**
    * Rerolls a die if the input is yes
    *
    * @param pd the player whose turn it is' dice
    */
   public DiceRoll RerollYes(DiceRoll pd)
   {
      pd = reroll(pd);
      System.out.println(pd);
      return pd;
   }
      /**
    * Rerolls the new die
    *
    * @param pd the player whose turn it is' dice
    */
   public DiceRoll RerollNo(DiceRoll pd)
   {
         if (pd.getNumDice() == 0)
         {
            int i;
            for (i = 1; i <= 5; i++)
            {
               Die d = new Die();
               pd.addDie(d);
            }
         }
         else if (pd.getNumDice() == 1)
         {
            int i;
            for (i = 1; i <= 4; i++)
            {
               Die d = new Die();
               pd.addDie(d);
            }
         }
         else if (pd.getNumDice() == 2)
         {
            int i;
            for (i = 1; i <= 3; i++)
            {
               Die d = new Die();
               pd.addDie(d);
            }
         }
         else if (pd.getNumDice() == 3)
         {
            int i;
            for (i = 1; i <= 2; i++)
            {
               Die d = new Die();
               pd.addDie(d);
            }
         }
         else if (pd.getNumDice() == 4)
         {
            Die d = new Die();
            pd.addDie(d);
         }
         else if (pd.getNumDice() == 5)
         {
            return pd;
         }
         return pd;
   }
    /**
    * Chooses the category on the scorecard
    *
    * @param pd the player whose turn it is' dice
    * @param ps the player whose turn it is' scorecard
    */
   public ScoreCard PointChoice(ScoreCard ps, DiceRoll pd)
   {
      CategoryValue ONES = CategoryValue.ONES;
      CategoryValue TWOS = CategoryValue.TWOS;
      CategoryValue THREES = CategoryValue.THREES;
      CategoryValue FOURS = CategoryValue.FOURS;
      CategoryValue FIVES = CategoryValue.FIVES;
      CategoryValue SIXES = CategoryValue.SIXES;
      CategoryValue THREE_OF_A_KIND = CategoryValue.THREE_OF_A_KIND;
      CategoryValue FOUR_OF_A_KIND = CategoryValue.FOUR_OF_A_KIND;
      CategoryValue FULL_HOUSE = CategoryValue.FULL_HOUSE;
      CategoryValue SM_STRAIGHT = CategoryValue.SM_STRAIGHT;
      CategoryValue LG_STRAIGHT = CategoryValue.LG_STRAIGHT;
      CategoryValue YAHTZEE = CategoryValue.YAHTZEE;
      CategoryValue CHANCE = CategoryValue.CHANCE;
      System.out.println("Select a category that you have not scored in yet:");
      System.out.printf("\n1: Ones, %s points\n2: Twos, %s points\n3: Threes, %s points\n4: Fours, %s points\n5: Fives, %s points\n6: Sixes, %s points\n7: Three of a Kind, %s points\n8: Four of a Kind, %s points\n9: Full House, %s points\n10: Small Straight, %s points\n11: Large Straight, %s points\n12: Yahtzee, %s points\n13: Chance, %s points\n",
                        ps.getEvaluation(ONES, pd), 
                        ps.getEvaluation(TWOS, pd),
                        ps.getEvaluation(THREES, pd),
                        ps.getEvaluation(FOURS, pd),
                        ps.getEvaluation(FIVES, pd),
                        ps.getEvaluation(SIXES, pd),
                        ps.getEvaluation(THREE_OF_A_KIND, pd),
                        ps.getEvaluation(FOUR_OF_A_KIND, pd),
                        ps.getEvaluation(FULL_HOUSE, pd),
                        ps.getEvaluation(SM_STRAIGHT, pd),
                        ps.getEvaluation(LG_STRAIGHT, pd),
                        ps.getEvaluation(YAHTZEE, pd),
                        ps.getEvaluation(CHANCE, pd));
      Scanner input = new Scanner(System.in);

      int over = 1;
      while (over == 1)
      {
         String choice = input.next();
         if (choice.equals("1"))
         {
            if (ps.checkScored(ONES) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(ONES, pd);
               System.out.printf("You just scored %s points in Ones!", ps.getEvaluation(ONES, pd));
               over = 2;
            }
         }  
         else if (choice.equals("2"))
         {
            if (ps.checkScored(TWOS) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else
            {
               ps.choose(TWOS, pd);
               System.out.printf("You just scored %s points in Twos!", ps.getEvaluation(TWOS, pd));
               over = 2;
            }
         }
         else if (choice.equals("3"))
         {
            if (ps.checkScored(THREES) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else
            {
               ps.choose(THREES, pd);
               System.out.printf("You just scored %s points in Threes!", ps.getEvaluation(THREES, pd));
               over = 2;
            }
         }
         else if (choice.equals("4"))
         {
            if (ps.checkScored(FOURS) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(FOURS, pd);
               System.out.printf("You just scored %s points in Fours!", ps.getEvaluation(FOURS, pd));
               over = 2;
            }
         }
         else if (choice.equals("5"))
         {
            if (ps.checkScored(FIVES) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(FIVES, pd);
               System.out.printf("You just scored %s points in Fives!", ps.getEvaluation(FIVES, pd));
               over = 2;
            }
         }
         else if (choice.equals("6"))
         {
            if (ps.checkScored(SIXES) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(SIXES, pd);
               System.out.printf("You just scored %s points in Sixes!", ps.getEvaluation(SIXES, pd));
               over = 2;
            }
         }
         else if (choice.equals("7"))
         {
            if (ps.checkScored(THREE_OF_A_KIND) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(THREE_OF_A_KIND, pd);
               System.out.printf("You just scored %s points in Three of a Kind!", ps.getEvaluation(THREE_OF_A_KIND, pd));
               over = 2;
            }
         }
         else if (choice.equals("8"))
         {
            if (ps.checkScored(FOUR_OF_A_KIND) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(FOUR_OF_A_KIND, pd);
               System.out.printf("You just scored %s points in Four of a Kind!", ps.getEvaluation(FOUR_OF_A_KIND, pd));
               over = 2;
            }
         }
         else if (choice.equals("9"))
         {
            if (ps.checkScored(FULL_HOUSE) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(FULL_HOUSE, pd);
               System.out.printf("You just scored %s points in Full House!", ps.getEvaluation(FULL_HOUSE, pd));
               over = 2;
            }
         }
         else if (choice.equals("10"))
         {
            if (ps.checkScored(SM_STRAIGHT) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(SM_STRAIGHT, pd);
               System.out.printf("You just scored %s points in Small Straight!", ps.getEvaluation(SM_STRAIGHT, pd));
               over = 2;
            }
         }
         else if (choice.equals("11"))
         {
            if (ps.checkScored(LG_STRAIGHT) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(LG_STRAIGHT, pd);
               System.out.printf("You just scored %s points in Large Straight!", ps.getEvaluation(LG_STRAIGHT, pd));
               over = 2;
            }
         }
         else if (choice.equals("12"))
         {
            if (ps.checkScored(YAHTZEE) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(YAHTZEE, pd);
               System.out.printf("You just scored %s points in Yahtzee!", ps.getEvaluation(YAHTZEE, pd));
               over = 2;
            }
         }
         else if (choice.equals("13"))
         {
            if (ps.checkScored(CHANCE) == true)
            {
               System.out.println("Please select a category that you have yet to choose.");
            }
            else 
            {
               ps.choose(CHANCE, pd);
               System.out.printf("You just scored %s points in Chance!", ps.getEvaluation(CHANCE, pd));
               over = 2;
            }
         }
         else
         {
            System.out.println("Please input the corresponding number to the Category of your choice");
         }
      }
      return ps;
   }             
}
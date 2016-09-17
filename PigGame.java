import java.util.Scanner;
import java.util.Random;
public class PigGame {
    
    /**
    * 
    * @param args
    */
    public static void main(String[] args) 
    {
        int PlayerAScore = 0;
        int PlayerATotal = 0;
        int PlayerBScore = 0;
        int PlayerBTotal = 0;
        final int WIN = 100;
        int dice;
        boolean PlayerTurn = true;
        boolean PlayerTurn2 = true;
        
        Random randomnumber = new Random();
    
        System.out.println("Welcome to Pig! let me explain the rules brielfy:\n");
        System.out.println("On your turn, roll the die. If you get a 1");
        System.out.println("your turn is over. Otherwise, your roll");
        System.out.println("is the number of points youve accumulated. ");
        System.out.println("You can then either stop and score the points you’ve");
        System.out.println("accumulated, or roll again trying to accumulate more points.");
        System.out.println("If you ever roll a 1, your turn ends and you lose all");
        System.out.println("the points you’ve accumulated,but not those");
        System.out.println("you scored on previous turns.\n");
        System.out.println ("The goal is to be the first player to reach 100!\n");
        
        
        while (PlayerATotal < WIN || PlayerBTotal < WIN) {
        
            // BEGINGING OF A PLAYER LOOP
            while(PlayerTurn == true && PlayerATotal < WIN) {  
                System.out.println("Score: "+PlayerATotal+"-"+PlayerBTotal);
                System.out.println("Player A, it is your turn.");
                 
                dice = randomnumber.nextInt(6) + 1;         
                    
                if ( dice != 1 ) {                     
                    PlayerAScore += dice;
                    System.out.println("You have rolled a "+dice);
                    System.out.println("Your curent score is " + PlayerAScore + " points.");    
                    PlayerTurn = true;
                    PlayerTurn2 = false;
                   
                    
                    Scanner scanIn = new Scanner(System.in);
                    System.out.println("Keep going? (y/n) \n");
                    String hitnforno = scanIn.nextLine();
           
                    if (hitnforno.equals("n")) {
                        PlayerATotal += PlayerAScore;
                        PlayerTurn = false;
                        PlayerTurn2 = true;
                        System.out.println(hitnforno);
                    }
                    else {
                        PlayerTurn = true;
                        PlayerTurn2 = false;
                        System.out.println(hitnforno);
                    }
                }
                    
                else {
                    dice=1; 
                    System.out.println("You rolled a 1 you lose your points for this turn \n");
                    PlayerAScore = 0;
                    PlayerTurn = false;
                    PlayerTurn2 = true;
                }
                
                if (PlayerATotal >= WIN) {
                    System.out.println("Game over! Player A wins!");
                    PlayerTurn2 = false;
                    break;
                }
            } // End of player a turn loop
            
                       
            while(PlayerTurn2 == true && PlayerBTotal < WIN) {                       
                System.out.println("Score: "+PlayerATotal+"-"+PlayerBTotal);
                System.out.println("Player B, it is your turn.");
                        
                dice = randomnumber.nextInt(6) + 1;           
                           
                if ( dice != 1 ) {     
                    PlayerBScore += dice;
                    System.out.println("You have rolled a "+dice);
                    System.out.println("Your curent score is " + PlayerBScore + " points."); 
                    PlayerTurn = true;   
                    
                    Scanner scanIn = new Scanner(System.in);
                    System.out.println("Keep going? (y/n) \n");
                    String hitnforno = scanIn.nextLine();
                  
                    if (hitnforno.equals("n")) {
                        PlayerBTotal+=PlayerBScore;
                        PlayerTurn2 = false;
                        PlayerTurn = true;
                        }
                    else {
                        PlayerTurn2 = true;
                        PlayerTurn = false;
                    }
                } // End of PlayerTurn2 
                
                           
                else {
                    dice=1; 
                    System.out.println("You rolled a 1 you lose your points for this turn \n");
                    PlayerTurn2 = false;
                    PlayerBScore = 0;
                    PlayerTurn = true;
                }
                
                if (PlayerBTotal >= WIN) {
                    System.out.println("Game over! Player B wins!");
                    PlayerTurn = false;
                    break;
                }
            } // end of payer b loop 
       } // End of While players scores are below 100
    } // end of main
} // end of class 
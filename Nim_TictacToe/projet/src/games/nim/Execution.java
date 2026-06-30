package games.nim;

import java.util.Scanner;





public class Execution {
	public static void main(String[] args){
	
		  Scanner scanner = new Scanner (System.in);
		  System.out.println("Enter first player name :"); // on entre le nom du joueur 1
		  String inputStr = scanner.next();
		  
		  System.out.println("Enter second player name :"); // on entre le nom du joueur 2
		  String inputStr2 = scanner.next();
		  
		  System.out.println("Enter max number of matches :");// on entre le nombre d'allumettes du tas  au début
		  String inputStr3 = scanner.next();
      int inputInt = Integer.parseInt ( inputStr3 );
      
      System.out.println("Enter max number of matches takable :");// on tre le nombre d'allumette maximal pouvant etre retirée chaque tour
       String inputStr4 = scanner.next();
      int inputInt2 = Integer.parseInt ( inputStr4 );
      
      
      
      Nim play = new Nim(inputInt, inputInt2 , inputStr  , inputStr2 ); // on instancie la classe Nim
      
      while(!play.isOver()){
          
          System.out.println("the current player can enter their move:");   
         String inputStr5 = scanner.next();                      // on  entre le nombre d'allumette voulant etre retiré
           int inputStr6 = Integer.parseInt ( inputStr5 );   // on convertit la valeur entée en int
          
         while(!play.isValid(inputStr6)){ // tant que le nombre d'allumette  à retirer n'est pas valide on demant au joueur de réessayer
         
            
            System.out.println("invalid move , it is still " + play.Currentplayer + "'s turn to play , Try again :");
             String inputStr7 = scanner.next();
             inputStr6 = Integer.parseInt ( inputStr7 );
            
         
         } 
         
         
         play.removeMatches(inputStr6); // on retire le nombre d'allumette sélectionnée et on change de joueur
         
         if(play.CurrentAllumettes > 0){   // on vérifie si le nombre d'allumette est fini avant de retourner ou non la situation
         
         System.out.println(play.situationToString());
         
         } else System.out.println("the number of matches is finished !!!");
         
         if(play.CurrentAllumettes > 0){
         
         System.out.println("it is "+  play.Currentplayer + " turn's to play.");
         
         }
      }
      
      scanner.close();
      System.out.println("the winner is :  " + play.getWinner()); // on retourne le gagnant
      
	  }

}

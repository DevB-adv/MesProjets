package games.nim;

public class Nim {

 int tailleInit; // taille initial du tas d'allumettes
 int maxAllumettes; // maximum d'allumetes pouvant etre retirées
 String player1; // joueur 1
 String player2; // joueur 2
 int CurrentAllumettes; // nombre courant d'allumettes
 String Currentplayer; // joueur courant
 int Allumettes; // allumettes retirées à chaque tour de jeu
 
 public Nim( int tailleInit , int maxAllumettes , String player1 , String player2 ){

       this.tailleInit = tailleInit;
       this.maxAllumettes = maxAllumettes;
       this.player1 = player1;
       this.player2 = player2; 
       this.CurrentAllumettes = tailleInit ;
       this.Currentplayer = player1 ;
       
       
       
    }
      

    public int getInitialNbMatches(){ // méthode permettant d'obtenir le nombre initial d'allumette
   
      return tailleInit;
 
       
    }
    
 
    public int getCurrentNbMatches(){ // méthode permettant d'obtenir le nombre courant d'allumette
   
      return CurrentAllumettes;
 
       
    }


    public String getCurrentPlayer(){ // méthode permettant d'obtenir le joueur courant
    
      return Currentplayer;
 
       
   }
 
 
    public String situationToString(){ // méthode permettant de connaitre la situation actuel
    
      return "there is " + getCurrentNbMatches() + " match(es) left";
 
       
   }

 public void removeMatches(int Allumettes){ //méthode coeur permettant de jouer au jeu et de faire le changement de joueur chaque tour
    
    CurrentAllumettes = getCurrentNbMatches() - Allumettes ;
      if(CurrentAllumettes >= 0){
          if(Currentplayer == player1){
          Currentplayer = player2;
    
    }else  Currentplayer = player1;
    
   } 
 }  
    
   
  public boolean isOver(){ //méthode vérifiant si le jeu est terminée
    
    if( CurrentAllumettes == 0){
             return true;      
    }else return false;
    
  } 
   
   
  public boolean isValid(int Allumettes){ // méthode vérifiant si les coups entrés sont valides
    
    if(Allumettes > 0 && Allumettes <= maxAllumettes && Allumettes <= CurrentAllumettes){
             return true;      
    }else return false;
    
  }   
   
 public String getWinner(){ // méthode retournant le gagnant
 
  if(CurrentAllumettes == 0){
  
     return Currentplayer;  
  
  }else return null; 
 
 
 
 }   
    







}


























































































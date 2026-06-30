package games.players;

import games.genericgames.Game;
import java.util.Random;

public class RandomPlayer implements Player { // création du joueur robot

  Random alea = new Random();

  public RandomPlayer(Random alea) { // construction de l'attribut du joueur random se résumant à un objet random
    this.alea = alea;
  }

  public int chooseMove(Game g) {// méthode permettant au robot de choisir un move
    System.out.println("\n");
    System.out.println(g.toString());
    System.out.println("\n valid moves : \n");
    for (int i = 0; i < g.validMoves().size(); i++) { //on affiche les move valids que le robot peut choisir
      System.out.println(g.moveToString(g.validMoves().get(i)));
    }

    System.out.println(
      "\n it is " + g.getCurrentPlayer() + " to choose a move."
    );
    System.out.println("\n random move chosen : ");
    int randchoices = alea.nextInt(g.validMoves().size()); // on initialise l'aléa sur les coups valides
    int randchoice = g.validMoves().get(randchoices); // un coup valide au hasard est alors choisi
    System.out.println(randchoice); 

    return randchoice; // on retourne ce coup
  }

  @Override
  public String toString() { // on redéfinit tostring pour les robot de tel sorte que le robot soit désigné par une succession de chiffre aléatoire
    return "Joueur aléatoire n° " + this.hashCode();
  }
}

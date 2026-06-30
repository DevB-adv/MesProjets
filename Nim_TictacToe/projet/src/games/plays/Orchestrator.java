package games.plays;

import games.genericgames.Game;
import games.players.Player;

public class Orchestrator { //cette classe permet comme son nom l'indique d'orchestrer le jeu

  Game toying; // on initialise le jeu à orchestrer 

  public Orchestrator(Game toying) { // on crée le constructeur pour donner une valeur a notre attribut parmi un des jeux créés
    this.toying = toying;
  }

  public void play() {
    while (!toying.isOver()) { //tant que la parti n'est pas terminée
     
      int v = toying.getCurrentPlayer().chooseMove(toying); // on récupére le coup sélectionné
      toying.execute(v); //on l'éxecute
    }

    System.out.println(toying.toString()); // on affiche l'état du jeu
    System.out.println("game over");
    if (toying.getWinner() == null) { // si getwinner retourne null , on a un match null
      System.out.println("match nul");
    } else System.out.println("the winner is :  " + toying.getWinner()); // sinon on donne le nom du gagnant
  }
}

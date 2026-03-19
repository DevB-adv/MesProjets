package games.genericgames;

import games.players.Player;

public abstract class AbstractGame implements Game {

  Player player1;
  Player player2;
  Player currentplayer;

  public AbstractGame(Player player1, Player player2) { // constructeur de la classe abstraite permettant la soustraction des attributs
    this.player1 = player1;
    this.player2 = player2;
    this.currentplayer = player1;
  }

  protected abstract void doExecute(int x); // déclaration de la méthode doexecute

  public void execute(int x) {// métode execute soustraite du jeu tictactoe et nim qui sera redéfinis dans les 2 respectivement
    doExecute(x);

    if (currentplayer == player1) { // retourne le joueur courant pour les 2 jeux
      currentplayer = player2;
    } else currentplayer = player1;
  }

  public Player getCurrentPlayer() {
    return currentplayer;
  }
}

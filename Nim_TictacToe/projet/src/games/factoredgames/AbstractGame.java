package games.factoredgames;

public abstract class AbstractGame { 

  String player1;
  String player2;
  String currentplayer;

  public AbstractGame(String player1, String player2) { // constructeur de la classe abstraite permettant la soustraction des attributs
    this.player1 = player1;
    this.player2 = player2;
    this.currentplayer = player1;
  }

  protected abstract void doExecute(int x); // déclaration de la méthode doexecute 

  public void execute(int x) { // métode execute soustraite du jeu tictactoe et nim qui sera redéfinis dans les 2 respectivement
    doExecute(x); 

    if (currentplayer == player1) {
      currentplayer = player2;
    } else currentplayer = player1;
  }

  public String getCurrentPlayer() { // retourne le joueur courant pour les 2 jeux
    return currentplayer;
  }
}

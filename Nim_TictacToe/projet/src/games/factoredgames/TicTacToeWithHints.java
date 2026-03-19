package games.factoredgames;

import java.util.ArrayList;

public class TicTacToeWithHints extends TicTacToe { 

  public TicTacToeWithHints(String player1, String player2) { // constructeur de la classe
    super(player1, player2);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        morpion[i][j] = ".";
      }
    }
  }

  public ArrayList<Integer> hints() { // méthode permettant de créer une liste d'indices de jeu de l'adversaire
    ArrayList<Integer> HintsTab = new ArrayList<Integer>();

    int Hints = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (morpion[i][j] == ".") {
          if (currentplayer == player1) {
            morpion[i][j] = "O";
            if (getWinner() == player2) {
              HintsTab.add(Hints);
              morpion[i][j] = ".";
            } else morpion[i][j] = ".";
          } else if (currentplayer == player2) {
            morpion[i][j] = "X";
            if (getWinner() == player1) {
              HintsTab.add(Hints);
              morpion[i][j] = ".";
            } else morpion[i][j] = ".";
          }
        }
        Hints++;
      }
    }

    return HintsTab;
  }

  @Override
   public ArrayList<Integer> validMoves() { // méthode créant une liste de coup valides
    ArrayList<Integer> valids = new ArrayList<Integer>();

    int Numbers = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (morpion[i][j] == "." || morpion[i][j]== "!") {
          valids.add(Numbers);
        }
        Numbers++;
      }
    }
    return valids;
  }




  public boolean isValid2(int move) { // méthode vérifiant si les coups entrés sont valides
    if (
      move <= 8 &
      move >= 0 &
      morpion[getline(move)][getcolumn(move)] == "." ||
      morpion[getline(move)][getcolumn(move)] == "!"
    ) {
      return true;
    } else return false;
  }

  public String toString2() { // méthode permettant d'afficher le morpion avec les indices
    String chaine = "";
    for (int i = 0; i < this.morpion.length; i++) {
      for (int j = 0; j < this.morpion[i].length; j++) {
        for (int a = 0; a < hints().size(); a++) {
          if (!isOver()) {
            morpion[getline(hints().get(a))][getcolumn(hints().get(a))] = "!";
          }
        }
        chaine += this.morpion[i][j] + " ";
      }
      chaine += "\n";
    }

    return chaine;
  }
}

package games.genericgames;

import games.players.Human;
import games.players.Player;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToeWithHints extends TicTacToe {

  public TicTacToeWithHints(Player player1, Player player2) { // constructeur de la classe
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
          } else if (currentplayer == player2 ) {
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
  public boolean isValid(int move) { // méthode vérifiant si les coups entrés sont valides
    if (
      move <= 8 &
      move >= 0 &
      morpion[getline(move)][getcolumn(move)] == "." ||
      morpion[getline(move)][getcolumn(move)] == "!"
    ) {
      return true;
    } else return false;
  }

  @Override
  public ArrayList<Integer> validMoves() { // méthode créant une liste de coup valides
    ArrayList<Integer> valids = new ArrayList<Integer>();

    int Numbers = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (morpion[i][j] == "." || morpion[i][j] == "!") {
          valids.add(Numbers);
        }
        Numbers++;
      }
    }

    return valids;
  }

  @Override
  public String toString() { // méthode permettant d'afficher le morpion avec les indices
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

  @Override
  public Game copy() {
    TicTacToeWithHints game3 = new TicTacToeWithHints(player1, player2);
    game3.morpion = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        game3.morpion[i][j] = this.morpion[i][j];
      }
    }
    game3.currentplayer = super.currentplayer;
    return game3;
  }
}

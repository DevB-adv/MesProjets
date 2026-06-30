package games.tictactoe;

import java.util.ArrayList;

public class TicTacToe {

  String player1; // le joueur1
  String player2; // le joueur 2
  String Currentplayer; // le joueur courant
  String[][] morpion; // le morpion
  int move; // les coups joués

  public TicTacToe(String player1, String player2) {
    this.morpion = new String[3][3];
    this.player1 = player1;
    this.player2 = player2;
    this.Currentplayer = player1;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        morpion[i][j] = ".";
      }
    }
  }

  public String getCurrentPlayer() { // méthode retournant le joueur courant
    return Currentplayer;
  }

  public int getline(int move) { // méthode pour obtenir les lignes
    if (move == 0 || move == 1 || move == 2) {
      return 0;
    } else if (move == 3 || move == 4 || move == 5) {
      return 1;
    } else return 2;
  }

  public int getcolumn(int move) { //méthode pour obtenir les colonnes
    if (move == 0 || move == 3 || move == 6) {
      return 0;
    } else if (move == 1 || move == 4 || move == 7) {
      return 1;
    } else return 2;
  }

  public void execute(int move) { //méthode coeur permettant de jouer au jeu et de faire le changement de joueur chaque tour
    if (Currentplayer == player1) {
      morpion[getline(move)][getcolumn(move)] = "X";
      Currentplayer = player2;
    } else if (Currentplayer == player2) {
      morpion[getline(move)][getcolumn(move)] = "O";
      Currentplayer = player1;
    }
  }

  public boolean isValid(int move) { // méthode vérifiant si les coups entrés sont valides
    if (
      move <= 8 & move >= 0 & morpion[getline(move)][getcolumn(move)] == "."
    ) {
      return true;
    } else return false;
  }

  public ArrayList<Integer> validMoves() { // méthode créant une liste de coup valides
    ArrayList<Integer> valids = new ArrayList<Integer>();

    int Numbers = 0;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (morpion[i][j] == ".") {
          valids.add(Numbers);
        }
        Numbers++;
      }
    }
    return valids;
  }

  public String getWinner() { //méthode retournant le nom du gagnant
    if (
      morpion[0][0] == "X" &&
      morpion[0][1] == "X" &&
      morpion[0][2] == "X" ||
      morpion[1][0] == "X" &&
      morpion[1][1] == "X" &&
      morpion[1][2] == "X" ||
      morpion[2][0] == "X" &&
      morpion[2][1] == "X" &&
      morpion[2][2] == "X" ||
      morpion[0][0] == "X" &&
      morpion[1][0] == "X" &&
      morpion[2][0] == "X" ||
      morpion[0][1] == "X" &&
      morpion[1][1] == "X" &&
      morpion[2][1] == "X" ||
      morpion[0][2] == "X" &&
      morpion[1][2] == "X" &&
      morpion[2][2] == "X" ||
      morpion[0][0] == "X" &&
      morpion[1][1] == "X" &&
      morpion[2][2] == "X" ||
      morpion[0][2] == "X" &&
      morpion[1][1] == "X" &&
      morpion[2][0] == "X"
    ) {
      return player1;
    } else if (
      morpion[0][0] == "O" &&
      morpion[0][1] == "O" &&
      morpion[0][2] == "O" ||
      morpion[1][0] == "O" &&
      morpion[1][1] == "O" &&
      morpion[1][2] == "O" ||
      morpion[2][0] == "O" &&
      morpion[2][1] == "O" &&
      morpion[2][2] == "O" ||
      morpion[0][0] == "O" &&
      morpion[1][0] == "O" &&
      morpion[2][0] == "O" ||
      morpion[0][1] == "O" &&
      morpion[1][1] == "O" &&
      morpion[2][1] == "O" ||
      morpion[0][2] == "O" &&
      morpion[1][2] == "O" &&
      morpion[2][2] == "O" ||
      morpion[0][0] == "O" &&
      morpion[1][1] == "O" &&
      morpion[2][2] == "O" ||
      morpion[0][2] == "O" &&
      morpion[1][1] == "O" &&
      morpion[2][0] == "O"
    ) {
      return player2;
    }

    return null;
  }

  public boolean isOver() { //méthode vérifiant si le jeu est fini
    if (getWinner() == player1 || getWinner() == player2) {
      return true;
    } else if (
      morpion[0][0] != "." &&
      morpion[0][1] != "." &&
      morpion[0][2] != "." &&
      morpion[1][0] != "." &&
      morpion[1][1] != "." &&
      morpion[1][2] != "." &&
      morpion[2][0] != "." &&
      morpion[2][1] != "." &&
      morpion[2][2] != "."
    ) {
      return true;
    }

    return false;
  }

  String moveToString(int move) { // méthode aidant à afficher le statut des coups valides
    return move + "=" + "(" + getline(move) + "," + getcolumn(move) + ")\n";
  }

  @Override
  public String toString() { // méthode permettant d'afficher le morpion
    String chaine = "";
    for (int i = 0; i < this.morpion.length; i++) {
      for (int j = 0; j < this.morpion[i].length; j++) {
        chaine += this.morpion[i][j] + " ";
      }
      chaine += "\n";
    }
    return chaine;
  }
}

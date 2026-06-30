package games.genericgames;

import games.players.Player;
import java.util.ArrayList;

public class TicTacToe extends AbstractGame implements Game {

 public String[][] morpion; // le morpion
 public int move; // les coups joués

  public TicTacToe(Player player1, Player player2) {
    super(player1, player2);
    this.morpion = new String[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        morpion[i][j] = ".";
      }
    }
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

  public void doExecute(int move) { //méthode coeur permettant de jouer au jeu et de faire le changement de joueur chaque tour
    if (currentplayer == player1) {
      morpion[getline(move)][getcolumn(move)] = "X";
    } else if (currentplayer == player2) {
      morpion[getline(move)][getcolumn(move)] = "O";
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

  public Player getWinner() { //méthode retournant le nom du gagnant
       
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

  public String moveToString(int move) { // méthode aidant à afficher le statut des coups valides
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

  

  public Game copy() {
    TicTacToe game2 = new TicTacToe(player1, player2);
    game2.morpion = new String[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        game2.morpion[i][j] = this.morpion[i][j];
      }
    }
    game2.currentplayer = super.currentplayer;
    return game2;
  }
}

package games.genericgames;

import games.players.Player;
import java.util.ArrayList;

public class Nim extends AbstractGame implements Game { // meme code que la classe 
//Nim du package Nim sauf que les joueurs sont maintenant de type player

  int tailleInit;
  int maxAllumettes;
  int CurrentAllumettes;
  int Allumettes;

  public Nim(
    int tailleInit,
    int maxAllumettes,
    Player player1,
    Player player2
  ) {
    super(player1, player2);
    this.tailleInit = tailleInit;
    this.maxAllumettes = maxAllumettes;
    this.CurrentAllumettes = tailleInit;
  }

  public int getInitialNbMatches() {
    return tailleInit;
  }

  public int getCurrentNbMatches() {
    return CurrentAllumettes;
  }

  public String toString() {
    return "there is " + getCurrentNbMatches() + " match(es) left";
  }

  public String moveToString(int Allumettes) {
    return " * " + Allumettes + " ";
  }

  public void doExecute(int Allumettes) {
    CurrentAllumettes = getCurrentNbMatches() - Allumettes;
  }

  public boolean isOver() {
    if (CurrentAllumettes == 0) {
      return true;
    } else return false;
  }

  public boolean isValid(int Allumettes) {
    if (
      Allumettes > 0 &&
      Allumettes <= maxAllumettes &&
      Allumettes <= CurrentAllumettes
    ) {
      return true;
    } else return false;
  }

  public ArrayList<Integer> validMoves() {
    ArrayList<Integer> valids = new ArrayList<Integer>();

    int Numbers = 1;
    for (int i = 1; i <= CurrentAllumettes; i++) {
      if (
        Numbers > 0 && Numbers <= maxAllumettes && Numbers <= CurrentAllumettes
      ) {
        valids.add(Numbers);
      }

      Numbers++;
    }

    return valids;
  }

  public Player getWinner() {
    if (CurrentAllumettes == 0) {
      return currentplayer;
    } else return null;
  }

  

  public Game copy() {
    Nim game = new Nim(tailleInit, maxAllumettes, player1, player2);
    game.CurrentAllumettes = this.CurrentAllumettes;
    game.currentplayer = super.currentplayer;
    return game;
  }
}

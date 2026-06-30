package games.factoredgames;

public class Nim extends AbstractGame { // meme class Nim que celle dans le package nim qui herite d'abstractGame

  int tailleInit;
  int maxAllumettes;
  int CurrentAllumettes;
  int Allumettes;

  public Nim(
    int tailleInit,
    int maxAllumettes,
    String player1,
    String player2
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

  public String situationToString() {
    return "there is " + getCurrentNbMatches() + " match(es) left";
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

  public String getWinner() {
    if (CurrentAllumettes == 0) {
      return currentplayer;
    } else return null;
  }
}

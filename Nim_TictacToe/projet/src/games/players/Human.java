package games.players;

import games.genericgames.Game;
import java.util.Scanner;

public class Human implements Player {

  String name;
  Scanner entry = new Scanner(System.in);

  public Human(String name, Scanner entry) {
    this.name = name;
    this.entry = entry;
  }

  public int chooseMove(Game g) {
    System.out.println(g.toString());
    System.out.println(
      "\n it is " + g.getCurrentPlayer() + "'s turn to play \n"
    );
    System.out.println(" valid moves : \n");
    for (int i = 0; i < g.validMoves().size(); i++) {
      System.out.println(g.moveToString(g.validMoves().get(i)));
    }

    System.out.println("\n " + g.getCurrentPlayer() + " can choose a move : ");

    String inputStr = entry.next();
    int inputStr2 = Integer.parseInt(inputStr);

    while (!g.validMoves().contains(inputStr2)) {
      System.out.println(
        "invalid move , it is still " +
        g.getCurrentPlayer() +
        "'s turn to play , Try again :"
      );

      String inputStr3 = entry.next();
      inputStr2 = Integer.parseInt(inputStr3);
    }

    return inputStr2;
  }

  @Override
  public String toString() {
    return this.name;
  }
}

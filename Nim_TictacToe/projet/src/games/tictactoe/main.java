package games.tictactoe;

import gamestests.tictactoe.TicTacToeTests;
import gamestests.tictactoe.TicTacToeWithHintsTests;

public class main {

  public static void main(String[] args) {
    boolean ok = true;
    TicTacToeTests ticTacToeTester = new TicTacToeTests();
    ok = ok && ticTacToeTester.testGetCurrentPlayer();
    ok = ok && ticTacToeTester.testExecuteAndIsValid();
    ok = ok && ticTacToeTester.testValidMoves();
    ok = ok && ticTacToeTester.testGetWinner();
    ok = ok && ticTacToeTester.testIsOver();
    System.out.println(
      ok ? " All ␣ tests ␣ OK " : " At ␣ least ␣ one ␣ test ␣ KO "
    );

    TicTacToeWithHintsTests tester = new TicTacToeWithHintsTests();
    ok = ok && tester.testGetCurrentPlayer();
    ok = ok && tester.testExecuteAndIsValid();
    ok = ok && tester.testValidMoves();
    ok = ok && tester.testGetWinner();
    ok = ok && tester.testIsOver();
    ok = ok && tester.testHints();
    System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣KO");
  }
}

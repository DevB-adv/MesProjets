package games.genericgames;

import gamestests.genericgames.AbstractGameTests;
import gamestests.genericgames.NimTests;
import gamestests.genericgames.TicTacToeTests;
import gamestests.genericgames.TicTacToeWithHintsTests;
import games.players.Human;
import java.util.Scanner;


public class main {

  public static void main(String[] args) {
   
  /* Scanner scanner = new Scanner(System.in);
  System.out.println("Enter first player name :"); 
    String inputStr = scanner.next();
    Human p1 = new Human(inputStr, scanner);

    System.out.println("Enter second player name : \n"); 
    String inputStr2 = scanner.next();
    Human p2 = new Human(inputStr2, scanner);
   TicTacToe j = new TicTacToe(p1,p2);
   j.morpion[0][0]="O";
   j.morpion[0][1]="X";
   j.morpion[0][2]="O";



  System.out.println(j.isOver()); */


    boolean ok = true;
    AbstractGameTests abstractGameTester = new AbstractGameTests();
    ok = ok && abstractGameTester.testGetCurrentPlayer();
    ok = ok && abstractGameTester.testExecute();
    NimTests nimTester = new NimTests();
    ok = ok && nimTester.testGetInitialNbMatches();
    ok = ok && nimTester.testGetCurrentNbMatches();
    ok = ok && nimTester.testGetCurrentPlayer();
    ok = ok && nimTester.testExecute();
    ok = ok && nimTester.testIsValid();
    ok = ok && nimTester.testValidMoves();
    ok = ok && nimTester.testIsOver();
    ok = ok && nimTester.testGetWinner();
    ok = ok && nimTester.testCopy();

    TicTacToeTests ticTacToeTester = new TicTacToeTests();
    ok = ok && ticTacToeTester.testGetCurrentPlayer();
    ok = ok && ticTacToeTester.testExecuteAndIsValid();
    ok = ok && ticTacToeTester.testValidMoves();
    ok = ok && ticTacToeTester.testGetWinner();
    ok = ok && ticTacToeTester.testIsOver();
    ok = ok & ticTacToeTester.testCopy();

    TicTacToeWithHintsTests ticTacToeWithHintsTester = new TicTacToeWithHintsTests();
    ok = ok && ticTacToeWithHintsTester.testGetCurrentPlayer();
    ok = ok && ticTacToeWithHintsTester.testExecuteAndIsValid();
    ok = ok && ticTacToeWithHintsTester.testValidMoves();
    ok = ok && ticTacToeWithHintsTester.testGetWinner();
    ok = ok && ticTacToeWithHintsTester.testIsOver();
    ok = ok && ticTacToeWithHintsTester.testHints();
    ok = ok & ticTacToeWithHintsTester.testCopy();

    System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣KO"); 
  }
}

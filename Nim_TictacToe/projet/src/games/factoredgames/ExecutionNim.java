package games.factoredgames;

import java.util.Scanner;

public class ExecutionNim { // meme classe d'execution que celle dans le pckage nim

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter first player name :");
    String inputStr = scanner.next();

    System.out.println("Enter second player name :");
    String inputStr2 = scanner.next();

    System.out.println("Enter max number of matches :");
    String inputStr3 = scanner.next();
    int inputInt = Integer.parseInt(inputStr3);

    System.out.println("Enter max number of matches takable :");
    String inputStr4 = scanner.next();
    int inputInt2 = Integer.parseInt(inputStr4);

    Nim play = new Nim(inputInt, inputInt2, inputStr, inputStr2);

    while (!play.isOver()) {
      System.out.println("the current player can enter their move:");
      String inputStr5 = scanner.next();
      int inputStr6 = Integer.parseInt(inputStr5);

      while (!play.isValid(inputStr6)) {
        System.out.println(
          "invalid move , it is still " +
          play.currentplayer +
          "'s turn to play , Try again :"
        );
        String inputStr7 = scanner.next();
        inputStr6 = Integer.parseInt(inputStr7);
      }

      play.execute(inputStr6);

      if (play.CurrentAllumettes > 0) {
        System.out.println(play.situationToString());
      } else System.out.println("the number of matches is finished !!!");

      if (play.CurrentAllumettes > 0) {
        System.out.println("it is " + play.currentplayer + " turn's to play.");
      }
    }

    scanner.close();
    System.out.println("the winner is :  " + play.getWinner());
  }
}

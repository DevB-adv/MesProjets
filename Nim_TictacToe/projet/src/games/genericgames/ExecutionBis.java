package games.genericgames;

import games.players.Human;
import games.players.Player;
import java.util.Scanner;

public class ExecutionBis {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter first player name :"); //entrée du nom du joueur 1
    String inputStr = scanner.next();
    Human p1 = new Human(inputStr, scanner);

    System.out.println("Enter second player name : \n"); // entrée du nom du joueur 2
    String inputStr2 = scanner.next();
    Human p2 = new Human(inputStr2, scanner);

    System.out.println("would you like to play morpion with hints or no ???");
    String answer = scanner.next();

    if (answer.equals("oui")) {
      TicTacToeWithHints play = new TicTacToeWithHints(p1, p2); // instantiation du jeu
      System.out.println(play.toString() + "\n");
      while (!play.isOver()) {
        System.out.println("the current player can enter their move:" + "\n");
        String inputStr5 = scanner.next(); // le coup à entrer
        int inputStr6 = Integer.parseInt(inputStr5); // le coup à entrer converti en int

        while (!play.isValid(inputStr6)) { // tant que le coup n'est pas valide on demande à l'utilisateur de reéssayer
          System.out.println(
            "invalid move , it is still " +
            play.currentplayer +
            "'s turn to play , Try again :"
          );
          String inputStr7 = scanner.next();
          inputStr6 = Integer.parseInt(inputStr7);
        }

        play.execute(inputStr6); // on appelle la méthode execute
        System.out.println("\n");
        System.out.println(play.toString()); // on affiche le plateau

        if (!play.isOver()) { // si le jeu n'est pas fini on fait les affichages suivant
          for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              if (play.morpion[i][j] == "!") {
                System.out.println(
                  "\n warning !!! these '!' means your opponent can win by playing on these cases \n"
                );
              }
            }
          }
          System.out.println(" valid moves : \n");
          for (int i = 0; i < play.validMoves().size(); i++) {
            System.out.println(play.moveToString(play.validMoves().get(i))); // on affiche l'ensemble des coups valides
          }

          System.out.println("it is  " + play.currentplayer + "'s turn");
        }
      }

      scanner.close();
      System.out.println("the game is over");
      if (
        play.morpion[0][0] != "." &&
        play.morpion[0][1] != "." &&
        play.morpion[0][2] != "." &&
        play.morpion[1][0] != "." &&
        play.morpion[1][1] != "." &&
        play.morpion[1][2] != "." &&
        play.morpion[2][0] != "." &&
        play.morpion[2][1] != "." &&
        play.morpion[2][2] != "."
      ) {
        System.out.println("match nul"); // on affiche match nul si la condition est rempli
      } else System.out.println("the winner is :  " + play.getWinner()); // on affiche le gagnant
    } else {
      TicTacToe play = new TicTacToe(p1, p2); // instantiation du jeu
      System.out.println(play.toString() + "\n");
      while (!play.isOver()) {
        System.out.println("the current player can enter their move:" + "\n");
        String inputStr5 = scanner.next(); // le coup à entrer
        int inputStr6 = Integer.parseInt(inputStr5); // le coup à entrer converti en int

        while (!play.isValid(inputStr6)) { // tant que le coup n'est pas valide on demande à l'utilisateur de reéssayer
          System.out.println(
            "invalid move , it is still " +
            play.currentplayer +
            "'s turn to play , Try again :"
          );
          String inputStr7 = scanner.next();
          inputStr6 = Integer.parseInt(inputStr7);
        }

        play.execute(inputStr6); // on appelle la méthode execute
        System.out.println("\n");
        System.out.println(play.toString() + "\n"); // on affiche le plateau

        if (!play.isOver()) { // si le jeu n'est pas fini on fait les affichages suivant
          System.out.println("valid moves : \n");
          for (int i = 0; i < play.validMoves().size(); i++) {
            System.out.println(play.moveToString(play.validMoves().get(i))); // on affiche l'ensemble des coups valides
          }

          System.out.println("it is  " + play.currentplayer + "'s turn");
        }
      }

      scanner.close();
      System.out.println("the game is over");
      if (
        play.morpion[0][0] != "." &&
        play.morpion[0][1] != "." &&
        play.morpion[0][2] != "." &&
        play.morpion[1][0] != "." &&
        play.morpion[1][1] != "." &&
        play.morpion[1][2] != "." &&
        play.morpion[2][0] != "." &&
        play.morpion[2][1] != "." &&
        play.morpion[2][2] != "."
      ) {
        System.out.println("match nul"); // on affiche match nul si la condition est rempli
      } else System.out.println("the winner is :  " + play.getWinner()); // on affiche le gagnant
    }
  }
}

package games.genericgames;

import games.players.Human;
import games.players.Player;
import games.players.RandomPlayer;
import games.plays.Orchestrator;
import java.util.Random;
import java.util.Scanner;

public class ExecuteDef {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    System.out.println(
      "which game do you wanna play , nim , tictactoe or tictactoeHinted ?"
    ); 
    String choice = scanner.next();// selection du jeu voulu

    System.out.println("which format , pvp , rvr or pvr");
    String choice2 = scanner.next(); // selection du format , pvp(player vs player)
//rvr(robot vs robot) , pvr(player vs human)
    while (choice.equals("tictactoeHinted") && choice2.equals("rvr")) { // on informe que tictatoe avec des indice ne peus pas etre joué entre robots
      System.out.println(
        "Error , tictactoeHinted cannot be played in rvr , choose a different format: pvp,pvr"
      );
      choice2 = scanner.next();
    }


    if (choice.equals("nim")) {   // le bloc de code suivant nous permet de choisir un jeu , un format de jeu come précisé ci-dessus et de créer les joueur
      if (choice2.equals("pvp")) {
        System.out.println("Enter first player name :");//création d'un humain
        String inputStr = scanner.next();
        Player player1 = new Human(inputStr, scanner);

        System.out.println("Enter second player name :");
        String inputStr2 = scanner.next();
        Player player2 = new Human(inputStr2, scanner);

        System.out.println("Enter max number of matches :");
        String inputStr3 = scanner.next();
        int inputInt = Integer.parseInt(inputStr3);

        System.out.println("Enter max number of matches takable :");
        String inputStr4 = scanner.next();
        int inputInt2 = Integer.parseInt(inputStr4);

        Nim game = new Nim(inputInt, inputInt2, player1, player2);//on instancie le jeu de Nim pour y jouer précisément , on fait la meme chose avec les jeux suivants
        Orchestrator orchestrator = new Orchestrator(game);// on instancie orchestrator
        orchestrator.play();// on demande a orchestrator de jouer le jeu informé ci-dessus , on fait la meme chose pour chaque jeu et format
        scanner.close();

      } else if (choice2.equals("rvr")) {
        Player player1 = new RandomPlayer(rand);//création d'un robot
        Player player2 = new RandomPlayer(rand);

        System.out.println("Enter max number of matches :");
        String inputStr3 = scanner.next();
        int inputInt = Integer.parseInt(inputStr3);

        System.out.println("Enter max number of matches takable :");
        String inputStr4 = scanner.next();
        int inputInt2 = Integer.parseInt(inputStr4);

        Nim game = new Nim(inputInt, inputInt2, player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
      } else {
        System.out.println("Enter first player name :");
        String inputStr = scanner.next();
        Player player1 = new Human(inputStr, scanner);

        Player player2 = new RandomPlayer(rand);

        System.out.println("Enter max number of matches :");
        String inputStr3 = scanner.next();
        int inputInt = Integer.parseInt(inputStr3);

        System.out.println("Enter max number of matches takable :");
        String inputStr4 = scanner.next();
        int inputInt2 = Integer.parseInt(inputStr4);

        Nim game = new Nim(inputInt, inputInt2, player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
      }
    } else if (choice.equals("tictactoe")) {
      if (choice2.equals("pvp")) {
        System.out.println("Enter first player name :");
        String inputStr = scanner.next();
        Player player1 = new Human(inputStr, scanner);

        System.out.println("Enter second player name :");
        String inputStr2 = scanner.next();
        Player player2 = new Human(inputStr2, scanner);

        TicTacToe game = new TicTacToe(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
      } else if (choice2.equals("rvr")) {
        Player player1 = new RandomPlayer(rand);
        Player player2 = new RandomPlayer(rand);

        TicTacToe game = new TicTacToe(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
      } else {
        System.out.println("Enter first player name :");
        String inputStr = scanner.next();
        Player player1 = new Human(inputStr, scanner);
        Player player2 = new RandomPlayer(rand);

        TicTacToe game = new TicTacToe(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
      }
    } else {
      if (choice2.equals("pvp")) {
        System.out.println("Enter first player name :");
        String inputStr = scanner.next();
        Player player1 = new Human(inputStr, scanner);

        System.out.println("Enter second player name :");
        String inputStr2 = scanner.next();
        Player player2 = new Human(inputStr2, scanner);

        TicTacToeWithHints game = new TicTacToeWithHints(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
      } else {
        System.out.println("Enter first player name :");
        String inputStr = scanner.next();
        Player player1 = new Human(inputStr, scanner);
        Player player2 = new RandomPlayer(rand);

        TicTacToeWithHints game = new TicTacToeWithHints(player1, player2);
        Orchestrator orchestrator = new Orchestrator(game);
        orchestrator.play();
        scanner.close();
      }
    }
  }
}

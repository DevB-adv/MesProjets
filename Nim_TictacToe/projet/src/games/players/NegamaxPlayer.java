package games.players;

import games.genericgames.Game;
import games.genericgames.TicTacToe;

public class NegamaxPlayer implements Player { //créion du joueur negamax


  public int evaluate(Game x) { //implementation de l'agorithme evaluate
    Integer res= null;            
    if (x.getWinner()==x.getCurrentPlayer()) { //on vérifie si le joueur cournt a gagné si oui on renvoie 1
      res = 1;
    } else if (x.getWinner() == null) { //on vérifie sinon si l'adversaire a gagné si oui on renvoie -1
      res = 0;
    } else if (x.getWinner()!= null || x.getWinner()!= x.getCurrentPlayer()) { //on vérifie sinon si le match est nul si oui on renvoie 0
      res = -1;
    } else for (int move : x.validMoves()) { //sinon res demeure null et on verifie
    // pour chacun des moves dans la liste de move valides on fait une récursion pour obtenir le move le plus intéressant
      Game replica = x.copy();
      replica.execute(move);
      Game y = replica;
      Player adv = y.getCurrentPlayer();
      int v = -(evaluate(y));
      if (res == null || v > res) {
        res = v;
      }
    }

    return res;
  }

  @Override
  public int chooseMove(Game g) { //implementation de l'algorithme negamax
    Integer bestValue= null; // on iinitialise la meilleur valeur et le meilleur coup a null
    Integer bestMove= null;

    for (int move : g.validMoves()) { //pour chacun des indice correspondant à
    // un move de valid moves on cherche celui avec la meilleur valeur
      Game replica = g.copy();
      replica.execute(move);
      Game y = replica;
      Player adv = y.getCurrentPlayer();
      int v = -(evaluate(y));
      if (bestValue == null || v > bestValue) {
        bestValue = v;
        bestMove = move; // le move avec la meilleur valeur devient le meilleur coup
      }
    }
    return bestMove; //on le retourne le meilleur coup
  }
}

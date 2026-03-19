package games.genericgames;

import games.players.Player;
import java.util.ArrayList;

public interface Game { // interface game initialisant les différentes méthodes qui seront redéfinies dans les jeux
  public Player getCurrentPlayer();

  public void execute(int x);

  public boolean isValid(int x);

  public ArrayList<Integer> validMoves();

  public Player getWinner();

  public boolean isOver();

  public String moveToString(int x);

  public String toString();

  public Game copy();

  
}

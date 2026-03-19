package games.players;

import games.genericgames.Game;

public interface Player { // interface player ou la méthode choosemove est initialisé puis impléenté par les différent joueurs
  public int chooseMove(Game g);
}

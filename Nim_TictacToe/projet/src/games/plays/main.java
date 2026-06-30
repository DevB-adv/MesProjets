package games.plays;

import gamestests.plays.OrchestratorTests;

public class main {

  public static void main(String[] args) {
    boolean ok = true;

    OrchestratorTests tester = new OrchestratorTests();
    // Change argument to true in next call to reactivate printing
    ok = ok && tester.testPlay(false);
    System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣OK");
  }
}

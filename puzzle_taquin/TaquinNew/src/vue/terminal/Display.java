package terminal;
import  taquin.Taquin;
import  tuile.Tuile;
import  modele.ModelListener;
import  modele.AbstractListenableModel;


public class Display implements ModelListener{
    private Taquin taquin;

    public Display(Taquin taquin){
        this.taquin = taquin;
        this.taquin.addListener(this);
    }


    private void affichageTaquin(Taquin taquin, Tuile[][] tabPourLaCopie){
        Tuile[][] taquinBoardCopy = tabPourLaCopie;
        
        for(int ligne = 0; ligne < taquin.getLignes(); ligne++){
            for(int colonne = 0; colonne < taquin.getColonnes(); colonne++){
                Color color = whichColor(taquinBoardCopy[ligne][colonne]);
                System.out.print( color + " " + taquinBoardCopy[ligne][colonne] + " "  + Color.RESET_COLOR);
            }
            System.out.println();
        }
        System.out.println("");
    }

    // permet d'afficher l'état initial de taquin
    private void affichageTaquinEtatInit(){
        affichageTaquin(this.taquin, taquin.getBoardInit());
    }

    // permet d'afficher l'état suivant du taquin
    private void affichageTaquinEtatSuivant(){
        affichageTaquin(this.taquin, taquin.getBoard());
    }
    
    // si le modele est maj on maj l'affichage du plateau
    @Override
    public void modelUpdated(Object source){
        System.out.println("\u001B[44m" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +"\u001B[0m" + "\n");
        System.out.println("Taquin etat initial : ");
        affichageTaquinEtatInit();
        System.out.println("Taquin etat suivant : ");
        affichageTaquinEtatSuivant();
        System.out.println("\u001B[44m" + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +"\u001B[0m" + "\n");

    }

    
    private Color whichColor(Tuile tuile){
        switch(tuile.getIdentifiant()){
            case 0 :
                return Color.BLACK_COLOR;

            default :
                return Color.GREEN_COLOR;
        }
    }

}
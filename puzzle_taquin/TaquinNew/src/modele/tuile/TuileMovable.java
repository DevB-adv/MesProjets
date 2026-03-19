package tuile;

public class TuileMovable{
    private Tuile tuile;
    private int numeroAction;

    /**
        * Le constructeur permet d'instancier une TuileMovable
        * @param Tuile tuile correspond à un objet Tuile
        * @param int numeroAction correspond 
    */
    public TuileMovable(Tuile tuile, int numeroAction){
        this.tuile = tuile;
        this.numeroAction = numeroAction;
    }

    public Tuile getTuile(){
        return this.tuile;
    }

    public int getNumeroAction(){
        return this.numeroAction;
    }

    @Override
    public String toString(){
        if (this.numeroAction == 1){
            return "( " + this.tuile + " HAUT )" ;
        }
        if (this.numeroAction == 2){
            return "( " + this.tuile + " BAS )" ;
        }
        if (this.numeroAction == 3){
            return "( " + this.tuile + " GAUCHE )" ;
        }
        if (this.numeroAction == 4){
            return "( " + this.tuile + " DROITE )" ;
        }
        return "";
    }

}
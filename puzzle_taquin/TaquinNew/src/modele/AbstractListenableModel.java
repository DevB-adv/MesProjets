package modele;

import java.util.ArrayList;

public abstract class AbstractListenableModel{
    protected ArrayList<ModelListener> listeners;

    public AbstractListenableModel(){
        this.listeners = new ArrayList<ModelListener>();
    }

    public void addListener(ModelListener ecouteur){
        this.listeners.add(ecouteur);
    }

    public void removeListener(ModelListener ecouteur){
        this.listeners.remove(ecouteur);
    }

    protected void deplacementTuile(){
        for (ModelListener ecouteur : this.listeners){
            ecouteur.modelUpdated(this);
        }
    }

}
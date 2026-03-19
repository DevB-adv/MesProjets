package main;

import  taquin.Taquin;
import  tuile.Tuile;
import  terminal.Display;
import  gui.DisplayInterface;
import  java.util.Scanner;
import  terminal.ControleTerminal;
import  gui.ControleInterface;


public class Main{
    public static void main(String[] args){

        /*
            Choisissez une option :
                -> option 1 -> interface graphique;
                -> option 2 -> terminale
        */

        /*
            Objectif :
                -> pouvoir jouer au clavier
                -> faire programmation par contrat
                -> Faire les options ci-dessus
                -> Rapport

        */

        
        // Initialisation du jeu
        Taquin taquin = new Taquin(3,3);
        taquin.deranger();



        
        // Partie console
        /*
        Display affichageTaquin = new Display(taquin);
        affichageTaquin.modelUpdated(taquin);

        ControleTerminal control = new ControleTerminal(taquin);
        */


        // Partie interface graphique
        
        Display affichageTaquin = new Display(taquin);
        affichageTaquin.modelUpdated(taquin);

        DisplayInterface affichageTaquinInterface = new DisplayInterface(taquin);
        affichageTaquinInterface.modelUpdated(taquin);

        ControleInterface controlI = new ControleInterface(taquin);
        
    }
}

    

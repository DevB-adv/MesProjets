package gui;
import javax.swing.*;
import java.awt.*;
import modele.ModelListener;
import taquin.Taquin;
import gui.ControleInterface;

public class DisplayInterface extends JPanel implements ModelListener{
    private Taquin taquin;
    private JFrame frame;
    private ControleInterface CI;

    public DisplayInterface(Taquin newTaquin){
        super();
        this.taquin = newTaquin;
        this.taquin.addListener(this);

        this.CI = new ControleInterface(newTaquin);
        this.frame = this.CI.getJFrame();
    }

    @Override
    public void modelUpdated(Object source){
        this.frame.setVisible(true);    
    }

}

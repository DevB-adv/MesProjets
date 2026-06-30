package Clavier;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class keyboard implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.isActionKey())
		
		switch(e.getKeyCode()){
			case KeyEvent.VK_DOWN :
		System.out.println( 2);
		  break;
		  case KeyEvent.VK_LEFT :
		System.out.println( 6);
		  break;
		  case KeyEvent.VK_RIGHT :
		System.out.println( 4);
		  break;
		  case KeyEvent.VK_UP :
		System.out.println( 8);
		  break;
		   
		}
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}
	public static void main(String[] args)
	{
		//Setting the Frame and Labels
		Frame f = new Frame("Demo");
		f.setLayout(new FlowLayout());
		f.setSize(500, 500);
		Label l = new Label();
		l.setText("This is a demonstration");
		f.add(l);
		f.setVisible(true);
		
		//Creating and adding the key listener
		keyboard k = new keyboard();
		f.addKeyListener(k);
	}
}



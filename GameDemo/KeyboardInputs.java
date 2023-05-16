
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardInputs implements KeyListener
{
	private GameDemoJPanel gamePanel;
	
	public KeyboardInputs(GameDemoJPanel aGamePanel)
	{
		gamePanel = aGamePanel;
	}
	
	public void keyTyped(KeyEvent e)
	{
				
	}
			
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode()){
			case KeyEvent.VK_W:
				gamePanel.getGame().getPlayer().setAction(3);
				gamePanel.getGame().getPlayer().setUp(false);
				break;
			case KeyEvent.VK_A:
				gamePanel.getGame().getPlayer().setAction(3);
				gamePanel.getGame().getPlayer().setLeft(false);
				break;
			case KeyEvent.VK_S:gamePanel.getGame().getPlayer().setAction(3);
				gamePanel.getGame().getPlayer().setDown(false);
				break;
			case KeyEvent.VK_D:
				gamePanel.getGame().getPlayer().setAction(3);
				gamePanel.getGame().getPlayer().setRight(false);
				break;	
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode()){
			
			case KeyEvent.VK_W:
				gamePanel.getGame().getPlayer().addYPos(-5);
				gamePanel.getGame().getPlayer().setAction(4);
				gamePanel.getGame().getPlayer().setUp(true);
				break;
			case KeyEvent.VK_A:
				gamePanel.getGame().getPlayer().addXPos(-5);
				gamePanel.getGame().getPlayer().setAction(5);
				gamePanel.getGame().getPlayer().setLeft(true);
				break;
			case KeyEvent.VK_S:
				gamePanel.getGame().getPlayer().addYPos(5);
				gamePanel.getGame().getPlayer().setAction(1);
				gamePanel.getGame().getPlayer().setDown(true);
				break;
			case KeyEvent.VK_D:
				gamePanel.getGame().getPlayer().addXPos(5);
				gamePanel.getGame().getPlayer().setAction(5);
				gamePanel.getGame().getPlayer().setRight(true);
				break;	
		}
	}
}

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class KeyboardInputs implements KeyListener
{
	private GamePanel gamePanel;
	public int jCount=0;
	public boolean right=false,left=false,up=false, inAir = false;
	public KeyboardInputs(GamePanel aGamePanel)
	{
		gamePanel=aGamePanel;
	}
	public void keyTyped(KeyEvent e)
	{
				
	}
			
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_W)
		{
			up=false;
			inAir = true;
			gamePanel.getGame().jumpValue = jCount * 2;
			gamePanel.getGame().getPlayer().setAction(3);
			jCount=0;
			if(right && !left)
				gamePanel.getGame().right = true;
			if(!right && left)
				gamePanel.getGame().left = true;
		}
		if(key==KeyEvent.VK_D)
		{	
			gamePanel.getGame().getPlayer().setAction(3);
			right=false;
		}
		if(key==KeyEvent.VK_A)
		{
			gamePanel.getGame().getPlayer().setAction(3);
			left=false;
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key=e.getKeyCode();
		inAir = (!gamePanel.getGame().getPlayer().onPlatform(gamePanel.getGame().getPlatform()) && gamePanel.getGame().getPlayer().getY() < 400);
		if(inAir == false)
		{
			if(key==KeyEvent.VK_W)
			{
				up=true;
				jCount++;
				gamePanel.getGame().getPlayer().setAction(4);
				if(right&&!left)
					gamePanel.getGame().getPlayer().addX(100);
				if(left&&!right)
					gamePanel.getGame().getPlayer().addX(-100);
			}
			if(key==KeyEvent.VK_A)
			{
				gamePanel.getGame().getPlayer().setAction(5);
				if(!up)//
				{
					if(!gamePanel.getGame().getPlayer().onLeftSide(gamePanel.getGame().getPlatform()))
						gamePanel.getGame().getPlayer().addX(-5);
					else
						gamePanel.getGame().getPlayer().addX(gamePanel.getGame().getPlatform().getX2() + 15);
				}
				left = true;
			}
			if(key==KeyEvent.VK_D)
			{
				gamePanel.getGame().getPlayer().setAction(5);
				if(!up)
				{
					if(!gamePanel.getGame().getPlayer().onRightSide(gamePanel.getGame().getPlatform()))
						gamePanel.getGame().getPlayer().addX(5);
					else
						gamePanel.getGame().getPlayer().addX(- 5);
				}
				right = true;
			}
		}
	}
}
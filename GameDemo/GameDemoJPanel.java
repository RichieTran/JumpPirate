
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Object;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.lang.Throwable;
import java.lang.Exception;
import java.io.IOException;

import javax.swing.JPanel;


public class GameDemoJPanel extends JPanel
{
	private GameDemoGameClass game;
	public GameDemoJPanel(GameDemoGameClass aGame)
	{	
		game = aGame;
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
	}
	
	public void setPanelSize()
	{
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}	
		
	
	public void updateGame()
	{
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		game.render(g);
	
	}
	
	public GameDemoGameClass getGame()
	{
		return game;
	}
}
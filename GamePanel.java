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

public class GamePanel extends JPanel
{
	private GameClass game;
	public GamePanel(GameClass aGame)
	{
		game=aGame;
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
	}
	public void setPanelSize()
	{
		Dimension size = new Dimension(1920,1080);
		setPreferredSize(size);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		game.render(g);
	
	}
	
	public GameClass getGame()
	{
		return game;
	}
	
}
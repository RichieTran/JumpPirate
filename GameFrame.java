import javax.swing.JFrame;
import java.awt.Color;

public class GameFrame
{
	private JFrame jframe;
	public GameFrame(GamePanel gamePanel)
	{
		jframe = new JFrame();
		
		jframe.setSize(1080, 1920);
		jframe.add(gamePanel);
		jframe.setResizable(true);
		jframe.pack();
		jframe.setVisible(true);
	}
}

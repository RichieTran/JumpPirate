import javax.swing.JFrame;
import java.awt.Color;

public class GameDemoJFrame
{
	private JFrame jframe;
	public GameDemoJFrame(GameDemoJPanel gamePanel)
	{
		jframe = new JFrame();
		
		jframe.setSize(400, 400);
		jframe.add(gamePanel);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setVisible(true);
	}
}

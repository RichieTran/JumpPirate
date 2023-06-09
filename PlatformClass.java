import java.awt.Graphics;
import java.awt.Rectangle;
public class PlatformClass extends Entity
{
	public PlatformClass(int x, int y, int width, int height, String name)
    {
    	super(x, y, width, height, name);
    }

	public void render(Graphics g)
	{
		g.drawRect(x, y, width, height);
	}
	
}
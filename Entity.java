import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.*;
public abstract class Entity 
{	
	protected int x, y, width, height;
	protected String name;
	protected Rectangle hitbox;
	protected BufferedImage object;
	protected int borderx1, borderx2, bordery1, bordery2;
	public Entity(int aX, int aY, int aWidth, int aHeight, String aName)
	{
		x = aX;
		y = aY;
		width = aWidth;
		height = aHeight;
		borderx1 = x;
		borderx2 = x + width;
		bordery1 = y;
		bordery2 = y + height;
		name = aName;
		object = LoadSave.GetPlayerAtlas(name);
		hitbox = new Rectangle(x, y, width, height);
	}
	public Rectangle getRectangle()
	{
		return hitbox;
	}
	public boolean onPlatform(Entity plat)
    {
    	if(borderx2 >= plat.borderx1 && borderx1 <= plat.borderx2)
    	{
    		if((bordery2 >= plat.bordery1))
	    	{
	    		return true;
	    	}
	    	return false;
    	}
	   	else
	   	{
	   		return false;
	   	}
    }
    public boolean onRightSide(Entity plat) // right side of player touching left side plat
    {
    	if(bordery2 > plat.bordery1 && bordery1 < plat.bordery2) // if within plat y1 and y2 bounds
    	{
			if(borderx1 <= plat.borderx2 && borderx2 > plat.borderx1)
	    	{
				return true;
	    	}
	    	return false;
    	}
	   	else
	   	{
	   		return false;
	   	}
    }
    public boolean onLeftSide(Entity plat) // left side of player touching right side plat
    {
    	if(bordery2 > plat.bordery1 && bordery1 < plat.bordery2) // if within plat y1 and y2 bounds
    	{
    		if(borderx2 >= plat.borderx1 && borderx1 < plat.borderx2)
	    	{
	    		return false;
	    	}
	    	return false;
    	}
	   	else
	   	{
	   		return false;
	   	}
    }
    
    public int getWidth()
    {
    	return width;
    }
    
    public int getX2()
    {
    	return borderx2;
    }
}
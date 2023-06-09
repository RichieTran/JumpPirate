import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.*;

public class Player extends Entity
{
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 15;
	private int action = 3, limit;
	
	public Player(int aX, int aY, int aWidth, int aHeight, String name)
	{
		super(aX, aY, aWidth, aHeight, name);
		
		loadAnimations();
			
	}
	
	public void render(Graphics g)
	{
		g.drawImage(animations[action][aniIndex], (int)x, (int)y, width, height, null);
		g.drawRect(x, y, width, height);
	}
	
	public void addX(int value)
	{
		x += value;
		borderx1 += value;
		borderx2 += value;
	}
	
	public void addY(int value)
	{
		y += value;
		bordery1 += value;
		bordery2 += value;
	}
	
	public void update()
	{
		updateAnimationTick();
	}
	
	public void updateAnimationTick()
	{
		aniTick++;
		if(aniTick >= aniSpeed)
		{
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= limit)
				aniIndex = 0;
		}
	}
	
	public void setAction(int type)
	{
		action = type;
		if(action == 0) // Dead Ground
		{
			limit = 4; 
		}
		else if(action == 1) // Fall
		{
			limit = 1;
		}
		else if(action == 2) // Ground
		{
			limit = 2;
		}
		else if(action == 3)// Idle
		{
			limit = 5;
		}
		else if(action == 4) // Jump
		{
			limit = 3;
		}
		else // Run
		{
			limit = 6;
		}
	}
	
	public int getY()
	{
		return y;
	}
	
	private void loadAnimations()
	{
		animations = new BufferedImage[6][6];
		String fill, fillName;
		
		for(int j = 0; j < animations.length; j++)
		{
			if(j == 0)
			{
				fillName = "Dead_Ground";
				limit = 4;
			}
			else if(j == 1)
			{
				fillName = "Fall";
				limit = 1;
			}
			else if(j == 2)
			{
				fillName = "Ground";
				limit = 2;
			}
			else if(j == 3)
			{
				fillName = "Idle";
				limit = 5;
			}
			else if(j == 4)
			{
				fillName = "Jump";
				limit = 3;
			}
			else
			{
				fillName = "Run";
				limit = 6;
			}
			for(int i = 0; i < limit; i++)
			{
				fill = "res/" + fillName + "_0" + (i + 1) + ".PNG";
				animations[j][i] = LoadSave.GetPlayerAtlas(fill);
				name = fill;
 		
			}
		}
	}
	
}
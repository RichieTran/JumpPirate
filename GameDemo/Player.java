import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.lang.*;
//import Constants.PlayerConstants;

public class Player extends Entity
{
	private BufferedImage[][] animations;
	private int aniTick, aniIndex, aniSpeed = 30;
	private boolean moving = false;
	private int action, limit;
	private boolean left, right, up, down;
	private float playerSpeed = 10.0f;
	private int playerDir = -1;
	
	public Player(float aX, float aY)
	{
		super(aX, aY);
		
		updatePos();
		updateAnimationTick();
		setAnimation();
		
	}
	
	public void update()
	{
		updateAnimationTick();
	}
	
	public void render(Graphics g)
	{
		g.drawImage(animations[action][aniIndex], (int)x, (int)y, 256, 160, null);
	}
	
	public void addXPos(int aX)
	{
		x += aX;
	}

	public void addYPos(int aY)
	{
		y += aY;
	}
	
	public void setDirection(int direction)
	{
		playerDir = direction;
		moving = true;
	}
	
	public void setMoving(boolean aMoving)
	{
		moving = aMoving;
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
		if(action == 0)
		{
			limit = 4;
		}
		else if(action == 1)
		{
			limit = 1;
		}
		else if(action == 2)
		{
			limit = 2;
		}
		else if(action == 3)
		{
			limit = 5;
		}
		else if(action == 4)
		{
			limit = 3;
		}
		else
		{
			limit = 6;
		}
	}
	
	private void setAnimation()
	{
		if(moving)
			action = 5;
		else
			action = 3;
	}
	
	private void updatePos()
	{
		moving = false;
		
		if(left && !right)
		{
			x -= playerSpeed;
			moving = true;
		}
		else if(right && !left){
			x += playerSpeed;
			moving = true;
		}
		
		if(up && !down)
		{
			y -= playerSpeed;
			moving = true;
		}
		else if(down && !up){
			y += playerSpeed;
			moving = true;
		}
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
				InputStream is = getClass().getResourceAsStream(fill);
			
				try{
					animations[j][i] = ImageIO.read(is);
				} catch	(IOException e){
					e.printStackTrace();
					
				} finally {
					try{
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} 		
			}
		}
	}
	
	public boolean isLeft()
	{
		return left;
	}
	
	public void setLeft(boolean aLeft)
	{
		left = aLeft;
	}
	
	public boolean isRight()
	{
		return right;
	}
	
	public void setRight(boolean aRight)
	{
		right = aRight;
	}
	
	public boolean isUp()
	{
		return up;
	}
	
	public void setUp(boolean aUp)
	{
		up = aUp;
	}
	
	public boolean isDown()
	{
		return down;
	}
	
	public void setDown(boolean aDown)
	{
		down = aDown;
	}
	

	
}
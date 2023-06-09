import java.awt.Graphics;

public class GameClass implements Runnable
{
	private GameFrame gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
		
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.5f;
	public final static int TILES_IN_WIDTH = 26;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int)(TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	
	public int jumpValue = 0;
	
	public boolean left = false, right = false, inAir = false;
	
	public PlatformClass platforms;
	public  Player player;
	
	public GameClass()
	{
		initClasses();
		
		
		gamePanel = new GamePanel(this);
		gameWindow = new GameFrame(gamePanel);
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
		
		startGameLoop();
	}
	
	private void initClasses()
	{
		player = new Player(10, 10, 128, 80, "res/Idle_01.PNG");
		platforms = new PlatformClass(500, 200, 300, 400, "");
			
	}
	
	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update()
	{
		//	player.update();
		//levelManager.update();
	}
		
	
	public void render(Graphics g)
	{
		if(!player.onPlatform(platforms) && player.getY() < 400)
		{
			player.addY(2);
		}
		else
		{
			player.setAction(3);
		}
		if(inAir && player.onPlatform(platforms) || player.getY() == 400) // when falls back down stop moving left and right
		{
			inAir = false;
			left = false;
			right = false;
		}
		if(jumpValue > 0)
		{	
			player.addY(-1 * jumpValue);
			jumpValue--;
		}
		if(jumpValue == 0)
		{
			player.setAction(1);
			jumpValue = -1;
		}
		if(right && !left)
		{
			inAir = true;
			player.addX(4);
		}
		if(!right && left)
		{
			inAir = true;
			player.addX(-4);
		}	
		player.render(g);
		player.update();
		platforms.render(g);
	}
	
	public void run()
	{
		double timePerFrame = 1000000000.0 / FPS_SET; // in nano seconds
		double timePerUpdate = 1000000000.0 / UPS_SET;
		long previousTime = System.nanoTime();
		
		int updates = 0;
		int frames = 0;
		long lastCheck = System.currentTimeMillis(); 
			
		double deltaU = 0;
		double deltaF = 0;
		
		while(true){
			long currentTime = System.nanoTime();
			
			
			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;
			
			if(deltaU >= 1){
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1){
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			if(System.currentTimeMillis() - lastCheck >= 1000) // fps check
			{
				lastCheck = System.currentTimeMillis();
				//System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;	
				updates = 0;
			}	
		}
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public PlatformClass getPlatform()
	{
		return platforms;
	}
	
}
import java.awt.Graphics;

public class GameDemoGameClass implements Runnable
{
	
	private GameDemoJFrame gameWindow;
	private GameDemoJPanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	
	private Player player;
	
	public GameDemoGameClass()
	{
		initClasses();
		
		gamePanel = new GameDemoJPanel(this);
		gameWindow = new GameDemoJFrame(gamePanel);
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();
		
		startGameLoop();
		
	}
	
	private void initClasses()
	{
		player = new Player(0, 0);
	}
	
	private void startGameLoop()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update()
	{
		player.update();
	}
	
	public void render(Graphics g)
	{
		player.render(g);
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
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;	
				updates = 0;
			}	
		}
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	
}

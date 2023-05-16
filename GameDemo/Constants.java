public class Constants {
	public static class PlayerConstants{
		public static final int RUNNING = 5;
		public static final int IDLE = 3;
		public static final int JUMP = 4;
		public static final int FALL = 1;
		public static final int GROUND = 2;
		public static final int DEAD = 0;
		
		public static int GetSpriteAmount(int playerAction)
		{
			switch(playerAction)
			{
				case RUNNING:
					return 6;
				case IDLE:
					return 5;
				case JUMP:
					return 3;
				case FALL:
					return 1;
				case GROUND:
					return 2;
				case DEAD:
					return 4;
			}
		}

				
	}
}
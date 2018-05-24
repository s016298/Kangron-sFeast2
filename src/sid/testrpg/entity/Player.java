package sid.testrpg.entity;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import sid.testrpg.main.Main;
import sid.testrpg.tools.Loader;

public class Player extends Entity {
	
	public int x, y;
	
	public static int size = 16;
	public static int speed = 5;
	
	public static BufferedImage image = new Loader().loadResource("Player_WalkBack_Still", "png");
	
	public static EntityType type = EntityType.PLAYER;
	
	private boolean isMoving = false;
	
	private int movementCommand = 0;
	
	private int heading = 270;
	

	public Player(int x, int y) {
		super(x,y,size,speed,image,type);
	}
	
	public void init() {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics2D g) {
		
		if (x < 0)
			x = 0;
		else if (x > Main.width)
			x = Main.width;
		
		if (y < 0)
			y = 0;
		else if (y > Main.height)
			y = Main.height;
		
		if (isMoving)
		{
			switch (movementCommand)
			{
				case 1: y = y - speed;
					break;
				case 2: moveRight(g);
					break;
				case 3: y = y + speed;
					break;
				case 4: x = x - speed;
					break;
			}
		}
		else
		{
			image = new Loader().loadResource("Player_WalkBack_Still", "png");
			g.drawImage(image, x, y, size, size, null);
		}
	}
	
	public void stop(int command)
	{
		movementCommand = command;
		if (command >= 1 && command <= 4)
		{
			isMoving = false;
		}
	}
	
	public void move(int command)
	{
		movementCommand = command;
		if (command >= 1 && command <= 4)
		{
			isMoving = true;
		}
	}
	
	public void moveRight (Graphics2D g)
	{
		
		image = new Loader().loadResource("Player_WalkRight_Still", "png");
		g.drawImage(image,x,y,size,size,null);
		x++;
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		image = new Loader().loadResource("Player_WalkRight_Left", "png");
		g.drawImage(image,x,y,size,size,null);
		x++;
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		image = new Loader().loadResource("Player_WalkRight_Step", "png");
		g.drawImage(image,x,y,size,size,null);
	}
	
	

}

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
	
	public static BufferedImage image = new Loader().loadResource("Player_WalkFront_Still", "png");
	
	public static EntityType type = EntityType.PLAYER;
	
	private boolean isMoving = false;
	
	private int movementCommand = 0;
	
	private int heading = 270;
	
	private long tickCount = 0;
	

	public Player(int x, int y) {
		super(x,y,size,speed,image,type);
	}
	
	public void init() {
		
	}
	
	public void tick() {
		if (tickCount == 2147483646)
			tickCount = 0;
		
		tickCount++;
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
			g.drawImage(image, x, y, size, size, null);
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
		int imageId = 5;
		x++;
		if (tickCount % 5 == 0) {
			if (imageId > 3 && imageId <=5)
			{
				if (imageId == 4)
					imageId = 3;
				else
					imageId--;
				setImage(imageId);
			}
		}
	}
	
	public void setImage(int imageID) {
		switch (imageID) {
		case 0: image = new Loader().loadResource("Player_WalkBack_Still", "png");
			break;
		case 1: image = new Loader().loadResource("Player_WalkBack_Step", "png");
			break;
		case 2: image = new Loader().loadResource("Player_WalkBack_Left", "png");
			break;
		case 3: image = new Loader().loadResource("Player_WalkRight_Still", "png");
			break;
		case 4: image = new Loader().loadResource("Player_WalkRight_Step", "png");
			break;
		case 5: image = new Loader().loadResource("Player_WalkRight_Left", "png");
			break;	
		case 6: image = new Loader().loadResource("Player_WalkFront_Still", "png");
			break;
		case 7: image = new Loader().loadResource("Player_WalkFront_Step", "png");
			break;
		case 8: image = new Loader().loadResource("Player_WalkFront_Left", "png");
			break;	
		case 9: image = new Loader().loadResource("Player_WalkLeft_Still", "png");
			break;
		case 10: image = new Loader().loadResource("Player_WalkLeft_Step", "png");
			break;
		case 11: image = new Loader().loadResource("Player_WalkLeft_Left", "png");
			break;
		}
	}
	
	
	
	

}

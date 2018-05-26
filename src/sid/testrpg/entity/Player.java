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
	
	public static int size = 30;
	public static int speed = 5;
	
	public static BufferedImage image = new Loader().loadResource("Player_WalkFront_Still", "png");
	
	public static EntityType type = EntityType.PLAYER;
	
	private boolean isMoving = false;
	
	private int movementCommand = 0;
	
	private int heading = 270;
	
	private long tickCount = 0;
	
	private int animCnt = 0;			//stage of animation
	
	private int imageNum = 0;			//Image that should be used
	

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
				case 1: y = y - 1;
					break;
				case 2: x+=1;
					break;
				case 3: y = y + 1;
					break;
				case 4: x = x - 1;
					break;
			}
			
		}
		
		g.drawImage(image, x, y, size, size, null);
	}
	
	public void stop(int command)
	{
		animCnt=0;
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
		animate();
		animCnt++;
		
	}
	
	
	public void setImage(int imageID) {
		switch (imageID) {
		case 0: image = new Loader().loadResource("Player_WalkBack_Still", "png");
			break;
		case 1: image = new Loader().loadResource("Player_WalkBack_Left", "png");
			break;
		case 2: image = new Loader().loadResource("Player_WalkBack_Step", "png");
			break;
		case 3: image = new Loader().loadResource("Player_WalkRight_Still", "png");
			break;
		case 4: image = new Loader().loadResource("Player_WalkRight_Left", "png");
			break;	
		case 5: image = new Loader().loadResource("WalkRight_Step", "png");
			break;
		case 6: image = new Loader().loadResource("Player_WalkFront_Still", "png");
			break;
		case 7: image = new Loader().loadResource("Player_WalkFront_Left", "png");
			break;	
		case 8: image = new Loader().loadResource("Player_WalkFront_Step", "png");
			break;
		case 9: image = new Loader().loadResource("Player_WalkLeft_Still", "png");
			break;
		case 10: image = new Loader().loadResource("Player_WalkLeft_Left", "png");
			break;
		case 11: image = new Loader().loadResource("Player_WalkLeft_Step", "png");
			break;

		}
	}
	
	public void animate(){
		
		//cycle through animation images based on direction.
		if (movementCommand == 1){
			
			imageNum++;
			if(animCnt==0)imageNum = 0;
			if(imageNum>2)imageNum = 0;
		}
		if (movementCommand == 2){
			
			imageNum++;
			if(animCnt==0)imageNum = 3;
			if(imageNum>5)imageNum = 3;
		}
		if (movementCommand == 3){
			
			imageNum++;
			if(animCnt==0)imageNum = 6;
			if(imageNum>8)imageNum = 6;
		}
		if (movementCommand == 4){
			
			imageNum++;
			if(animCnt==0)imageNum = 9;
			if(imageNum>11)imageNum = 9;
		}
		
		setImage(imageNum);
	}
	
	
	
	

}

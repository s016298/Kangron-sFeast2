package sid.testrpg.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int x, y, size, speed;
	
	public BufferedImage image;
	
	public EntityType type;

	public Entity(int x, int y, int size, int speed, BufferedImage image, EntityType type) {
		
		this.x = x;
		this.y = y;
		this.size = size;
		this.speed = speed;
		this.image = image;
		this.type = type;
		
	}
	
	public void init() {
		
	}
	
	public void tick() {
		
	}
	
	public void render (Graphics2D g) {
		
	}
	
}

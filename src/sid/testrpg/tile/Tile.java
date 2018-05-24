package sid.testrpg.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static final int size = 16;
	public int x;
	public int y;
	public BufferedImage image;
	public boolean isSolid;
	public TileType tileType;
	
	public Tile(int x, int y, BufferedImage image, boolean isSolid, TileType tileType) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.isSolid = isSolid;
		this.tileType = tileType;
	}
	
	public void tick() {
		
	}
	
	public void render (Graphics2D g) {
		g.drawImage(image, x, y, size, size, null);
	}

}

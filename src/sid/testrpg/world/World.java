package sid.testrpg.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import sid.testrpg.main.Main;
import sid.testrpg.tile.DirtTile;
import sid.testrpg.tile.GrassTile;
import sid.testrpg.tile.Tile;

public class World {
	
	ArrayList<Tile> tiles = new ArrayList<Tile> ();
	int worldWidth;
	int worldHeight;

	public World(int worldWidth, int worldHeight) {
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		
		generateWorld();
	}
	
	public void generateWorld()
	{
		Random r = new Random();
		int index = 0;
		
		for (int x = 0; x < worldWidth; x++)
		{
			for (int y = 0; y < worldHeight; y++)
			{
				index = r.nextInt(4);
				
				if (index == 0)
					tiles.add(new DirtTile(x*Tile.size, y*Tile.size));
				else
					tiles.add(new GrassTile(x*Tile.size, y*Tile.size));
			}
		}
	}

	public void tick() {
		for(Tile t: tiles)
		{
			t.tick();
		}
	}
	
	public void render(Graphics2D g) {
		for (Tile t: tiles)
		{
			t.render(g);
		}
	}

}

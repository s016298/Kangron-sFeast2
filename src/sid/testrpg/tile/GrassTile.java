package sid.testrpg.tile;

import java.awt.image.BufferedImage;

import sid.testrpg.tools.Loader;

public class GrassTile extends Tile {

	public GrassTile(int x, int y) {
		super(x, y, new Loader().loadResource("grass", "png"), false, TileType.GRASS);
	}

}

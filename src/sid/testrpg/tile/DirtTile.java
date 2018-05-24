package sid.testrpg.tile;

import java.awt.image.BufferedImage;

import sid.testrpg.tools.Loader;

public class DirtTile extends Tile {

	public DirtTile(int x, int y) {
		super(x, y, new Loader().loadResource("dirt", "png"), false, TileType.DIRT);
	}

}

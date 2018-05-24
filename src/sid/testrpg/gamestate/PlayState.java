package sid.testrpg.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import sid.testrpg.main.Main;
import sid.testrpg.world.World;

public class PlayState extends GameState {
	
	World world;
	@Override
	public void init() {
		world = new World(Main.width/16,Main.height/16);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		
		world.tick();
		world.render(g);
	}

}

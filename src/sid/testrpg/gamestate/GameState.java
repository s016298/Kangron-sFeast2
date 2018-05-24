package sid.testrpg.gamestate;

import java.awt.Graphics2D;

public abstract class GameState {

	public abstract void init();
	public abstract void tick();
	public abstract void render(Graphics2D g);

}

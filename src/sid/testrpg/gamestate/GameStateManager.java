package sid.testrpg.gamestate;

import java.awt.Graphics2D;

public class GameStateManager {

	public GameState currGameState;
	
	public GameStateManager() {
		currGameState = new PlayState();
	}
	
	public void tick() {
		currGameState.tick();
	}
	
	public void init() {
		currGameState.init();
	}
	
	public void render(Graphics2D g) {
		currGameState.render(g);
	}
	
	public void switchState(GameState newState) {
		currGameState = newState;
		currGameState.init();
	}

}

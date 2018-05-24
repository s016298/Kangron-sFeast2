package sid.testrpg.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sid.testrpg.entity.Player;
import sid.testrpg.gamestate.GameStateManager;

@SuppressWarnings("serial")
public class Main extends JPanel implements KeyListener {
 
        static Main game;
        Graphics2D g2d;
        static JFrame frame;
       
        public static int width = 16*16*2, height = 16*16*2;
        public static String title = "GameTitle";
		
		public GameStateManager gsm = new GameStateManager();
		
		public Player player = new Player(width/2,height/2);
		
        public static void main(String[] args) {
                frame = new JFrame(title);
                game = new Main();
                frame.add(game);
                frame.setSize(width, height);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                game.init();
                game.run();
        }
       
        public void init() {
        	
        	this.setFocusable(true);					 // for keylistener
     		this.addKeyListener(this);
     		
        	gsm.init();
        	player.init();
        }
       
        public void run() {
                while (true) {
                        try {
                                tick();
                                repaint();
                                Thread.sleep(10);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
 
        public void tick() {
        	gsm.tick();
        	player.tick();
        }
 
        @Override
        public void paint(Graphics g) {
                super.paint(g);
                g2d = (Graphics2D) g;
 
                if (g2d != null)
                {
	                gsm.render(g2d);
	                player.render(g2d);
                }
        }
 
        public static JFrame getFrame() {
                return frame;
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
        	
    		switch(e.getKeyCode())
    		{
    			case KeyEvent.VK_UP: player.move(1);
    				break;
    			case KeyEvent.VK_RIGHT: player.move(2);
    				break;
    			case KeyEvent.VK_DOWN: player.move(3);
    				break;
    			case KeyEvent.VK_LEFT: player.move(4);
					break;
    		}
    		this.repaint();
    	}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode())
    		{
    			case KeyEvent.VK_UP: player.stop(1);
    				break;
    			case KeyEvent.VK_RIGHT: player.stop(2);
    				break;
    			case KeyEvent.VK_DOWN: player.stop(3);
    				break;
    			case KeyEvent.VK_LEFT: player.stop(4);
					break;
    		}
    		this.repaint();
			
		}
       
}
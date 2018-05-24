package states;

import main.ImageManager;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState {

	private Image background,logo;
	private MouseOverArea playButton,creditsButton,exitButton;
	
	@Override
	public void init(GameContainer gc, final StateBasedGame sbg) {
		logo = ImageManager.getImage(ImageManager.MENU_LOGO);
		background = ImageManager.getImage(ImageManager.MENU_BACKGROUND);
		
		playButton = new MouseOverArea(gc,ImageManager.getImage(ImageManager.MENU_BUTTON_PLAY),454,260);
		playButton.addListener(cmp -> sbg.enterState(2,new FadeOutTransition(), new FadeInTransition()));
		
		creditsButton = new MouseOverArea(gc,ImageManager.getImage(ImageManager.MENU_BUTTON_CREDITS),454,370);
		creditsButton.addListener(cmp -> sbg.enterState(5,new FadeOutTransition(), new FadeInTransition()));
		
		exitButton = new MouseOverArea(gc,ImageManager.getImage(ImageManager.MENU_BUTTON_EXIT),454,480);
		exitButton.addListener(cmp -> System.exit(0));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		background.draw(0,0);
		logo.draw(445,130);
		
		playButton.render(gc, g);
		creditsButton.render(gc, g);
		exitButton.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
	}

	@Override
	public int getID() {
		return 1;
	}
}

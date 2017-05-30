package exercise.actions;

import edu.udo.cs.swtsf.core.Bullet;
import edu.udo.cs.swtsf.core.player.BasicBullet;
import edu.udo.cs.swtsf.core.Entity;
import edu.udo.cs.swtsf.core.EntityBehaviorStrategy;
import edu.udo.cs.swtsf.core.Game;
import edu.udo.cs.swtsf.core.GameKey;
import edu.udo.cs.swtsf.core.Target;
import edu.udo.cs.swtsf.core.player.Player;
import edu.udo.cs.swtsf.view.GraphicalElementFactory;
import edu.udo.cs.swtsf.view.Sprite;
import exercise.starfighter.Explosion;

public class DualLaser implements EntityBehaviorStrategy{
	
	
	// The minimum time you have to wait in between two uses of the Rocket
	public static final int COOLDOWN = 200;
	// The time the Duallaser is moving before it explodes
	public static final int DLLASER_LIFE_TIME = 70;
	// The speed the Duallaser is moving at
	public static final int DLLASER_SPEED = 5;
	// The size of the Duallaser
	public static final int DLLASER_SIZE = 16;
	// The radius of the explosion. All monsters within this radius around the Rocket will be damaged when it explodes
	//public static final int EXPLOSION_RADIUS = 125;
	// The damage dealt to each monster in the explosion
	public static final int EXPLOSION_DAMAGE = 2;
	// The key to press to fire the Rocket
	public static final GameKey KEY = GameKey.F; //this will be changed to D since I use D to control the Spaceship
		
	// Counts down the time until the Rocket can be used again
	private int coolDownTimer = 200;
		
	// Called once in each update cycle. The host is typically the Player 
	// (or whatever Entity this behaviour was added to)
	public void act(Entity host) {
		// count down cooldown
		if (coolDownTimer > 0) {
			coolDownTimer--;
			return;
		}
		//Player player = (Player) host;
		
		Game game = host.getCurrentGame();
		// test for key press
		if (game.isPressed(KEY)) {
			// create Duallaser, add it to game and add cooldown
		    DlLaser duallaser = new DlLaser(host);
		    game.addEntity(duallaser);
			coolDownTimer = COOLDOWN;
		}
	}
	
	public static class DlLaser extends BasicBullet{
		
		public DlLaser(Entity sourceEntity){
			super(sourceEntity);
			setLifeTimer(DLLASER_LIFE_TIME);
			setSize(DLLASER_SIZE);
			setSpeedForward(DLLASER_SPEED);
			
			removeHitStrategy(BULLET_SELF_DESTRUCT_ON_HIT_STRAT);
			
			
			
		}
	}
	
	
	
	
	public static final GraphicalElementFactory DLLASER_SPRITE_FACTORY = 
			(viewManager, duallaser) -> {
				Sprite sprite = viewManager.newEntitySprite(duallaser);
				sprite.setImageCutout(0, 0, 32, 32);
				sprite.setImagePath("BulletBlue");
				return sprite;
			};

	
		
		
		

}

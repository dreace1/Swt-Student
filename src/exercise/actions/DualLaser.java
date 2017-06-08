package exercise.actions;


import edu.udo.cs.swtsf.core.player.BasicBullet;
import edu.udo.cs.swtsf.core.Entity;
import edu.udo.cs.swtsf.core.EntityBehaviorStrategy;
import edu.udo.cs.swtsf.core.Game;
import edu.udo.cs.swtsf.core.GameKey;
import edu.udo.cs.swtsf.view.GraphicalElementFactory;
import edu.udo.cs.swtsf.view.Sprite;

public class DualLaser implements EntityBehaviorStrategy{
	
	
	// The minimum time you have to wait in between two uses of the Duallaser
	public static final int COOLDOWN = 200;
	// The time the Duallaser is moving before it explodes
	public static final int DLLASER_LIFE_TIME = 70;
	// The speed the Duallaser is moving at
	public static final int DLLASER_SPEED = 5;
	// The size of the Duallaser
	public static final int DLLASER_SIZE = 16;
	// The key to press to fire the Duallaser
	public static final GameKey KEY = GameKey.F; //this will be changed to D since I use D to control the Spaceship
		
	private int coolDownTimer = 0;
		
	
	public void act(Entity host) {
		// count down cooldown
		if (coolDownTimer > 0) {
			coolDownTimer--;
			return;
		}
		
		Game game = host.getCurrentGame();
		// test for key press
		if (game.isPressed(KEY)) {
			// create Duallaser, add it to game and add cooldown
		    DlLaser duallaser = new DlLaser(host);
		    DlLaser2 duallaser2 = new DlLaser2(host); 		    
		    game.addEntity(duallaser);
		    game.addEntity(duallaser2);
		   
		    
		    
			coolDownTimer = COOLDOWN;
		}
	}
	
	public static class DlLaser extends BasicBullet{ //added image DlLaser.png which looks like BulletBlue.png
		
		public DlLaser(Entity sourceEntity){
			super(sourceEntity);
			setLifeTimer(DLLASER_LIFE_TIME);
			setSize(DLLASER_SIZE);
			setSpeedForward(DLLASER_SPEED);
			addHitStrategy(BULLET_SELF_DESTRUCT_ON_HIT_STRAT);
			
			setSpeedDirectional(sourceEntity.getRotation()-15, DLLASER_SPEED);

		}
	}
	
	public static class DlLaser2 extends BasicBullet{ //added image DlLaser2.png which looks like BulletGreen.png
		
		public DlLaser2(Entity sourceEntity){
			super(sourceEntity);
			setLifeTimer(DLLASER_LIFE_TIME);
			setSize(DLLASER_SIZE);
			setSpeedForward(DLLASER_SPEED);
			addHitStrategy(BULLET_SELF_DESTRUCT_ON_HIT_STRAT);
			
			setSpeedDirectional(sourceEntity.getRotation()+15, DLLASER_SPEED);		    

			
				
		}
	}
	
	
	
	
	
	public static final GraphicalElementFactory DLLASER_SPRITE_FACTORY = 
			(viewManager, duallaser) -> {
				Sprite sprite = viewManager.newEntitySprite(duallaser);
				sprite.setImageCutout(0, 0, 32, 32);
				sprite.setImagePath("BulletBlue");
				return sprite;
			};
			
	public static final GraphicalElementFactory DLLASER_SPRITE_FACTORY2 = 
			(viewManager, duallaser2) -> {
				Sprite sprite = viewManager.newEntitySprite(duallaser2);
				sprite.setImageCutout(0, 0, 32, 32);
				sprite.setImagePath("BulletGreen");
				return sprite;
			};

	
		
		
		

}

package exercise.monsters;

import edu.udo.cs.swtsf.core.Target;
import edu.udo.cs.swtsf.core.player.Player;

public class MonsterSpeedDown extends AbstractMonster{
	
	public MonsterSpeedDown(){
		
		setMaxHitpoints(10); //Life
		setHitpoints(getMaxHitpoints());
		
		damagePerHit = 2;
		maxSpeed = 5.5;
		acceleration = 0.5;
		
	    addDefaultStrategies();

	}
	
	public void onPlayerHitTarget(Player player, Target target) {
		
		maxSpeed -= 0.5;
		
	}


}

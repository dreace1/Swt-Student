package exercise.monsters;

import edu.udo.cs.swtsf.core.Target;



//for test purposes

public class MonsterSpeedDown extends AbstractMonster{
	
	public MonsterSpeedDown(){
		
		setMaxHitpoints(10); //Life
		setHitpoints(getMaxHitpoints());
		
		damagePerHit = 2;
		maxSpeed = 5.5;
		acceleration = 0.5;
		
	    addDefaultStrategies();

	}
	
	//public void onPlayerHitTarget(Player player, Target target) {
		
		//acceleration = -0.5;
		
	//}
	
	public void onAfterHitpointsChanged(Target target, int delta) {
		
		maxSpeed -= 0.5;
		
		
		
	}

	
	

}

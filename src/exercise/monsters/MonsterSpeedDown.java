package exercise.monsters;

import edu.udo.cs.swtsf.core.Target;
import edu.udo.cs.swtsf.core.TargetObserver;




public class MonsterSpeedDown extends AbstractMonster{
	
	public MonsterSpeedDown(){
		
		setMaxHitpoints(10); //Life
		setHitpoints(getMaxHitpoints());
		
		damagePerHit = 2;
		maxSpeed = 5.5;
		acceleration = 0.5;
		
	    addDefaultStrategies();
	    addTargetObserver(new TargetObserver() { 
	    	public void onAfterHitpointsChanged(Target target, int delta) {
	    		
	    		maxSpeed -= 0.5;
	    	}
	    	
		});

	}
}

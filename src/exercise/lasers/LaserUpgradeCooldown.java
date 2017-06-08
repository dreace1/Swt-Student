package exercise.lasers;

import edu.udo.cs.swtsf.core.player.Laser;
import edu.udo.cs.swtsf.core.player.LaserUpgrade;

public class LaserUpgradeCooldown implements LaserUpgrade {
	
private Laser decorated = null;
	
	public void setDecorated(Laser laser) {
		decorated = laser;
	}
	
	public Laser getDecorated() {
		return decorated;
	}
	
	public int getCooldownTime() {
		
		if(getDecorated().getCooldownTime() >= 1 ){
			return getDecorated().getCooldownTime() - 1;
		}
		else
		{
			return getDecorated().getCooldownTime();
		}
		
	}
	


}

package exercise.pickups;

import edu.udo.cs.swtsf.core.PickUp;
import edu.udo.cs.swtsf.core.player.Player;
import exercise.lasers.LaserUpgradeDamage;

//exercise 43
import exercise.lasers.LaserUpgradeCooldown; 

public class PickUpDamage extends PickUp {
	
	public void onPickUp(Player player) {
		//player.addLaserUpgrade(new LaserUpgradeDamage());
		//exercise 43
		player.addLaserUpgrade(new LaserUpgradeCooldown()); 
		super.onPickUp(player);
	}
	
}
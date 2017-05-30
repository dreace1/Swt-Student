package exercise.hud;

import edu.udo.cs.swtsf.core.Game;
import edu.udo.cs.swtsf.core.PickUp;
import edu.udo.cs.swtsf.core.player.Player;
import edu.udo.cs.swtsf.core.player.PlayerObserver;
import edu.udo.cs.swtsf.view.HudElement;
import edu.udo.cs.swtsf.view.HudElementOrientation;
import edu.udo.cs.swtsf.view.ViewManager;

public class PickUpCounter extends HudElement implements PlayerObserver {
	
	private final Class<? extends PickUp> pickUpCls; 
	private final Class<? extends PickUp> pickUpCls2;
	private final Class<? extends PickUp> pickUpCls3;

	
	
	public PickUpCounter(Class<? extends PickUp> pickUpClass, Class<? extends PickUp> pickUpClass2, Class<? extends PickUp> pickUpClass3)
	{
		super(HudElementOrientation.TOP, "HUD/Counter", 0, 0, 32, 32);
		pickUpCls = pickUpClass;
		pickUpCls2 = pickUpClass;
		pickUpCls3 = pickUpClass;

	}
	
	public void onPickUpCountChanged (Player player, Class<? extends PickUp> pickUpClass, int value)
	{
		     
			int count = player.getPickUpCount(pickUpCls) + player.getPickUpCount(pickUpCls2) + player.getPickUpCount(pickUpCls3);
			setText(Integer.toString(count));
		
	
	}
	
	
	
	protected void afterAdded(ViewManager view, Game game) { //sets the counter to zero at the start
		onPickUpCountChanged(game.getPlayer(), pickUpCls, 0);
	}
	
	

}

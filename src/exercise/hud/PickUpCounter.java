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
		pickUpCls2 = pickUpClass2;
		pickUpCls3 = pickUpClass3;

	}
	
	public void onPickUpCountChanged (Player player, Class<? extends PickUp> pickUpClass, int value)
	{
		if(value > 0)
		{
			int count = player.getPickUpCount(pickUpCls) + player.getPickUpCount(pickUpCls2) + player.getPickUpCount(pickUpCls3)-1; //-1 because the counter has already one PickUpRocket at the start of the Game
			setText(Integer.toString(count));
		}
		else if(value == 0) //sets the counter to zero at the start
		{
			setText(Integer.toString(0));
		}
		
		
	}
	
	
	
	protected void afterAdded(ViewManager view, Game game) {
		onPickUpCountChanged(game.getPlayer(), pickUpCls, 0);
		onPickUpCountChanged(game.getPlayer(), pickUpCls2, 0);
		onPickUpCountChanged(game.getPlayer(), pickUpCls3, 0);
	}
	
	

}

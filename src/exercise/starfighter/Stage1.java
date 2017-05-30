package exercise.starfighter;

import edu.udo.cs.swtsf.view.RgbColor;
import exercise.monsters.MonsterEasy;
import exercise.monsters.SpawnMonsters;
//Task 39
import exercise.monsters.MonsterSpeedDown;

public class Stage1 extends SpawnMonsters {
	
	public Stage1() {
		setMaxMonstersAtOnce(10); // was 5
		setMonsterSpawnInterval(40);
		setSpawnDistanceToPlayer(300, 900);
		setTotalMonsterCount(50);
		setMonsterFactory((g) -> new MonsterEasy());
		
		//Task 39
		setMonsterFactory((e) -> new MonsterSpeedDown());
		
		setReactionAfterAllMonstersAreDead(g -> {
			g.addScript(new Stage2());
			g.addEntity(new TextMessage("Good Job!", RgbColor.GREEN, 2));
		});
	}
	
}
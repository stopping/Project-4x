package entities.units;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import control.Player;
import entities.GameObjectType;
import entities.stats.BaseStatsEnum;
import entities.stats.UnitStats;
import entities.units.Unit;

public class TestUnitsAttack {

	@Test
	public void testatk(){
		Player p = new Player("Xu", 111);
		Player q = new Player("Graham", 222);
		Unit a1=new Unit(new UUID(0,0), p.getId(), BaseStatsEnum.ARCHER, new UnitStats(2, 4, 0, 0, 20f, 3, 1.0f, null), GameObjectType.UNIT, UnitType.ARCHER, 1, 1);
		Unit a2=new Unit(new UUID(0,0), q.getId(), BaseStatsEnum.ARCHER, new UnitStats(2, 4, 0, 0, 20f, 3, 1.0f, null), GameObjectType.UNIT, UnitType.ARCHER, 2, 3);
		Unit m1=new Unit(new UUID(0,0), q.getId(), BaseStatsEnum.MEDIC, new UnitStats(-2, 5, 2, 0, 10f, 2, 2.0f, null), GameObjectType.UNIT, UnitType.MEDIC, 2, 2);
		a1.attack(a2);
		System.out.println(a2.getHealth());
		m1.attack(a2);
		System.out.println(a2.getHealth());
		m1.attack(m1);
		m1.attack(a1);
	}
}

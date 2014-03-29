package control;

import java.util.UUID;

import entities.GameObjectType;
import entities.buildings.Barracks;
import entities.buildings.Building;
import entities.buildings.Castle;
import entities.gameboard.GameBoard;
import entities.stats.BaseStatsEnum;
import entities.units.Unit;
import entities.units.pawns.Archer;
import entities.units.pawns.Battering_Ram;
import entities.units.pawns.Cannon;
import entities.units.pawns.Catapult;
import entities.units.pawns.Dragoon;
import entities.units.pawns.Infantry;
import entities.units.pawns.Knight;
import entities.units.pawns.Medic;
import entities.units.pawns.Militia;
import entities.units.pawns.Ranged_Calvary;
import entities.units.pawns.Rifleman;
import entities.units.pawns.Skirmisher;
import entities.units.pawns.Transport;

public class Factory {

	private static synchronized UUID getId() {
		return UUID.randomUUID();
	}

	public static Unit buildUnit(Player p, int playerId, UnitType unitType,
			float xco, float yco) {

		UUID newId = getId();
		Unit result = null;
		switch (unitType) {

		case MILITIA:
			result = new Militia(newId, playerId, BaseStatsEnum.MILITIA,
					BaseStatsEnum.MILITIA.getStats(), GameObjectType.UNIT,
					UnitType.MILITIA, xco, yco);
			break;
		case INFANTRY:
			result = new Infantry(newId, playerId, BaseStatsEnum.INFANTRY,
					BaseStatsEnum.INFANTRY.getStats(), GameObjectType.UNIT,
					UnitType.INFANTRY, xco, yco);
			break;
		case ARCHER:
			result = new Archer(newId, playerId, BaseStatsEnum.ARCHER,
					BaseStatsEnum.ARCHER.getStats(), GameObjectType.UNIT,
					UnitType.ARCHER, xco, yco);
			break;
		case SKIRMISHER:
			result = new Skirmisher(newId, playerId, BaseStatsEnum.SKIRMISHER,
					BaseStatsEnum.SKIRMISHER.getStats(), GameObjectType.UNIT,
					UnitType.SKIRMISHER, xco, yco);
			break;
		case KNIGHT:
			result = new Knight(newId, playerId, BaseStatsEnum.KNIGHT,
					BaseStatsEnum.KNIGHT.getStats(), GameObjectType.UNIT,
					UnitType.KNIGHT, xco, yco);
			break;
		case RANGED_CALVARY:
			result = new Ranged_Calvary(newId, playerId,
					BaseStatsEnum.RANGED_CALVARY,
					BaseStatsEnum.RANGED_CALVARY.getStats(),
					GameObjectType.UNIT, UnitType.RANGED_CALVARY, xco, yco);
			break;
		case TRANSPORT:
			result = new Transport(newId, playerId, BaseStatsEnum.TRANSPORT,
					BaseStatsEnum.TRANSPORT.getStats(), GameObjectType.UNIT,
					UnitType.TRANSPORT, xco, yco);
			break;
		case CATAPULT:
			result = new Catapult(newId, playerId, BaseStatsEnum.CATAPULT,
					BaseStatsEnum.CATAPULT.getStats(), GameObjectType.UNIT,
					UnitType.CATAPULT, xco, yco);
			break;
		case BATTERING_RAM:
			result = new Battering_Ram(newId, playerId,
					BaseStatsEnum.BATTERING_RAM,
					BaseStatsEnum.BATTERING_RAM.getStats(),
					GameObjectType.UNIT, UnitType.BATTERING_RAM, xco, yco);
			break;
		case RIFLEMAN:
			result = new Rifleman(newId, playerId, BaseStatsEnum.RIFLEMAN,
					BaseStatsEnum.RIFLEMAN.getStats(), GameObjectType.UNIT,
					UnitType.RIFLEMAN, xco, yco);
			break;
		case DRAGOON:
			result = new Dragoon(newId, playerId, BaseStatsEnum.DRAGOON,
					BaseStatsEnum.DRAGOON.getStats(), GameObjectType.UNIT,
					UnitType.DRAGOON, xco, yco);
			break;

		case CANNON:
			result = new Cannon(newId, playerId, BaseStatsEnum.CANNON,
					BaseStatsEnum.CANNON.getStats(), GameObjectType.UNIT,
					UnitType.CANNON, xco, yco);
			break;

		case MEDIC:
			result = new Medic(newId, playerId, BaseStatsEnum.MEDIC,
					BaseStatsEnum.MEDIC.getStats(), GameObjectType.UNIT,
					UnitType.MEDIC, xco, yco);
			break;

		case TRADE_CART:
			result = new Infantry(newId, playerId, BaseStatsEnum.TRADE_CART,
					BaseStatsEnum.TRADE_CART.getStats(), GameObjectType.UNIT,
					UnitType.TRADE_CART, xco, yco);
			break;

		default:
			break;
		// result = new Infantry(p, 1, 1, uniqueid);
		}
		p.getGameObjects().addUnit(result);
		return result;

	}

	// Do not remove Player p arg. It is needed to maintain the collection of
	// buildings for the player

	public static Building buildBuilding(Player p, int playerId,
			BuildingType buildingType, float xco, float yco, GameBoard gb) {
		UUID newId = getId();
		Building result = null;

		// if the tile is not occupied
		if (!gb.getTileAt((int) xco, (int) yco).isOccupiedByBuilding()) {

			switch (buildingType) {

			case CASTLE:
				result = new Castle(newId, playerId, BaseStatsEnum.CASTLE,
						BaseStatsEnum.CASTLE.getStats(),
						GameObjectType.BUILDING, BuildingType.CASTLE, xco, yco,
						4, 4, 500, 10);
				break;

			case BARRACKS:
				result = new Barracks(newId, playerId, BaseStatsEnum.BARRACKS,
						BaseStatsEnum.BARRACKS.getStats(),
						GameObjectType.BUILDING, BuildingType.BARRACKS, xco,
						yco, 2, 4);
				break;
			case BANK:
				result = new Barracks(newId, playerId, BaseStatsEnum.BANK,
						BaseStatsEnum.BANK.getStats(), GameObjectType.BUILDING,
						BuildingType.BANK, xco, yco, 2, 2);
				break;

			case TOWN_HALL:
				result = new Barracks(newId, playerId, BaseStatsEnum.TOWN_HALL,
						BaseStatsEnum.TOWN_HALL.getStats(),
						GameObjectType.BUILDING, BuildingType.TOWN_HALL, xco,
						yco, 4, 4);
				break;
			default:

				// result = new Barracks(p, 1, 1, uniqueid);
			}

			// if the building is successfully placed on the map (within range)
			// add it to the players object list
			if (gb.placeBuildingAt(result, (int) xco, (int) yco)) {
				p.getGameObjects().addBuilding(result);
				System.out.println("Building placement success ");
			} else
				System.out
						.println("Building placement error;  Out of range, or overlap");

		} else
			System.out
					.println("Building placement error;  Out of range, or overlap");

		return result;

	}

}

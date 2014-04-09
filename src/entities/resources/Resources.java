package entities.resources;

import java.io.Serializable;

/**
 * Resources
 * @author NRTop
 * This class keeps track of how many resource the player currently has, 
 * also allows resource buildings to generate a resource. 
 */
public class Resources implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5238901473592664603L;
	// Tentative resource types suggested during planning
	public int Gold;
	private int Wood;
	private int Food;
	private int Stone;
	private int ResearchPts;

	/**
	 * Resources 
	 * Creates a new resource object. allows player to keep track of their resources
	 * as well as a building to generate resources. 
	 * @param startingGold - initial gold amount for a building/player/transaction 
	 * @param startingWood - initial wood amount for a building/player/transaction 
	 * @param startingFood - initial food amount for a building/player/transaction
	 * @param startingStone - initial stone amount for a building/player/transaction
	 * @param startingRPts - initial research points amount for a building/player/transaction
	 */
	public Resources(int startingGold, int startingWood, int startingFood, int startingStone, 
			int startingRPts) {
		Gold = startingGold;
		Stone = startingStone;
		Wood = startingWood;
		Food = startingFood;
		Stone = 0;
		ResearchPts = startingRPts;
	}

	/**
	 * spend() 
	 * allows player t spend resources in a transaction, if they have enough. 
	 * this version allows the specification of resource amounts by integer 
	 * 
	 * @param gold - amount of gold to be spent
	 * @param wood - amount of wood to be spent
	 * @param food - amount of food to be spent
	 * @param stone - amount of stone to be spent 
	 * @param rp - amount of research points to be spent 
	 * @return true if the transaction was successful (had enough resources to spend)
	 */
	public boolean spend(int gold, int wood, int food, int stone, int rp) {
		if (!have_enough_resources(gold, wood, food, stone,  rp))
			return false;
		Gold  -= gold;
		Wood  -= wood;
		Food  -= food;
		Stone -= stone;
		ResearchPts -= rp;
		return true;
	}

	/**
	 * spend() 
	 * allows player t spend resources in a transaction, if they have enough. 
	 * this version allows the specification of resource amounts by a Resources object 
	 * 
	 * @param r - the resources object, specifying how much to speend. 
	 * @return true if transaction was successful (have enough resources) 
	 */
	public boolean spend(Resources r) {
		if (!have_enough_resources(r.Gold, r.Food, r.Wood, r.Stone, r.ResearchPts))
			return false;
		Gold  -= r.Gold;
		Wood  -= r.Wood;
		Food  -= r.Food;
		Stone -= r.Stone;
		ResearchPts -= r.ResearchPts;
		return true;
	}

	/**
	 * receive(): 
	 * allows player to receive resources (generally from a resource building) 
	 * adding new amounts to their current values. 
	 * 
	 * @param gold - amount of gold to add
	 * @param wood - amount of wood to add
	 * @param food - amount of food to add
	 * @param stone - amount of stone to add
	 * @param rp - amount of research points to add
	 */
	public void receive(int gold, int wood, int food, int stone, int rp) {
		Gold  += gold;
		Wood  += wood;
		Food  += food;
		Stone += stone; 
		ResearchPts += rp;
	}

	/**
	 * receive(): 
	 * allows player to receive resources (generally from a resource building) 
	 * adding new amounts to their current values. 
	 * 
	 * @param r - the resources object, specifying how much to add. 
	 */
	public void receive(Resources r)
	{
		Gold += r.Gold;
		Wood += r.Wood;
		Food += r.Food;
		Stone += r.Stone;
		ResearchPts += r.ResearchPts; 
	}
	
	
	/**
	 * scale()
	 * returns a new resource object which is the multiple of resource amounts in r and this 
	 * resources object. Allows to generate more resources from a base amount.
	 * 
	 * @param r - amount to scale this resources object by
	 * @return new resources 
	 */
	public Resources scale(Resources r) {
		return new Resources(Gold * r.Gold, Wood * r.Wood, Food * r.Food, Stone * r.Stone,
				ResearchPts * r.ResearchPts);
	}

	/**
	 * scale()
	 * returns a new resource object which is the multiple of resource amounts in r and this 
	 * resources object. Allows to generate more resources from a base amount.
	 * 
	 * @param gold - amount of gold to scale by 
	 * @param wood - amount of wood to scale by 
	 * @param food - amount of food to scale by 
	 * @param stone - amount of stone to scale by 
	 * @param rp - amount of research points to scale by 
	 * 
	 * @return returns a new Resoruces object 
	 */
	public Resources scale(int gold, int wood, int food, int stone, int rp)
	{
		return new Resources(Gold * gold, Wood * wood, Food * food, Stone * stone, ResearchPts * rp);
	}
	
	/**
	 * have_enough_resources() 
	 * checks if player has enough resources based on current amount compared to that of parameters
	 * @param gold - amount of gold to check against
	 * @param wood - amount of wood to check against
	 * @param food - amount of food to check against
	 * @param stone - amount of stone to check against 
	 * @param rp - amount of research points to check against 
	 * 
	 * @return true if this resources object has enough 
	 */
	public boolean have_enough_resources(int gold, int wood, int food, int stone, int rp) {
		if (gold > Gold || wood > Wood || food > Food || stone > Stone ||  rp > ResearchPts)
			return false;
		return true;
	}

	/**
	 * toString(): 
	 * returns a string representation of this Resources object
	 */
	public String toString() {
		return "Gold: " + Gold + "\nWood: " + Wood + "\nFood: " + Food + "\nStone: " + Stone 
				+ "\nResearch: " + ResearchPts;
	}
}

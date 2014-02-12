package com.fourx;
import com.fourx.research.TechnologyTree;
import com.fourx.research.Upgrades;
import com.fourx.resources.Resources;

public class Player {

	private final String name;
	public TechnologyTree techTree;
	public Upgrades upgrades;
	private Resources resources;

	
//	Bare constructor
	public Player(){
		this("");
	}
	
	public Player(String alias) {
		this(alias, 0, 0, 0, 0);
	}
	
	public Player(String alias, int startingGold, int startingWood, int startingFood, int startingRPts){
		name = alias;
		
		resources = new Resources(startingGold, startingWood, startingFood, startingRPts);
		upgrades = new Upgrades();
		techTree = new TechnologyTree(this);
	}
	
	public String getAlias(){
		return name;
	}
	
	public boolean research(String name) {
		return techTree.research(name);
	}
	
	public void researchStep(int time) {
		techTree.researchStep(time);
	}
	
	public Resources getResources() { return resources; }

	public int getTimeRemaining(String tech) {
		return techTree.getTimeRemaining(tech);
	}

	public int getResearchLevel(String tech) {
		return techTree.getResearchLevel(tech);
	}
}

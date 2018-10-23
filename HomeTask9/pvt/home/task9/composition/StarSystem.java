package pvt.home.task9.composition;

import java.util.ArrayList;

public class StarSystem {
	
	private String galaxyName;
	private ArrayList<Star> stars;
	private int starsCount;
	
	public StarSystem(String galaxyName) {
		this.galaxyName = galaxyName;
		this.starsCount = 0;
		this.stars = new ArrayList<>();
		System.out.println("Congrats!!! Galaxy created!");
	}
	
	public void createStar(String name, long mass, String type) {
		stars.add(new Star(name, mass, type));
		starsCount++;
		System.out.println("Congrats!!! New star has been created!");
	}
	
	public Star getStarByName(String name) {
		return stars.stream().filter(star -> name.equals(star.getName())).findAny().orElse(null);
	}
	
	@Override
	public String toString() {
		return "StarSystem " + galaxyName + ", starsCount=" + starsCount;
	}
}

package pvt.home.task9.composition;

public class Main {

	public static void main(String[] args) {
		
		StarSystem milkyWay = new StarSystem("Milky Way");
		
		milkyWay.createStar("Sun", 85632134, "G2V");
		Star sun = milkyWay.getStarByName("Sun");
		sun.createPlanet("Earth", true, true, true, 1);
		sun.createPlanet("Mars", false, false, false, 2);
		
		milkyWay.createStar("Sirius", 2651, "White dwarf");
		Star sirius = milkyWay.getStarByName("Sirius");
		
		System.out.println(milkyWay.toString());
		System.out.println(sun.toString());
		System.out.println(sirius.toString());
		System.out.println(sun.getPlanetByName("Earth").toString());
		System.out.println(sun.getPlanetByName("Mars").toString());		
	}
}

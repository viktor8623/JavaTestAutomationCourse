package pvt.home.task9;

public class Main {

	public static void main(String[] args) {
		
		Star star = new Star("Sirius B", 154665, "white dwarf", 465454);
		star.printDetails();
		star.printMassOfObject();
		
		Planet planet = new Planet("Venus", 54656);
		planet.printDetails();
		planet.printMassOfObject();
		
		Earth earth = new Earth(true, true);
		earth.printDetails();
		earth.printMassOfObject();
	}
}

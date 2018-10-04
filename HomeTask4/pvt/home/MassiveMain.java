package pvt.home;

public class MassiveMain {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		
		Massive mas = new Massive();
		mas.printMassiveAsLine(array);
		mas.printReverseMassiveAsLine(array);
		System.out.println(mas.getSumOfElements(array));
		array = mas.multiptyBy3(array);
		mas.printMassiveAsLine(array);
		mas.printReverseMassiveAsLine(array);
	}
}

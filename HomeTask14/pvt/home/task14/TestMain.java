package pvt.home.task14;

public class TestMain {

	public static void main(String[] args) {
		Massive mas = new Massive();
		mas.getNumber(5);
		mas.setSize();
		mas.setString(3, "JD");
		mas.arrOfStrings = new String[1];
		mas.setString(3, "JD");
		mas.setName();
		mas.createArrOfNumbers();
		mas.createArrOfStrings();
		mas.skipFinally();
	}
}
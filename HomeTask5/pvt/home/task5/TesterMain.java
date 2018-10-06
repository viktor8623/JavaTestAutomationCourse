package pvt.home.task5;

public class TesterMain {

	public static void main(String[] args) {

		Tester tester1 = new Tester();
		Tester tester2 = new Tester("Viktor");
		Tester tester3 = new Tester("Viktor", "Yenjchak");
		Tester tester4 = new Tester("Viktor", "Yenjchak", 1);
		Tester tester5 = new Tester("Viktor", "Yenjchak", 1, "Upper Intermediate");
		Tester tester6 = new Tester("Viktor", "Yenjchak", 1, "Upper Intermediate", 500);
		
		tester6.doWork();
		tester6.doWork(15);
		tester6.doWork("2791 Double Charges");
		tester6.doWork(15, 2);
		
		System.out.println();
		
		Tester.printDetails(tester1);
		Tester.printDetails(tester2);
		Tester.printDetails(tester3);
		Tester.printDetails(tester4);
		Tester.printDetails(tester5);
		Tester.printDetails(tester6);
	}

}

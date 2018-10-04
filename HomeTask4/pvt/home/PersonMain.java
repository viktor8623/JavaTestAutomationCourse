package pvt.home;

public class PersonMain {

	public static void main(String[] args) {
		Person person = new Person();
		
		person.setName("Viktor");
		person.setSurname("Yenjchak");
		person.setAge(25);
		person.setPhone("+375 29 781-03-81");
		
		person.printAllInformation();
		person.printName();
		System.out.println("Is he adult? " + person.isAdult());
		
	}

}

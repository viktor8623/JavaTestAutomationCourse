package pvt.home;

public class Person {
	private String name;
	private String surname;
	private int age;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void printAllInformation() {
		System.out.println(name + " " + surname + " " + age + " " + phone);
	}
	
	public void printName() {
		System.out.println(name + " " + surname);
	}
	
	public boolean isAdult() {
		boolean isAdult;
		if (age > 18) {
			isAdult = true;
		} else {
			isAdult = false;
		}
		return isAdult;
	}
	

}

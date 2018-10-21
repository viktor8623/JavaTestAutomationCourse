package pvt.home.task9;

public class Earth extends Planet {

	private boolean isInhabitable;
	private boolean hasAtmosphere;
	
	public Earth(boolean isInhabitable, boolean hasAtmosphere) {
		setInhabitable(isInhabitable);
		setHasAtmosphere(hasAtmosphere);
	}
	
	public void method1() {
		
	}
	
	public void method2() {
		
	}
	
	@Override
	public void printDetails() {
		System.out.println(toString());;
	}

	@Override
	public void printMassOfObject() {
		System.out.println("Earth's mass = 11651656");
	}
	
	public boolean isInhabitable() {
		return isInhabitable;
	}
	
	public void setInhabitable(boolean isInhabitable) {
		this.isInhabitable = true;
	}
	
	public boolean isHasAtmosphere() {
		return hasAtmosphere;
	}
	
	public void setHasAtmosphere(boolean hasAtmosphere) {
		this.hasAtmosphere = true;
	}

	@Override
	public int hashCode() {
		final int prime = 7;
		int result = super.hashCode();
		result = prime * result + (hasAtmosphere ? 1231 : 1237);
		result = prime * result + (isInhabitable ? 1231 : 1237);
		return result;
	}

	@Override
	public String toString() {
		return "This is Earth.";
	}
}

package pvt.home.task13;

public class Button implements Comparable<Button> {
	private String name;
	private String action;
	
	public Button(String name, String action) {
		this.name = name;
		this.action = action;
	}

	@Override
	public int compareTo(Button o) {
		int result = name.compareTo(o.name);
		if (result == 0) {
			return action.compareTo(o.action);
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Button)) {
			return false;
		}
		Button other = (Button) obj;
		if (action == null) {
			if (other.action != null) {
				return false;
			}
		} else if (!action.equals(other.action)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Button: " + name + ", action = " + action;
	}
}

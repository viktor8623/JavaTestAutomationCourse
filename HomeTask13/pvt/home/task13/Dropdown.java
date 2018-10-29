package pvt.home.task13;

import java.util.List;
import java.util.stream.Collectors;


public class Dropdown {
	private List<String> options;
	private boolean isSelected;
	private String name;
	
	public Dropdown(List<String> options, boolean isSelected, String name) {
		this.options = options;
		this.isSelected = isSelected;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isSelected ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		Dropdown other = (Dropdown) obj;
		if (isSelected != other.isSelected) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (options == null) {
			if (other.options != null) {
				return false;
			}
		} else if (!options.equals(other.options)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String optionsList = options.stream().collect(Collectors.joining("/"));
		return "Dropdown options=" + optionsList + ", isSelected=" + isSelected + ", name=" + name;
	}
}

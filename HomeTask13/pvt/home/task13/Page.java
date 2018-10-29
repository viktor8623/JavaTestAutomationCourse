package pvt.home.task13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Page {

	private ArrayList<Button> buttons;
	private LinkedList<Field> fields;
	private HashSet<Label> labels;
	private HashMap<Integer, Dropdown> dropdowns;
	private float id;
	private String title;
	
	public Page() {
		this.buttons = new ArrayList<Button>();
		this.fields = new LinkedList<Field>();
		this.labels = new HashSet<Label>();
		this.dropdowns = new HashMap<Integer, Dropdown>();
	}
		
	public Page(ArrayList<Button> buttons, LinkedList<Field> fields, HashSet<Label> labels,
			HashMap<Integer, Dropdown> dropdowns, float id, String title) {
		this.buttons = buttons;
		this.fields = fields;
		this.labels = labels;
		this.dropdowns = dropdowns;
		this.id = id;
		this.title = title;
	}
	
	public void addButton(Button button) {
		buttons.add(button);
	}
	
	public void removeButton(Button button) {
		buttons.remove(button);
	}
	
	public void removeAllButtons(Button button) {
		while(buttons.contains(button)) {
			buttons.remove(button);
		}
	}
	
	public void setButton(Button oldButton, Button newButton) {
		buttons.set(buttons.indexOf(oldButton), newButton);
	}
	
	public void setAllButtons(Button oldButton, Button newButton) {
		while(buttons.contains(oldButton)) {
			buttons.set(buttons.indexOf(oldButton), newButton);
		}
	}
	
	public void printButtons() {
		buttons.stream().forEach(System.out::println);
		System.out.println();
	}

	public ArrayList<Button> getBubbleSortedListOfButtons() {
		ArrayList<Button> result = buttons;
		int length = result.size();
		Button temp = null;
		
		for(int i = 0; i < length; i++) {
			for(int j = 1; j < (length - i); j++) {
				
				if(result.get(j - 1).compareTo(result.get(j)) > 0) {
					temp = result.get(j);
					result.set(j, result.get(j + 1) );
					result.set(j + 1, temp);
				}
			}
		}
		return result;
	}
	
	
	public void addField(Field field) {
		fields.add(field);
	}
	
	public void removeField(Field field) {
		fields.remove(field);
	}
	
	public void removeAllFields(Field field) {
		while(fields.contains(field)) {
			fields.remove(field);
		}
	}
	
	public void setField(Field oldField, Field newField) {
		fields.set(fields.indexOf(oldField), newField);
	}
	
	public void setAllFields(Field oldField, Field newField) {
		while(fields.contains(oldField)) {
			fields.set(fields.indexOf(oldField), newField);
		}
	}
	
	public void printFields() {
		fields.stream().forEach(System.out::println);
		System.out.println();
	}
	
	public void addLabel(Label label) {
		labels.add(label);
	}
	
	public void removeLabel(Label label) {
		labels.remove(label);
	}
	
	public void setLabel(Label oldLabel, Label newLabel) {
		labels.remove(oldLabel);
		labels.add(newLabel);
	}
	
	public void printLabels() {
		labels.stream().forEach(System.out::println);
		System.out.println();
	}
	
	public void addDropdown(Integer index, Dropdown dropdown) {
		dropdowns.put(index, dropdown);
	}
	
	public void removeDropdownByKey(Integer index) {
		dropdowns.remove(index);
	}
	
	public void setDropdown(Integer index, Dropdown newDropdown) {
		dropdowns.put(index, newDropdown);
	}
	
	public void printDropdowns() {
		dropdowns.entrySet().stream().forEach(entry -> System.out.println
				("Key " + entry.getKey() + "; Value " + entry.getValue()));
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Page [buttons=" + buttons + ", fields=" + fields + ", labes=" + labels + ", dropdowns=" + dropdowns
				+ ", id=" + id + ", title=" + title + "]";
	}
}

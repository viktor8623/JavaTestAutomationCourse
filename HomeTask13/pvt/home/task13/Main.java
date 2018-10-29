package pvt.home.task13;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Page page = new Page();
		Button b1 = new Button("Submit question", "/action_page1.aspx");
		Button b2 = new Button("Submit offer", "/action_page2.aspx");
		Button b3 = new Button("Submit offer", "/action_page3.aspx");
		Button b4 = new Button("Send", "/action_page4.aspx");
		page.addButton(b1);
		page.addButton(b2);
		page.addButton(b3);
		page.addButton(b2);		
		page.printButtons();
		page.removeButton(b1);
		page.removeAllButtons(b2);
		page.printButtons();
		page.setButton(b3, b4);
		page.printButtons();
		Field f1 = new Field(1, "Name");
		Field f2 = new Field(2, "Surname");
		Field f3 = new Field(3, "Age");
		Field f4 = new Field(4, "Phone");
		page.addField(f1);
		page.addField(f2);
		page.addField(f3);
		page.addField(f3);
		page.printFields();
		page.removeField(f1);
		page.removeAllFields(f3);
		page.printFields();
		page.setField(f2, f4);
		page.printFields();
		Label l1 = new Label("Username");
		Label l2 = new Label("Password");
		Label l3 = new Label("Example");
		page.addLabel(l1);
		page.addLabel(l2);
		page.addLabel(l1);
		page.addLabel(l3);
		page.printLabels();
		page.removeLabel(l1);
		page.printLabels();
		page.setLabel(new Label("Example"), new Label("Sample"));
		page.printLabels();
		Dropdown d1 = new Dropdown(new ArrayList<String>(Arrays.asList("A","B","C")), false, null);
		Dropdown d2 = new Dropdown(new ArrayList<String>(Arrays.asList("10","20","30")), true, "30");
		Dropdown d3 = new Dropdown(new ArrayList<String>(Arrays.asList("False","True")), true, "False");
		page.addDropdown(1, d1);
		page.addDropdown(2, d2);
		page.addDropdown(3, d3);
		page.printDropdowns();
		page.removeDropdownByKey(1);
		page.printDropdowns();
		page.setDropdown(33, new Dropdown(new ArrayList<String>(Arrays.asList("Belarus", "USA")), false, null));
		page.printDropdowns();
		System.out.println(page.getBubbleSortedListOfButtons());
	}
}

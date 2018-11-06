package pvt.home.task16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Array {
	public int size;
	public int[] arr;
	
	public Array(int size) {
		this.size = verifySize(size);
		this.arr = new int[size];
	}
	
	public int getSumOfAllElements() {
		return Arrays.stream(arr).sum();
	}
	
	public int getAvarageValue() {
		return getSumOfAllElements() / size;
	}
	
	public int getMaxValue() {
		return Arrays.stream(arr).max().getAsInt();
	}
	
	public int getMinValue() {
		return Arrays.stream(arr).min().getAsInt();
	}
	
	public boolean isEmpty() {
		try {
			int size = arr.length;
			return false;
		} catch (NullPointerException e) {
			return true;
		}
	}
	
	public int verifySize(int size) {
		if (size > 0) {
			this.size = size;
			return size;
		} else {
			throw new IllegalArgumentException("Only positive numbers & no letters please!");
		}
	}
	
	public boolean initArray(int...values) {
		if (values.length == size) {
			for(int i = 0; i < size; i++) {
				arr[i] = values[i];
			}
			return true;
		} else {
			return false;
		}
	}
	
	public int addMembers(int...values) {
		int size = arr.length + values.length;
		int[] initial = arr;
		arr = new int[size];
		int index = 0;
		while(index < initial.length) {
			arr[index] = initial[index];
			index++;
		}
		for(int i = 0; i < values.length; i++) {
			arr[index] = values[i];
			index++;
		}
		return arr.length;
	}
	
	public List<Integer> getReversedList() {
		return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}
		 
	public Set<Integer> getUniqueNumbers() {
		return Arrays.stream(arr).boxed().collect(Collectors.toSet());
	}	
}

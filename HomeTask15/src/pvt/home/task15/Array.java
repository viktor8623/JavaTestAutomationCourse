package pvt.home.task15;

import java.util.Arrays;

public class Array {
	public int size;
	public int[] arr;
	
	public Array(int size) {
		this.size = verifySize(size);
		this.arr = new int[size];
	}
	
	public int getAvarageValue() {
		int sumAllElements = Arrays.stream(arr).sum();
		int result = sumAllElements / size;
		return result;
	}
	
	public int getMaxValue() {
		return Arrays.stream(arr).max().getAsInt();
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
}

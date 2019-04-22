package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem statement : 
 * 
 * Given an input length, string array and burst length as input, output should be an array which is shrunk input 
 * array such that the sequentially repeating elements more than or equal to the burst length should be removed. 
 * This has to be repeated till the array cannot be shrunk any further.
Input:
8
a
b
c
c
c
d
e
e
3

Output:
a
b
d
e

 * 
 * 
 */
public class ArrayBurstProblem {

	public static void main(String[] args) {
		List<String> input = Arrays.asList(new String[] { "a", "b", "a", "a", "a", "b", "b", "c", "d" });
		System.out.println(shrinkArray(input, 3));
	}

	static List<String> shrinkArray(List<String> input, int burstValue) {
		List<String> l = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			if (input.size() - i > burstValue
					&& checkNextValues(input.get(i), input.subList(i + 1, i + burstValue - 1))) {
				l.addAll(input.subList(0, i));
				l.addAll(input.subList(i + burstValue, input.size()));
				input = shrinkArray(l, burstValue);
			}
		}
		return input;
	}

	static boolean checkNextValues(String in, List<String> subList) {
		for (String subValue : subList) {
			if (!subValue.equals(in)) {
				return false;
			}
		}
		return true;
	}

}

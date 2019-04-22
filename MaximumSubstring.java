package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Problem statement : A substring is defined as any contagious group of one or more characters of String. 
 * For example the unique substrings of ‘baca’ are {‘b’,’ba’, ‘bad’, ‘baca’, ‘a’, ‘ac’, ‘aca’, ‘c’, ‘ca’]. 
 * This list in alphabetical order is [‘a’, ‘ac’, ‘aca’,‘b’,’ba’, ‘bad’, ‘baca’,‘c’, ‘ca’]. 
 * In this case the maximum substring alphabetically is ‘ca’. 
 * Given a String, determine the maximum substring
 * 
 *
 * 
 */
public class MaximumSubstring {

	public static void main(String[] args) {
		String[] input = { "b", "h", "c", "a", "g" };
		System.out.println(maxSubstring(input));
	}

	static String maxSubstring(String[] arr) {
		List<String> inList = Arrays.asList(arr);
		List<String> subStrings = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			addtoList(subStrings, inList.subList(i, inList.size()));
		}
		Collections.sort(subStrings);
		return subStrings.get(subStrings.size() - 1);
	}

	private static void addtoList(List<String> subStrings, List<String> inList) {
		String str = "";
		for (int i = 0; i < inList.size(); i++) {
			str = str + inList.get(i);
			subStrings.add(str);
		}

	}

}

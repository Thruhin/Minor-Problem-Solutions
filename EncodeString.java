package com.example.demo;

import java.util.HashMap;
import java.util.Map;


/*
 * 
 * Problem Statement: Encode a given string by collapsing consecutive instances of single character into two pieces of information: 
 * the number of instances and the character note that even characters should be run length encoded. 
 * If the string is empty, return an empty string. Your implementation should work on all alphanumeric characters 

Sample inout: GGGGGrrrrrrrrSSSSSSsssss
Sample output : 5G8r6S5s
 * 
 * 
 */
public class EncodeString {

	public static void main(String[] args) {
		System.out.println(inputStrr("abbreRRRRa"));
	}

	static String inputStrr(String inputString) {
		String result = "";
		if (inputString == null || inputString.length() == 0) {
			return result;
		}
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < inputString.length(); i++) {
			int count = 0;
			String str = Character.toString(inputString.charAt(i));

			if (map.containsKey(str)) {
				count = map.get(str);
			} /*
				 * else{ map.put(str, 1); if( i+1 < inputString.length() &&
				 * !str.equals(Character.toString(inputString.charAt(i + 1)))){ continue; } }
				 */
			// System.out.println(i+1 < inputString.length() &&
			// str.equals(Character.toString(inputString.charAt(i + 1))));
			if (i + 1 < inputString.length() && str.equals(Character.toString(inputString.charAt(i + 1)))) {

				map.put(str, count + 1);
				// System.out.print(str + map.get(str));
			}

			if ((i + 1 < inputString.length() && !str.equals(Character.toString(inputString.charAt(i + 1))))
					|| i >= inputString.length() - 1) {
				int c = map.get(str) == null ? 1 : map.get(str) + 1;
				result = result + c + str;
				map.remove(str);
			}

		}
		return result;
	}

}

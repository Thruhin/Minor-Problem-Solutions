package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem Statement: Input is an array of Integers and a target value. Determine the number of Distinct pairs of elements in the array that sum up the target value. 
 * Two pairs (a,b) and (c,d) are considered distinct if and only if the values in sorted order do not match. I,e (1,9) and (9,1) are indistinct but (1,9) and (9,2) are distinct.
 * For the given array [1,2,3,6,7,8,9,1] and a target value of 10, the seven pairs (1,9), (2,8), (3,7), (8,2), (9,1) and (1,9) all sum up to 10 
 * and there are only three distinct pairs: (1,9), (2,8) and (3,7)
 * 
 * 
 */
public class DistinctPairs {

	public static void main(String[] args) {
		
		 Integer[] numbers = {6,4,1,8,4,7,2,3,5,5,6,7,8,8, 4,9,1};
		 System.out.println(distinctPairs(numbers, 10));
	}
	
	static Set<Tuple> distinctPairs(Integer[] numbers, int count) {
		Set<Tuple> result = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for(Integer num: numbers) {
			list.add(num);
		}
		Collections.sort(list);
		for(int i=0;i<list.size()-1;i++) {
			int num = list.get(i);
			for(int j=i+1;j<list.size();j++) {
				int temp = list.get(j);
				if(num + temp == count) {
					Tuple t = new Tuple(num, temp);
					result.add(t);
				}
			}
			
		}
		return  result;
	}
	
	static class Tuple implements Comparable<Tuple>{
		
		Tuple(int x, int y){
			this.x = x;
			this.y = y;
		}
		int x;
		int y;
		@Override
		public String toString() {
			return "("+x+ ", "+y +")";
		}
		
		@Override
		public int hashCode() {
			return x + y;
		}
		
		@Override
		public boolean equals(Object obj) {
			Tuple tup = (Tuple) obj;
			return (this.x == tup.x && this.y == tup.y) ||  (this.x == tup.y && this.y == tup.x);
		}

		@Override
		public int compareTo(Tuple o) {
			return 0;
		}
		
		
	}

}

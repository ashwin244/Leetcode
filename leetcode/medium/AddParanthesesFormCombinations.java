package leetcode.medium;

/*
Given a string of numbers and operators, return all possible results from 
computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
 */

import java.util.*;

public class AddParanthesesFormCombinations {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {

				String str1 = input.substring(0, i);
				String str2 = input.substring(i + 1);

				List<Integer> set1 = diffWaysToCompute(str1);
				List<Integer> set2 = diffWaysToCompute(str2);

				for (Integer i1 : set1) {
					for (Integer i2 : set2) {
						int c = 0;
						switch (input.charAt(i)) {
						case '+':
							c = i1 + i2;
							break;
						case '-':
							c = i1 - i2;
							break;
						case '*':
							c = i1 * i2;
							break;
						}

						res.add(c);
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}
}

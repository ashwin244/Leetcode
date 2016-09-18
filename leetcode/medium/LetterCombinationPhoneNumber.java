package leetcode.medium;

/*
Given a digit string, return all possible letter combinations that the number could 
represent.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

	
 */
import java.util.*;

public class LetterCombinationPhoneNumber {
	String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		LinkedList<String> list = new LinkedList<>();

		if (digits == null || digits.length() == 0) {
			return list;
		}

		list.add("");

		for (int i = 0; i < digits.length(); i++) {
			int c = Character.getNumericValue(digits.charAt(i));
			while (list.peek().length() == i) {
				String pop = list.remove();
				for (char x : mapping[c].toCharArray()) {
					list.add(pop + x);
				}
			}
		}

		return list;
	}
}

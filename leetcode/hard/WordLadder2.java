package leetcode.hard;

import java.util.*;

class WordNode {
	int numSteps;
	String word;
	WordNode pre;

	public WordNode(int numSteps, String word, WordNode pre) {
		this.numSteps = numSteps;
		this.word = word;
		this.pre = pre;
	}

}

public class WordLadder2 {

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		wordList.add(endWord);
		List<List<String>> result = new ArrayList<>();
		Set<String> unvisited = new HashSet<>();
		Set<String> visited = new HashSet<>();

		unvisited.addAll(wordList);
		Queue<WordNode> q = new LinkedList<>();
		q.add(new WordNode(0, beginWord, null));
		int minSteps = 0;
		int prevNumSteps = 0;
		while (!q.isEmpty()) {
			WordNode node = q.remove();
			String word = node.word;
			int numOfSteps = node.numSteps;

			if (word.equals(endWord)) {
				if (minSteps == 0) {
					minSteps = numOfSteps;
				}

				if ((minSteps == numOfSteps) && minSteps != 0) {
					List<String> t = new ArrayList<>();
					t.add(node.word);
					while (node.pre != null) {
						t.add(0, node.pre.word);
						node = node.pre;
					}
					result.add(t);
					continue;
				}
			}

			if (prevNumSteps < numOfSteps) {
				unvisited.removeAll(visited);
			}
			prevNumSteps = numOfSteps;

			char[] arr = word.toCharArray();

			for (int i = 0; i < arr.length; i++) {
				char temp = arr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (arr[i] != c) {
						arr[i] = c;
					}
					String newWord = new String(arr);
					if (unvisited.contains(newWord)) {
						q.add(new WordNode(numOfSteps + 1, newWord, node));
						visited.add(newWord);
					}
					arr[i] = temp;
				}
			}
		}
		return result;
	}
}

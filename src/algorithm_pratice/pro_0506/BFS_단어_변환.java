package algorithm_pratice.pro_0506;

import java.util.*;

public class BFS_단어_변환 {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String[] begins = { "hit", "hit" };
		String[] targets = { "cog", "cog" };
		String[][] words = { { "hot", "dot", "dog", "lot", "log", "cog" }, { "hot", "dot", "dog", "lot", "log" } };
		
		for(int i =0;i<words.length;i++) {
			int res = sol.solution(begins[i], targets[i], words[i]);
			System.out.println(res);
		}

	}

}

class Solution {

	static class Node {
		String word;
		int edge;

		Node(String word, int edge) {
			this.word = word;
			this.edge = edge;
		}

	}

	public int solution(String begin, String target, String[] words) {
		boolean hasTarget = false;
		for (String w : words) {
			if (w.equals(target)) {
				hasTarget = true;
				break;
			}
		}
		if (!hasTarget)
			return 0;

		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[words.length];

		queue.add(new Node(begin, 0));

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			if (curr.word.equals(target)) {
				return curr.edge;
			}

			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && canConvert(curr.word, words[i])) {
					visited[i] = true;
					queue.add(new Node(words[i], curr.edge + 1));
				}
			}
		}
		return 0;
	}

	private boolean canConvert(String str1, String str2) {
		int diffCount = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				diffCount++;
			}
		}
		return diffCount == 1;
	}
}
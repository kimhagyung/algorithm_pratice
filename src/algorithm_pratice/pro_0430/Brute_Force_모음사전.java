package algorithm_pratice.pro_0430;

import java.util.stream.Stream;

public class Brute_Force_모음사전 {

	public static void main(String[] args) {
		
		String[] word = {"AAAAE", "AAAE", "I"	, "EIO",};

		Solution sol = new Solution();
		for(String w:word) {
			System.out.println(sol.solution(w));
		}
	}

}

class Solution {

	int count ;
	int answer ;
	String[] vowels = { "A", "E", "I", "O", "U" };

	public int solution(String word) {
		count = 0;
		answer = 0;
		dfs("", word);

		return answer;
	}

	public void dfs(String curWord, String word) {

		if (curWord.equals(word)) {
			answer = count; 
		}

		if (!(curWord.length() == 5)) {
			for (int i = 0; i < vowels.length; i++) {
				count++;
				dfs(curWord + vowels[i], word);
			}
		}
	}
}
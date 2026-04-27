package algorithm_pratice.pro_0424;

import java.util.*;

public class Brute_Force_소수찾기 {
	public static void main(String[] args) {
		String[] answers = { "17", "011" };
		Solution2 sol = new Solution2();

		for (String a : answers) {
			int re = sol.solution(a);
			System.out.println("정답 :" + re);
		}
	}
}

class Solution2 {
	public int solution(String numbers) {
		HashSet<Integer> set = new HashSet<>();

		// 모든 조합의 숫자를 생성
		makeCombinations("", numbers, set);

		int count = 0;

		// 소수 판별
		for (int number : set) {
			if (isPrime(number)) {
				count++;
			}
		}
		return count;
	}

	private void makeCombinations(String prefix, String str, HashSet<Integer> set) {
		if (!prefix.equals("")) {
			set.add(Integer.parseInt(prefix));
		}

		for (int i = 0; i < str.length(); i++) {
			makeCombinations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), set);
		}
	}

	private boolean isPrime(int n) {
		if (n <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
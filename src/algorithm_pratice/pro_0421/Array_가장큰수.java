package algorithm_pratice.pro_0421;

import java.util.Arrays;

public class Array_가장큰수 {

	public static void main(String[] args) {
		Solution2 sol2 = new Solution2();
		int[][] numbers = { { 6, 10, 2 }, { 3, 30, 34, 5, 9 } };

		for (int[] n : numbers) {
			System.out.println(sol2.solution(n));
		}

	}
}

class Solution2 {
	public String solution(int[] numbers) {
		String[] num = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			num[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(num, (a, b) -> (b + a).compareTo(a + b));
		
		// 예외 처리: 모든 숫자가 0인 경우
        if (num[0].equals("0")) {
            return "0";
        }
        
		//정렬된 문자열 하나로 이어붙이기 
		StringBuilder answer = new StringBuilder();
		for(String s: num) {
			answer.append(s);
		}
		
		return answer.toString();
	}
}
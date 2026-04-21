package algorithm_pratice.pro_0421;

import java.util.Arrays;

public class Array_K번째수 {

	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] result = sol.solution(array, commands);
		System.out.println(Arrays.toString(result));
	}

}

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0]; 
			int end = commands[i][1];
			int slice = commands[i][2];
			
			int[] newArr = Arrays.copyOfRange(array, start-1 , end);
			Arrays.sort(newArr);  
			answer[i] = newArr[slice -1]; 
		}
		return answer;
	}
}
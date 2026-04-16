package algorithm_pratice.pro_0416;

import java.util.*;

public class Stack_Queue_같은숫자는싫어 {

	public static void main(String[] args) {

		int[] arr1 = {1,1,3,3,0,1,1};
		int[] arr2 = {4,4,4,3,3};
		Solution sol = new Solution();
		
		int[] result1 = sol.solution(arr1);
		int[] result2 = sol.solution(arr2);
		
		Arrays.stream(result1).forEach(r1 -> System.out.println(r1));
		Arrays.stream(result2).forEach(r2 -> System.out.println(r2));
		
	}

}

class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int lastNum = -1;
        
        for(int i =0; i< arr.length; i++){
             if(arr[i] != lastNum){
                 list.add(arr[i]);
                 lastNum = arr[i];
             }
         }
        
        int[] answer = new int[list.size()];
        for(int j =0;j<answer.length;j++){
            answer[j] = list.get(j);
        } 

        return answer;
    }
}
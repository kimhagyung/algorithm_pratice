package algorithm_pratice.pro_0423;
import java.util.*;

public class Arrays_H_ndex {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		Solution sol = new Solution();
		System.out.println(sol.solution(citations));
	}
}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int num = citations.length;
        for(int i =0;i<citations.length;i++){
            if(citations[i] >=  num ){
                answer =num;
                break;
            }
            num --;        
        }
         
        return answer;
    }
}
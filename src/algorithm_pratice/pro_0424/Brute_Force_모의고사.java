package algorithm_pratice.pro_0424;
import java.util.*;

public class Brute_Force_모의고사 {
	public static void main(String[] args) {
		int[][] answers= {{1,2,3,4,5},{1,3,2,4,2}};
		Solution sol = new Solution();
		
		for(int[] a: answers) {
			int[] re = sol.solution(a);
			System.out.println("정답 :" + Arrays.toString(re));
		}
	}
}

class Solution {
    public int[] solution(int[] answers) {
        int[] mathGiveUp1 ={1, 2, 3, 4, 5};
        int[] mathGiveUp2 ={2, 1, 2, 3, 2, 4, 2, 5};
        int[] mathGiveUp3 ={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int math1Cor = 0;
        int math2Cor = 0;
        int math3Cor = 0;
        for(int i =0;i<answers.length;i++){
            if(mathGiveUp1[i%mathGiveUp1.length] == answers[i]) math1Cor ++;
            if(mathGiveUp2[i%mathGiveUp2.length] == answers[i]) math2Cor ++;
            if(mathGiveUp3[i%mathGiveUp3.length] == answers[i]) math3Cor ++;
        }
        
       int maxScore = Math.max(math1Cor,Math.max(math2Cor,math3Cor)); 
        List<Integer> result = new ArrayList<>();
        if(maxScore == math1Cor) result.add(1);
        if(maxScore == math2Cor) result.add(2);
        if(maxScore == math3Cor) result.add(3);
        
        int[] answer = new int[result.size()];
         
        for(int i =0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
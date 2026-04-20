package algorithm_pratice.pro_0416;

import java.util.*;

public class Stack_Queue_기능개발 {

	public static void main(String[] args) {
		 int[][] progresses = {{93, 30, 55},{95, 90, 99, 99, 80, 99}};
		 int[][] speeds = {{1, 30, 5},{1, 1, 1, 1, 1, 1}};
		 
		 Solution2 sol = new Solution2();
		  
		 for(int i=0; i<progresses.length;i++) {
			 System.out.println(Arrays.toString(sol.solution(progresses[i], speeds[i])));
		 } 
	}

}

class Solution2 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        // 1. 각 완료일수 
        for(int i =0; i< progresses.length; i++){
           int days = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
           list.add(days); 
        }   

        // 2. 각 날짜별 별 배포 개수
        List<Integer> workCntList = new ArrayList<>();
        int maxDay = list.get(0); 
    	int cnt = 0;
        for(int i = 0;i<list.size();i++){
            if(list.get(i) <=  maxDay){ 
                cnt ++ ;
            }else {
                workCntList.add(cnt);	
                cnt = 1;
                maxDay = list.get(i); 
            }
        }
        workCntList.add(cnt);  // 마지막 cnt 
        int[] answer = new int[workCntList.size()];
        for(int j =0;j<answer.length;j++){
            answer[j] = workCntList.get(j);
        } 
        
        return answer;
    }
}
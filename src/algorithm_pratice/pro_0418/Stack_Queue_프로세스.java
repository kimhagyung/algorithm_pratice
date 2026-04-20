package algorithm_pratice.pro_0418;

import java.util.*;
public class Stack_Queue_프로세스 {

	public static void main(String[] args) {
		 Solution sol = new Solution();
		 int[][] priorities = {{2, 1, 3, 2},{1, 1, 9, 1, 1, 1}};
		 int[] location = {2,0};
		 
		 for(int i =0; i< priorities.length;i++) {
			 int result = sol.solution(priorities[i], location[i]);
			 System.out.println("return: "+result); 
		 }
	} 

}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>(); // (인덱스, 우선순위)를 저장하는 큐
        int answer = 0; 

        // 1. 큐에 (인덱스, 우선순위) 형태로 저장
        for(int i =0;i<priorities.length;i++){
            queue.add(new int[]{i, priorities[i]});  
        }
        
        // 2. 큐가 빌 때까지 반복 
        while(!queue.isEmpty()){
            int[] current = queue.poll();  // 큐의 맨 앞 요소 꺼냄
            boolean hasHighPriority = false;
            
            // 현재 프로세스보다 우선순위가 높은 프로세스가 있는지 검사
            for(int[] process : queue){ 
                if(process[1] > current[1]){  
                    hasHighPriority = true;
                    break;
                }
            }
            
            // 더 높은 우선순위가 존재하면
            if(hasHighPriority){  
                queue.add(current);  // 현재 current 값을 다시 큐 뒤로 보냄
            }else{
                answer ++; 
                if(current[0] == location){ // 내가 찾는 위치의 프로세스라면 순서 반환
                    return answer;
                }
            }
            
            
        }
        
        
        return answer;
    }
}
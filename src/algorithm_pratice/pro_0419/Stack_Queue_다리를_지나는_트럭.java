package algorithm_pratice.pro_0419;

import java.util.*;

public class Stack_Queue_다리를_지나는_트럭 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		 int[] bridge_length = {2,100,100};
		 int[] weight = {10,100,100};
		 int[][] truck_weights = {{7,4,5,6},{10},{10,10,10,10,10,10,10,10,10,10}};
		 
		 for(int i =0; i< truck_weights.length;i++) {
			 int result = sol.solution(bridge_length[i], weight[i], truck_weights[i]);
			 System.out.println("return: "+result); 
		 }

	}

}

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> bridge = new LinkedList<>();
		int time = 0; //걸리는 시간
		int curWeight = 0; //현재 무게 

		for (int tw : truck_weights) {
			while (true) {
				if (bridge.size() == bridge_length) { 
					curWeight -= bridge.poll(); 
				}
				
				// 새로운 트럭이 올라갈 수 잇을때 
				if (curWeight + tw <= weight) {
					bridge.add(tw);
					curWeight += tw;
					time++;
					break;
				} else {
					bridge.add(0);
					time++;
				}
			}
		}
		answer = time + bridge_length;
		return answer;
	}
}
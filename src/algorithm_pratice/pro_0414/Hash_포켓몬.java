package algorithm_pratice.pro_0414;

import java.util.HashSet;

public class Hash_포켓몬 {

	public static void main(String[] args) {
		 int[][] nums = {{3,1,2,3}, {3,3,3,2,2,4}, {3,3,3,2,2,2}};
		 for(int i=0;i<nums.length;i++) {
			 System.out.println(solution(nums[i])); 
		 }
	}
	 
	public static int solution(int[] nums) {
	        int answer = 0;
	        HashSet<Integer> set = new HashSet<>();
	        
	        int len = nums.length / 2; 
	        for(int n:nums){
	            set.add(n); 
	        }
	        
	        if(len < set.size() ){
	            answer = len;
	        }else{
	            answer = set.size();
	        }
	        
	        return answer;
	}

}

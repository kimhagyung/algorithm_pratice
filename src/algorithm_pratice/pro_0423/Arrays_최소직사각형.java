package algorithm_pratice.pro_0423;

import java.util.Arrays;

public class Arrays_최소직사각형 {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };

		System.out.println("최종 정답: " + sol.solution(sizes));
	}
}

class Solution2 {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_long =0;
        int short_long =0;
        
        for(int i =0;i<sizes.length;i++){ 
            int cur_long = Math.max(sizes[i][0], sizes[i][1]);
            int cur_short = Math.min(sizes[i][0], sizes[i][1]);
            
            if(max_long < cur_long){
                max_long = Math.max(max_long, cur_long); 
            }
            
            if(short_long < cur_short){
                short_long = Math.max(short_long, cur_short);
            }
        }
        
        answer = max_long * short_long;
        return answer;
    }
}
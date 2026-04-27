package algorithm_pratice.pro_0426;

import java.util.Arrays;

public class Brute_Force_카펫 {

	public static void main(String[] args) {
		int[] brown  = {10, 8, 24};
		int[] yellow = {2, 1, 24};
		
		Solution sol = new Solution();
		for(int i =0;i<yellow.length;i++) {
			int[] res = sol.solution(brown[i], yellow[i]);
			System.out.println("res :" + Arrays.toString(res));
		}
	}

}

class Solution {
    public int[] solution(int brown, int yellow) {
        int totalLength = brown + yellow;
        int[] answer = {};
    
        // i - brown(3 이상이어야 yellow 생성 가능) , j = yellow 
        for(int i =3;i < totalLength;i++){ 
             if(totalLength % i == 0){ 
                 int j = totalLength / i;
                 
                 if(i >= j && (i-2)*(j-2) == yellow){ // yellow: brown 테두리를 뺸 공식(가로: 좌 + 우 → 2칸 제거, 세로: 위 + 아래 → 2칸 제거)
                    answer = new int[] { i, j };
                    break;
                 }
             }
        }
        return answer;
    }
}
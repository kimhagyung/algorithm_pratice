package algorithm_pratice.pro_0414;

import java.util.HashMap;

public class Hash_의상 {

	public static void main(String[] args) {
		String[][][] clothes = {
			    {
			        {"yellow_hat", "headgear"},
			        {"blue_sunglasses", "eyewear"},
			        {"green_turban", "headgear"}
			    },
			    {
			        {"crow_mask", "face"},
			        {"blue_sunglasses", "face"},
			        {"smoky_makeup", "face"}
			    }
			};
		for(int i =0;i<clothes.length;i++) {
			System.out.println(solution(clothes[i]));  
		}
	}

	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i< clothes.length;i++){
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
         
        for(int num : map.values()){
            answer *= (num+1);
        }
         
        
        return answer -1;
    }
}

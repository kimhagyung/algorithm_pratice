package algorithm_pratice.pro_0501;

public class DFS_타겟넘버 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] numbers = {{1, 1, 1, 1, 1},{4, 1, 2, 1}};
		int[] target = {3,4};
		
		for(int i =0;i<target.length;i++) {
			int result = sol.solution(numbers[i], target[i]);
			System.out.println(result);
		}
	}
}

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0,0);
        
        return answer;
    }
    
    public int dfs(int[] numbers,int target, int index, int sum ){
        if(index == numbers.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }
        
        int add = dfs(numbers, target, index + 1, sum+numbers[index]);
        int sub = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        return add + sub;
    }
}
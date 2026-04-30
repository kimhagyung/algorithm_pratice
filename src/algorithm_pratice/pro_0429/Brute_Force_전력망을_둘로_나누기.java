package algorithm_pratice.pro_0429;

public class Brute_Force_전력망을_둘로_나누기 {

	public static void main(String[] args) {

		int[] n = { 9, 4, 7 };
		int[][][] wires = { 
					{ { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } },
					{ { 1, 2 }, { 2, 3 }, { 3, 4 } },
					{ { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } } 
				};
		
		Solution sol = new Solution();
		for (int i = 0; i < n.length; i++) {
		    System.out.println(sol.solution(n[i], wires[i]));
		}
	}

}

class Solution {
	int minDifference = Integer.MAX_VALUE; //최조차이 저장 변수 
	boolean[][] map; //전력망 연결지도
	
    public int solution(int n, int[][] wires) {
    	minDifference = Integer.MAX_VALUE;
    	map = new boolean[n+1][n+1];
    	
    	//지도에 전선 그리기
    	for(int[] wire : wires) {
    		map[wire[0]][wire[1]] = true;
    		map[wire[1]][wire[0]] = true;
    	}
    	
    	//전선 끊어보기 
    	for(int[] wire : wires) {
    		int a = wire[0];
    		int b = wire[1];
    		
    		map[a][b] = false;
    		map[b][a] = false;
    		
    		boolean[] visited = new boolean[n+1];
    		int countA = dfs(a, visited, n); // 영역 1 
    		int countB = n - countA; // 영역 2
    		
    		minDifference = Math.min(minDifference,  Math.abs(countA - countB));
    		
    		map[a][b] = true;
    		map[b][a] = true;
    		
    	}
    	return minDifference;
    	
    }
    
    public int dfs(int current, boolean[] visited, int n) {
    	visited[current] = true; //방문도장 
    	int count = 1; //본인포함 
    	
    	for(int i =1;i<= n;i++) {
    		if(map[current][i] && !visited[i]) {
    			count += dfs(i, visited, n);
    		}
    	}
    	return count; 
    }
}



package algorithm_pratice.pro_0502;

public class DFS_네트워크 {

	public static void main(String[] args) {
		int[][][] computers = { { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }, { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } } };
		int[] n = {3,3};
		
		Solution sol = new Solution();
		
		for(int i = 0;i<n.length;i++) {
			int res = sol.solution( n[i], computers[i]);
			System.out.println(res);
			
		}
	}

}

class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, n, visited, computers);
				answer++;
			}
		}
		return answer;
	}
 

	public void dfs(int current, int n, boolean[] visited, int[][] computers) {
		visited[current] = true;

		for (int i = 0; i < n; i++) {
			if (!visited[i] && computers[current][i] == 1) {
				dfs(i, n, visited, computers);
			}
		}
	}
}
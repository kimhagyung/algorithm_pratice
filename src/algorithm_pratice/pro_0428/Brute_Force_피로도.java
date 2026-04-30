package algorithm_pratice.pro_0428;
 
public class Brute_Force_피로도 {

	public static void main(String[] args) {
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		int k = 80; 
		
		Solution sol = new Solution();
		System.out.println(sol.solution(k, dungeons));
	}

}


class Solution {
    int maxDungeon = 0;
    boolean[] visited; //던전 방문 여부
    public int solution(int k, int[][] dungeons) {
    	visited = new boolean[dungeons.length];
    	dfs(k, 0, dungeons);
        return maxDungeon;
    }
    
    public void dfs(int k, int count, int[][] dungeons) {
    	maxDungeon = Math.max(maxDungeon, count); //지금 까지 온 던전수가 count > maxDungeon 이면 
    	for(int i=0;i<dungeons.length; i++) {
    		if(!visited[i] && k >= dungeons[i][0]) {
    			visited[i] = true;
    			dfs(k-dungeons[i][1], count+1, dungeons);
    			visited[i] = false;
    		}
    	}
    }
    
}


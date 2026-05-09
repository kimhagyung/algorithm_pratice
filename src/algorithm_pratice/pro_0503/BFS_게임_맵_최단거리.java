package algorithm_pratice.pro_0503;

import java.util.*;

public class BFS_게임_맵_최단거리 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][][] maps = {
				{ { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } },
				{ { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 } } };
		
		for(int[][] m : maps) {
		    int res = sol.solution(m);
		    System.out.println(res);
		}
	}

}

class Solution {

	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];

			// 동서남북 4방향
			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}

				if (maps[nextX][nextY] == 1) {
					queue.add(new int[] { nextX, nextY });
					maps[nextX][nextY] = maps[currentX][currentY] + 1;
				}
			}
		}

		int answer = maps[n - 1][m - 1];

		if (answer == 1) {
			return -1;
		}

		return answer;
	}
}
package algorithm_pratice.pro_0507;

import java.util.*;

public class BFS_아이템줍기 {

	public static void main(String[] args) {

		int[][][] rectangles = { { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } },
				{ { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 } }, { { 1, 1, 5, 7 } },
				{ { 2, 1, 7, 5 }, { 6, 4, 10, 10 } }, { { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 } } };

		int[] characterX = { 1, 9, 1, 3, 1 };

		int[] characterY = { 3, 7, 1, 1, 4 };

		int[] itemX = { 7, 6, 4, 7, 6 };

		int[] itemY = { 8, 1, 7, 10, 3 };
		
		Solution sol = new Solution();
		
		for(int i =0 ;i<rectangles.length;i++) {
			int res = sol.solution(rectangles[i], characterX[i], characterY[i], itemX[i], itemY[i]);
			System.out.println(res);
		}
	}
}

class Solution {
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

		int[][] map = new int[101][101];

		for (int[] r : rectangle) {
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;

			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					if (map[i][j] == 2)
						continue;

					if (i == x1 || i == x2 || j == y1 || j == y2) {
						map[i][j] = 1;
					} else {
						map[i][j] = 2;
					}
				}
			}
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { characterX * 2, characterY * 2, 0 });
		boolean[][] visited = new boolean[101][101];
		visited[characterX * 2][characterY * 2] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int dist = curr[2];

			if (x == itemX * 2 && y == itemY * 2) {
				return dist / 2;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101) {
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny, dist + 1 });
					}
				}
			}
		}

		return 0;
	}
}

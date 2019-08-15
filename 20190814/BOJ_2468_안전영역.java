import java.util.Scanner;

public class BOJ_2468_안전영역 {
	static int[][] map;
	static int[][] newmap;
	static boolean[][] check;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int temp_result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int max = 0;
		int min = 101;
		int result = 0;
		map = new int[n][n];
		newmap = new int[n][n];
		check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if (max < temp)
					max = temp;
				if (min > temp)
					min = temp;
			}
		}

		for (int k = min - 1; k <= max; k++) {
			newmap = map;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					check[i][j] = false;// check함수도 초기화 해야지
					if (map[i][j] <= k) {
						newmap[i][j] = 0;
					}
				}
			}
			temp_result = 0;
			// 0이 아닌 부분의 갯수를 세야해
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (newmap[i][j] > 0 && check[i][j] == false) {
						temp_result++;
						dfs(i, j);

					}
				}

			}
			if (temp_result > result)
				result = temp_result;

		}
		System.out.println(result);

	}

	static void dfs(int i, int j) {
		check[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (newmap[nx][ny] > 0 && check[nx][ny] == false) {
					// check[nx][ny] = true;
					dfs(nx, ny);
				}
			}

		}
	}

}

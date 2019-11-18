import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

}

public class Solution_탈주범검거 {

	private static int l;
	private static int n;
	private static int m;
	private static int sum;

	private static int[] dx = { 0, 1, 0, -1 };// 우, 하, 좌, 상
	private static int[] dy = { 1, 0, -1, 0 };

	private static int[][] dir = { {}, { 0, 1, 2, 3 }, { 1, 3 }, { 0, 2 }, { 0, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 } };

	static Queue<Pair> q;
	private static int[][] arr;
	private static int[][] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			sum = 0;
			n = sc.nextInt(); // 5
			m = sc.nextInt(); // 6
			int r = sc.nextInt(); // 2
			int c = sc.nextInt(); // 1
			l = sc.nextInt();
			arr = new int[n][m];
			check = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			q = new LinkedList<>();
			q.add(new Pair(r, c));

			solve();

			System.out.println("#" + t + " " + sum);
		}

	}

	private static void solve() {

		while (l-- > 0) {
			int qsize = q.size();
			sum += qsize; // 이게 마지막답
			for (int i = 0; i < qsize; i++) {
				Pair p = q.poll();
				// System.out.println("p" +p.x+" "+p.y);
				check[p.x][p.y] = 1;
				int val = arr[p.x][p.y];
				int nx, ny;

				for (int j = 0; j < dir[val].length; j++) { // 갈수 있는 방향만 탐색
					nx = p.x + dx[dir[val][j]];
					ny = p.y + dy[dir[val][j]];
					// System.out.println(nx+" "+ny);
					if (nx >= 0 && ny >= 0 && nx < n && ny < m && check[nx][ny] == 0 && arr[nx][ny] > 0) {

						if (dir[val][j] == 0) {// 우
							if (arr[nx][ny] == 2 || arr[nx][ny] == 4 || arr[nx][ny] == 5) {
								continue;
							}
						} else if (dir[val][j] == 1) { // 하
							if (arr[nx][ny] == 3 || arr[nx][ny] == 5 || arr[nx][ny] == 6) {
								continue;
							}
						} else if (dir[val][j] == 2) { // 좌
							if (arr[nx][ny] == 2 || arr[nx][ny] == 6 || arr[nx][ny] == 7) {
								continue;
							}
						} else if (dir[val][j] == 3) { // 상
							if (arr[nx][ny] == 3 || arr[nx][ny] == 4 || arr[nx][ny] == 7) {
								continue;
							}
						}

						check[nx][ny] = 1;
						q.add(new Pair(nx, ny));
					}

				} // end of for

			}
		}

	}// end of solve

}

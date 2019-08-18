package hw20190816;
import java.util.Scanner;

public class SWEA_7234_안전기지 {
	static int[][] arr;
	static int[][] check;
	static int result, n;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			result = 0;
			n = sc.nextInt();
			int num = sc.nextInt();
			arr = new int[n + 1][n + 1];
			check = new int[n + 1][n + 1];
			for (int i = 0; i < num; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;
				change(x, y);
			}
			find();
			System.out.println("#" + t + " " + result);
		}
	}

	private static void change(int i, int j) {
		check[i][j]++;
		for (int k = 0; k < 4; k++) {
			for (int m = 1; m < 3; m++) {
				if (i + m * dx[k] > 0 && i + m * dx[k] <= n && j + m * dy[k] >= 0 && j + m * dy[k] <= n) {
					check[i + m * dx[k]][j + m * dy[k]]++;
				}
			}
		}
	}

	private static void find() {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (check[i][j] > result)
					result = check[i][j];
			}
		}
	}
}

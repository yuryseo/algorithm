import java.util.Scanner;

public class Jungol_1681_해밀턴순환회로 {
	private static int min;
	private static int n;
	private static int[][] arr;
	private static boolean[] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(min);

	}

	private static void dfs(int current, int value) {
		if (value > min) {
			return;
		}
		if (current == 0) {
			if (check()) {
				if (value < min)
					min = value;
				return;
			}
		}
		for (int i = 0; i < n; i++) {
			if (!check[current] && arr[current][i] > 0) {
				check[current] = true;
				dfs(i, value + arr[current][i]);
				check[current] = false;
			}

		}

	}

	private static boolean check() {
		boolean flag = true;
		for (int i = 1; i < n; i++) {
			if (!check[i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}

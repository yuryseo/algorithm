import java.util.Scanner;

public class Main_14889_스타트와링크 {
	static int result = Integer.MAX_VALUE;
	static int[] check;
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n][n];
		check = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		check[0] = 0;
		perm(1);

		System.out.println(result);

	}

	private static void perm(int index) {
		if (index == n) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (check[i] == check[j] && check[i] == 0) {
						sum1 += arr[i][j];
					} else if (check[i] == check[j] && check[i] == 1) {
						sum2 += arr[i][j];
					}
				}
			}
			int temp = Math.abs(sum1 - sum2);
			if (temp < result) {
				result = temp;
			}
			return;

		}
		check[index] = 0;
		perm(index + 1);
		check[index] = 1;
		perm(index + 1);
	}

}

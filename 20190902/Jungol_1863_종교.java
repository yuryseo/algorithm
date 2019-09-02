import java.util.Arrays;
import java.util.Scanner;

public class Jungol_1863_종교 {
	static int[] root;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 10
		int m = sc.nextInt(); // 9
		root = new int[n + 1];
		int[][] arr = new int[m][2];
		Arrays.fill(root, -1);

		for (int t = 0; t < m; t++) {

			arr[t][0] = sc.nextInt();
			arr[t][1] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			union(arr[i][0], arr[i][1]);
		}
		int count = 0;
		for (int i = 1; i < root.length; i++) {
			// System.out.print(root[i]+" ");
			if (root[i] == -1)
				count++;
		}

		System.out.println(count);

	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			root[bRoot] = aRoot;
		}

	}

	private static int find(int a) {

		if (root[a] < 0)
			return a;
		else
			return root[a] = find(root[a]);
	}

}

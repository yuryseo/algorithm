import java.util.Scanner;

public class Jungol1175_주사위던지기 {
	private static int[] selected;
	private static int N, target;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		selected = new int[N];
		target = sc.nextInt(); 
		subsetSum(0, 0);

	}

	static void subsetSum(int sum, int cnt) {
		if (cnt == N) {
			if (sum == target) {
				for (int i = 0; i < cnt; i++) {
					System.out.print(selected[i] + " ");
				}
				System.out.println();
				return;
			}
			return;
		}
		for (int i = 1; i <= 6; i++) {
			selected[cnt] = i;
			subsetSum(sum + i, cnt + 1);
		}
	}
}

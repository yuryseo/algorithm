import java.util.Scanner;

public class BOJ_9095_123더하기 {
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		while (testcase-- > 0) {
			int result = 0;
			count = 0;
			int goal = sc.nextInt();
			add(result, goal);

			System.out.println(count);
		}

	}

	static void add(int result, int goal) {
		if (result > goal)
			return;
		if (result == goal) {
			count++;
		}
		for (int i = 1; i <= 3; i++) {
			add(result + i, goal);
		}

	}

}
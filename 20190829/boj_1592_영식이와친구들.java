import java.util.Scanner;

public class boj_1592_영식이와친구들 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];
		int result = 0;
		arr[0] = 1;
		int current = 0;
		while (true) {
			if (arr[current] == M)
				break;
			if (arr[current] % 2 == 0) {// 짝수일때 반시계
				current = (current - L + N) % N;
				arr[current]++;
				result++;
			} else { // 홀수 일때
				current = (current + L) % N;
				arr[current]++;
				result++;
			}
		}
		System.out.println(result);

	}

}

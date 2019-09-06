import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17136_색종이붙이기 {

	private static int[][] arr;
	private static int min;
	private static int[] p = { 0, 5, 5, 5, 5, 5 }; // 색종이의 남은개수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		arr = new int[10][10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			str = br.readLine();
			for (int j = 0; j < 10; j++) {
				arr[i][j] = str.charAt(j << 1) - '0'; // = str.charAt(j*2)
				sum += arr[i][j];
			}
		}
		min = Integer.MAX_VALUE;

		if (sum == 100) {
			min = 4;
		} else {
			dfs(sum, 0);
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}// end of main

	/**
	 * arr[][] : 색종이를 붙이고 남은 숫자배열
	 * 
	 * @param sum 남은 1의 갯수
	 * @param cnt 사용한 색종이의 개수
	 */
	private static void dfs(int sum, int cnt) {
		if (cnt > min) { // d이미 최솟값보다 커졌다면
			return;
		} else if (sum == 0) { // 종료
			if (cnt < min)
				min = cnt;
			return;

		} else { // 반복
			int r = -1;
			int c = -1;
			ex: for (r = 0; r < 10; r++) {
				for (c = 0; c < 10; c++) {
					if (arr[r][c] == 1) { // map이 1이면

						break ex;
					}
				}
			}
			int maxSize = 5;
			for (; maxSize >= 1; maxSize--) { // 큰종이를 붙일 수 있다면 그보다 작은 종이는 붙일 수 있어
				if (check(r, c, maxSize)) {
					break;
				}
			}
			for (int size = maxSize; size >= 1; size--) {
				if (p[size] > 0) { // 사이즈의 색종이가 남아있으면
					// 사이즈만큼의 사각형영역을 0으로 덮는다
					paint(r, c, size, 0);
					// 사용한 색종이 수 감소
					p[size]--;

					// 다음칸으로 재귀 호출
					dfs(sum - (size * size), cnt + 1);

					// 색종이 수 원상복귀
					p[size]++;

					// 사각영역 원상복귀
					paint(r, c, size, 1);

				}
			}

		}

	}// end of dfs

	/** (r,c)자표에서 시작하는 size크기의 정사각형의 value를 채움 */
	private static void paint(int r, int c, int size, int val) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				arr[i][j] = val;
			}
		}

	}

	private static boolean check(int r, int c, int size) {
		if (r + size > 10 || c + size > 10) {
			return false;
		}
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if ( arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}// end of check

}// end of class

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17471_게리멘더링 {

	private static int n, sum;
	private static int min = Integer.MAX_VALUE;
	private static int[] people, combi, check;
	private static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		people = new int[n];
		combi = new int[n];
		map = new int[n][n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 마을의 인접 정보
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); // 인접해 있는 마을의 수
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken()) - 1;
				map[i][temp] = map[temp][i] = 1; // 인접해 있는 마을 1로표시
			}
		}
		combination(0);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void combination(int index) {

		if (index == n) {
			check = new int[n];
			int g1 = 0, g2 = 0;

			// System.out.println(Arrays.toString(combi));

			for (int i = 0; i < n; i++) {
				if (combi[i] == 0 && check[i] == 0) {
					sum = 0;
					gary(i);
					g1 = sum;
					break;
				}
			}
			for (int i = 0; i < n; i++) {
				if (combi[i] == 1 && check[i] == 0) {
					sum = 0;
					gary(i);
					g2 = sum;
					break;
				}
			}
			for (int i = 0; i < n; i++) {
				if (check[i] == 0) {
					// check배열이 하나라도 1인게 있으면 방문하지 못한거. 두구역으로 나눠지지않음.
					return;
				}
			}
			int temp = Math.abs(g1 - g2);
			if (min > temp) {
				min = temp;
			}
			return;

		}
		combi[index] = 0;
		combination(index + 1);
		combi[index] = 1;
		combination(index + 1);

	}

	private static void gary(int now) {
		check[now] = 1;
		sum += people[now];
		for (int i = 0; i < n; i++) {
			if (check[i] == 0 && combi[now] == combi[i] && map[i][now] == 1) {
				gary(i);
			}
		}
	}

}

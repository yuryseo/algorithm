import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방 {
	static int n;
	static int[][] arr;
	static int[][] check;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static int count;
	private static int max;
	private static int value;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			check = new int[n][n];
			max = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			value = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					count = 0;
					check[i][j] = 1;
					find(i, j, arr[i][j], i, j);
					check[i][j] = 0;
				}
			}
			//System.out.println("#" + t + " " + value + " " + (max + 1));
			System.out.printf("#%d %d %d\n",t,value,max+1);
		}

	}

	private static void find(int i, int j, int current, int startx, int starty) {

		if (count == max) {
			if (value > arr[startx][starty])
				value = arr[startx][starty];
		} else if (count > max) {
			max = count;
			value = arr[startx][starty];
		}
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (arr[nx][ny] == (current + 1) && check[nx][ny] == 0) {
					check[nx][ny] = 1;
					count++;
					find(nx, ny, current + 1, startx, starty);
					check[nx][ny] = 0;
					count--;
				}
			}
		}

	}

}

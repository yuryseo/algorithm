/*import java.io.FileInputStream;
import java.io.FileNotFoundException;*/
import java.util.Scanner;

public class Solution_D4_1210_Ladder1_서유리{
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { 1, -1, 0 };
	static int[][] arr;
	static int[][] check;
	static int result = 0;

	public static void main(String[] args)  { /*throws FileNotFoundException*/
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();// 1
			arr = new int[100][100];
			check = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int j = 0; j < 100; j++) {
				if (arr[99][j] == 2) {
					// System.out.println(j);
					check[99][j] = 1;
					find(99, j);
				}

			}

			System.out.println("#" + n + " " + result);
		}

	}

	static void find(int i, int j) {

		if (i == 0) {
			result = j;
			return;
		}
		check[i][j] = 1;
		for (int k = 0; k < 3; k++) {

			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx < 0 || ny < 0 || nx >= 100 || ny >= 100)
				continue;
			if (arr[nx][ny] != 1 || check[nx][ny] == 1)
				continue;
			
			find(nx, ny);
			break;
		}

	}

}
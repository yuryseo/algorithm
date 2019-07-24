import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1_2{

	static int[][] arr;
 
	static int result = 0; 

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();// 1
			arr = new int[102][102];
			int x = 0;
			int y = 0;

			for (int i = 1; i <= 100; i++) {
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2) {
						x = i;
						y = j;

					}
				}
			}
			// System.out.println(y);
			for (int i = 99; i > 0; i--) {
				x--;
				if (arr[x][y + 1] == 1) {
					while (true) {
						y++;
						if (arr[x][y + 1] != 1)
							break;

					}
				} else if (arr[x][y - 1] == 1) {
					while (true) {
						y--;
						if (arr[x][y - 1] != 1)
							break;

					}
				}
			}

			System.out.println("#" + n + " " + y);
		}

	}

}
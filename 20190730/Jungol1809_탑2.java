import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jungol1809_ž2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] tower = new int[T + 1];
		int[] result = new int[T + 1];
		
		String[] s = br.readLine().split(" ");
		for (int t = 1; t <= T; t++) {
			tower[t] = Integer.parseInt(s[t - 1]);
		}
		for (int i = 1; i < T + 1; i++) {
			result[i] = 0;
			for (int j = i - 1; j >= 1; j--) {
				if (tower[j] >= tower[i]) {
					result[i] = j;
					break;
				}
			}
		}
		for (int t = 1; t <= T; t++)
			System.out.print(result[t] + " ");
	}

}

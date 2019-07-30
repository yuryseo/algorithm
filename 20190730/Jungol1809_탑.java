import java.util.Scanner;

public class Jungol1809_ž {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] tower = new int[T + 1];
		int[] result = new int[T + 1];
		
		for (int t = 1; t <= T; t++) {
			tower[t] = sc.nextInt(); 
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

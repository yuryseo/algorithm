import java.util.Scanner;

public class Ex3_Coin2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[][] D = new int[3][money + 1]; // 각 금액을 만들 수 있는 최소동전갯수 저장
		int coin[] = { 1, 4, 6 };
		int min;

		for (int j = 1; j <= money; j++) {
			D[0][j] = j;
		} // 1원 동전만 고려ㅅ해서 만들수 있는 최소동전갯수 처리

		for (int i = 1; i < 3; i++) {
			for (int j = 1; j <= money; j++) {
				if (coin[i] <= j) {
					D[i][j] = Math.min(D[i][j - coin[i]] + 1, D[i - 1][j]);
				} else {
					D[i][j] = D[i - 1][j];
				}
			}

		}
		System.out.println(D[2][money]);

	}

}

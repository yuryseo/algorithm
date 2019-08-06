import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기_서유리 {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			int count = 1;
			while (true) {

				int temp = q.poll() - count;
				if (temp <= 0) {
					temp = 0;
					q.offer(temp);
					break;
				}
				q.offer(temp);
				count++;
				if (count == 6) {
					count = 1;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}

	}

}

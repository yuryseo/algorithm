import java.util.Arrays;
import java.util.Scanner;

/*class Pair {
	int x, y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}*/
public class jungol_2634_사냥꾼 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] arr = new int[m];
		boolean[] check = new boolean[n];
		Pair[] animal = new Pair[n];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int x, y;
		for (int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
				animal[i] = new Pair(x, y);
		}
		int temp;
		int count = 0;
		a : for (int i = 0; i < m; i++) { // 4
			for (int j = 0; j < n; j++) { // 8
				if (check[j])
					continue;
				if (arr[i] >= animal[j].x) {
					temp = arr[i] - animal[j].x + animal[j].y;
				} else {
					temp = animal[j].x - arr[i] + animal[j].y;
				}
				if (temp <= l) {
					check[j] = true;
					count++;
					if(count==n+1) {
						break a ;
					}
				}
			}
		}

		System.out.println(count);

	}

}

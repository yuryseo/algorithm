import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Jungol_1828_냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[][] arr = new int[num][2];
		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();

		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int a = o1[0] - o2[0];
				if (a == 0) {
					a = o1[1] - o2[1];
				}
				return a;
			}
		});
		int count = 1;
		int big = arr[0][1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] <= big) {
				if (arr[i][1] < big) {
					big = arr[i][1];
				}
				continue;
			} else {
				big = arr[i][1];
				count++;
			}
		}

		/*
		 * for (int i = 0; i < arr.length; i++) {
		 * System.out.println(Arrays.toString(arr[i])); }
		 * 
		 */
		System.out.println(count);
	}

}

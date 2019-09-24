import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Jungol2247_도서관 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int a = o1[0] - o2[0];
				if (a == 0) {
					a = o1[1] - o2[1];
				}
				return a;
			}
		});

		int study = 0;
		int empty = 0;
		int start = arr[0][0];
		int end = arr[0][1];
		int temp=0;
/*		for (int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}*/
		for (int i = 0; i < n; i++) {
			if (end >= arr[i][0]) {
				if (end < arr[i][1])
					end = arr[i][1];
			} else {
				 temp = end - start;
				if (temp > study) {
					study = temp;
				}
			
					temp = arr[i][0] - end;
					if (temp > empty) {
						empty = temp;
					}
					start = arr[i][0];
					end = arr[i][1];
				
			}
			if(i==n-1) {
				temp = end - start;
				if (temp > study) {
					study = temp;
				}
			}
		}
		System.out.println(study + " " + empty);

	}

}

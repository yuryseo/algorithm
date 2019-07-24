import java.util.Arrays;
import java.util.Scanner;

public class HW1_BinarySearch_서유리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
 
		} 

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int M = sc.nextInt();

		int first = 0;
		int last = arr.length - 1;
		int mid = (first + last) / 2;

		int result = 0;

		int x = sc.nextInt();// ã�� ��

		while (first <= last) {
			if (arr[mid] == x) {
				result = mid;
				break;
			} else if (arr[mid] < x) {
				first = mid + 1;
				mid = (last + first) / 2;

			} else {// x < (arr[mid])
				last = mid - 1;
				mid = (last + first) / 2;

			}

		}
		System.out.println(result);
	}

}

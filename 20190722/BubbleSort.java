
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		for (int i = N - 1; i > 0; i--) {
			boolean isSwap = false;
			for (int j = 0; j < i; j++) { 
				
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwap = true;
				}

			}
			if (!isSwap)
				break;
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
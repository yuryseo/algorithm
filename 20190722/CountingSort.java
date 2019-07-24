
import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {	

	public static void main(String[] args) { 

		Scanner sc = new Scanner(System.in);
 
		int[] arr = new int[] { 0, 4, 1, 3, 1, 2, 4, 1 };
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(countingSort(arr)));

	}

	private static int[] countingSort(int[] arr) {
		int[] counts = new int[5];
		
		for(int i =0;i<arr.length;i++) {
			counts[arr[i]]++;
		}
		
		for(int i=1;i<counts.length;i++) {
			counts[i] = counts[i-1]+counts[i];
		}
		
		int[] newArr = new int[arr.length];
		for (int i = arr.length-1;i>=0;i--) {/
			
			newArr[--counts[arr[i]]] = arr[i];
		}
		return newArr;
	}

}
package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class LISTest_BinarySearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] D = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int size = 0;

		for (int i = 0; i < n; i++) {
			int temp = Arrays.binarySearch(D, 0, size, arr[i]);
			temp = Math.abs(temp) - 1;
			D[temp] = arr[i];

			if (size == temp) {
				size++;
			}
		}
		System.out.println(size);
	}

}

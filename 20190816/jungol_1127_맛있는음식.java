package hw20190816;

import java.util.Scanner;

class Pair {
	int x, y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class jungol_1127_맛있는음식 {
	static Pair[] arr;
	static int min = 1000000000;
	static int t;
	static int sour = 1, bitter;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		arr = new Pair[t];

		for (int i = 0; i < t; i++) {
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		
		for (int i = 0; i < t; i++) {
			find(i, arr[i].x, arr[i].y);
			sour = 1;
			bitter = 0;
		}

		System.out.println(min);
	}

	private static void find(int start, int s, int b) {

		if (start == t)
			return;

		if (Math.abs(s - b) < min)
			min = Math.abs(s - b);
		for (int i = start + 1; i < t; i++) {
			find(i, s * (arr[i].x), b + (arr[i].y));
		}

	}

}

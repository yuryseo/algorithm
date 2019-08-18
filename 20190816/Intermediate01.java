package hw20190816;

import java.util.Scanner;

public class Intermediate01 {
	static char[][] arr;
	static int result, N;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int t=1;t<=testcase;t++) {
			result =0;
			N = sc.nextInt();
			arr = new char[N][N];
		
			for (int i = 0; i < N; i++) {
			String str = sc.next();
			System.out.println(str);
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			find();
			
			
			System.out.println("#"+t+" "+result);
		}
		

	}

	private static void find() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]=='A') {
					//b랑c가 아닐때만 바꿔야해
					
				}else if(arr[i][j] =='B') {
					
				}else if(arr[i][j]=='C') {
					
					
				}
					
			}
		}
		
	}

}

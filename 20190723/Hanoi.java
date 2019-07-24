package com.ssafy.recursive;

import java.util.Scanner;

public class Hanoi {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Hanoi(N, 1, 2, 3);
		int count = (int) Math.pow(2, N) - 1;
	}
	//from은 현재 위치, to는 목적지, by는 옮기기 위해 이동할 곳
	private static void Hanoi(int n, int from, int by, int to) {
		/*if (n == 0) {//123
			return;
		}*/
		if(n==1) {//한개 남았을때는 세번째자리로
			System.out.println(from + " "+to);
			return;
		}
		//n-1 개의 원판을 2번째 기둥으로 옮기기
		Hanoi(n - 1, from, to, by);
		
		//제일 큰 원판을 세번째 자리로 옮기기
		System.out.println(from + " " + to);
		
		//2번째 기둥에 있는 원판을 세번째 자리로 옮기기
		Hanoi(n - 1, by, from, to);
	}

}

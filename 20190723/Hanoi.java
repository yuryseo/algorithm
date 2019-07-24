package com.ssafy.recursive;

import java.util.Scanner;

public class Hanoi {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Hanoi(N, 1, 2, 3);
		int count = (int) Math.pow(2, N) - 1;
	}
	//from�� ���� ��ġ, to�� ������, by�� �ű�� ���� �̵��� ��
	private static void Hanoi(int n, int from, int by, int to) {
		/*if (n == 0) {//123
			return;
		}*/
		if(n==1) {//�Ѱ� ���������� ����°�ڸ���
			System.out.println(from + " "+to);
			return;
		}
		//n-1 ���� ������ 2��° ������� �ű��
		Hanoi(n - 1, from, to, by);
		
		//���� ū ������ ����° �ڸ��� �ű��
		System.out.println(from + " " + to);
		
		//2��° ��տ� �ִ� ������ ����° �ڸ��� �ű��
		Hanoi(n - 1, by, from, to);
	}

}

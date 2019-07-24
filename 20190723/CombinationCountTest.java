package com.ssafy.recursive;

import java.util.Scanner;

public class CombinationCountTest {

	public static void main(String[] args) {
		// n���� �� �߿� k���� ������ �� �ִ� ����� �� => nCk =>��ͷ�....
		// �Ȼ̴°ŵ� ����� ���� �����ؾ���...
		Scanner sc = new Scanner(System.in); 

		int N = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(combination(N, K));

	}

	private static int combination(int n, int k) {
		if (n == k ||k == 0)
			return 1;
		
		return combination(n - 1, k - 1) + combination(n - 1, k);
	}

}
//3C2 = 2C1+2C2
//nCk = n-1Ck-1 + n-1Ck
//5C3 = 5!/3!2!

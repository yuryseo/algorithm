import java.util.Scanner;

public class boj_2999_비밀이메일 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();
		int R=0,C=0;	//R<=C
		for(int i=1;i<=10;i++) {
			if(len%i==0) {
				if(len/i>=i) {
					R=i;
					C=len/i;
				}
			}
			
		}
		char[][] arr = new char[R][C];
		int charAt=0;
		for (int i = 0; i < C; i++) { // 4
			for (int j = 0; j < R; j++) {// 2
				arr[j][i] = str.charAt(charAt++);
			}
		}
		
		for (int i = 0; i < R; i++) { // 2
			for (int j = 0; j < C; j++) {// 4
				System.out.print(arr[i][j]);
			}
		}
	}

}

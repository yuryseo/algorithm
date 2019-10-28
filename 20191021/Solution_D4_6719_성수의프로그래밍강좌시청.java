import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_6719_성수의프로그래밍강좌시청 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testcase = sc.nextInt();
		int arr[];
		double result=0;
		for (int t = 1; t <= testcase; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			result =0;
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				
			}
			Arrays.sort(arr);
			double mul=2;
			for (int i = n-1; i >=n-k; i--) {
				result+=arr[i]*(1/mul);
				mul*=2;
			}
			
			System.out.printf("#%d %.6f\n",t,result);
		}
	}

}

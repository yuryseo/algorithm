import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4366_정식이의은행업무 {

	private static long[] ten;
	private static int count;
	private static long result;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
		
			result=0;
			count=0;
			String bi = sc.next();
			String tri = sc.next();
			char[] two = bi.toCharArray();
			char[] three = tri.toCharArray();
			 ten = new long[500];
			for (int i = 0; i < bi.length(); i++) {
				if(two[i]=='1') {
					two[i]='0';
					ChangeTen(two,2);
					two[i]='1';
				}else {
					two[i]='1';
					ChangeTen(two,2);
					two[i]='0';
				}
			}
			for (int i = 0; i < tri.length(); i++) {
				if(three[i]=='0') {
					three[i]='1';
					ChangeTen(three,3);
					three[i]='2';
					ChangeTen(three,3);
					three[i]='0';
				}else if(three[i]=='1'){
					three[i]='0';
					ChangeTen(three,3);
					three[i]='2';
					ChangeTen(three,3);
					three[i]='1';
				}else {
					three[i]='1';
					ChangeTen(three,3);
					three[i]='0';
					ChangeTen(three,3);
					three[i]='2';
				}
			}
			Arrays.sort(ten);
			for (int i = 0; i < ten.length-1; i++) {
				if(ten[i]!=0 &&ten[i]==ten[i+1]) {
					result=ten[i];
				}
				if(result!=0) break;
			}
			System.out.println("#"+t+" "+result);
			
		}
		
	}

	static void ChangeTen(char[] arr, int num) {
		long temp =0;
		for (int i = 0; i < arr.length; i++) {
			temp+=((arr[i]-'0')*((Math.pow(num, arr.length-i-1))));
		}
		ten[count++]=temp;
	}

}

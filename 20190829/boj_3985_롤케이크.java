import java.util.Scanner;

public class boj_3985_롤케이크 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int num = sc.nextInt();
		int[] cake = new int[L+1];
		int[] people = new int[num+1];
		int expect=0;
		int real =0;
		int start,end, cakenum=0;
		for (int i = 1; i <= num; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			if(cakenum < end-start+1) {
				expect=i;
				cakenum = end-start+1;
			}
			for(int j=start;j<=end;j++) {
				if(cake[j]==0) {
					cake[j]=i;
					people[i]++;
				}
			}
			
		}
		/*
		System.out.println(Arrays.toString(cake));
		System.out.println(Arrays.toString(people));*/
		for (int i = 1; i < people.length; i++) {
			if(people[real]<people[i]) {
				real =i;
			}
		}
		System.out.println(expect);
		System.out.println(real);
		
	}

}

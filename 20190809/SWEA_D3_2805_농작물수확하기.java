import java.util.Scanner;

public class SWEA_D3_2805_농작물수확하기 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
         for (int t =1; t <= testcase; t++) {
            int result =0;
            String str;
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                str = sc.next();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j)-'0';
                }
            }
            int half = (N/2);
            int start = (N/2);
            int end = (N/2);
            for (int i = 0; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    result+=arr[i][j];
                }
                if(i<half) {
                    start--;
                    end++;
                }else {
                    start++;
                    end--;
                }
            }
             System.out.println("#"+t+" "+result);
        }
    }
}

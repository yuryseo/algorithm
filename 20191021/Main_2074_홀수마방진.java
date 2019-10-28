import java.util.Scanner;
  
public class Main_2074_홀수마방진 {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int x = 0;
        int y = n / 2;
        int end = n * n;
  
        for (int i = 1; i <= end; i++) {
            arr[x][y] = i;
            if (i % n == 0) { // 나누어 떨어지면
                x++;
            } else {
                x--; y--;
                if (x < 0) x = n - 1;
                if (y < 0) y = n - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
  
    }
  
}

import java.util.Scanner;

public class BOJ_2563_색종이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[100][100];
        int count = 0;
        
        for(int t = 0; t < n; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for(int i = x; i < x + 10; i++) {
                for(int j = y; j < y + 10; j++) {
                    if(map[i][j] == 1)
                        continue;
                    map[i][j] = 1;
                   count++;
                }
            }
        }
        System.out.println(count);
    }
}
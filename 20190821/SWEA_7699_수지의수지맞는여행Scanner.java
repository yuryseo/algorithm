import java.util.Scanner;

public class SWEA_7699_수지의수지맞는여행Scanner {
    static int r, c;
    static char[][] arr;
    static int[] check;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        for (int t = 1; t <= testcase; t++) {
            result = 0;
            r = sc.nextInt();
            c = sc.nextInt();
            arr = new char[r][c];
            check = new int[26];
            for (int i = 0; i < r; i++) {
                String str = sc.next();
                for (int j = 0; j < c; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            int cur = arr[0][0] - 'A';
            check[cur] = 1;
            travel(0, 0, 1);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void travel(int i, int j, int max) {

        if (max > result)
            result = max;
        if(result == 26)return;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                int temp = arr[nx][ny] - 'A';
                if (check[temp] == 0) {
                    check[temp] = 1;
                    travel(nx, ny, max + 1);
                    check[temp] = 0;
                }
            }
        }
    }
}
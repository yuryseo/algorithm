import java.util.Scanner;

public class Jungol_1230_선물의집 {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] arr;
    static boolean[][] check;
    static int n;
    static int result;

    // 0은 길, 1은 벽, 2는 선물의 위치
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        check = new boolean[n][n];
        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        if (arr[0][0] == 2) {
            result = 1;}
        check[0][0]=true;
        dfs(0, 0, result);
        System.out.println(result);
    }

    private static void dfs(int i, int j, int max) {
        if (i == n - 1 && j == n - 1) {
            if(result<=max) result=max;
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                if (check[x][y] == false && arr[x][y] != 1) {
                    check[x][y] = true;
                    if (arr[x][y] == 2) {
                        dfs(x, y, max + 1);
                    } else {
                        dfs(x, y, max);
                    }
                    check[x][y] = false;
                }

            }
        }

    }

}
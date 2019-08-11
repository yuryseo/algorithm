import java.util.Scanner;

public class BOJ_10026_적록색약 {
    static char[][] arr;
    static int[][] check;
    static int result, n;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];
        check = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j]=str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == 0) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.print(result + " ");
        result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G')
                    arr[i][j] = 'R';
                check[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == 0) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    private static void dfs(int i, int j) {

        check[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == arr[i][j] && check[nx][ny] == 0) {
                    
                    dfs(nx, ny);
                }
            }
        }

    }

}
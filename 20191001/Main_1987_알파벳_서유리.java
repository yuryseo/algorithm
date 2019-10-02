import java.util.Scanner;

public class Main_1987_알파벳_서유리 {
    static int x, y;
    static int[][] arr;
    static int[] check;

    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static int count = 0;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt(); // 2
        y = sc.nextInt(); // 4
        arr = new int[x][y];
        check = new int[26];

        for (int i = 0; i < x; i++) {
            String str = sc.next();
            for (int j = 0; j < y; j++) {
                arr[i][j] = str.charAt(j) - 'A';
            }
        }

        check[arr[0][0]] = 1;
        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int i, int j) {

        count++;
        check[arr[i][j]] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                if (check[arr[nx][ny]] == 0) {
                    dfs(nx, ny);
                    
                    count--;
                    check[arr[nx][ny]] = 0;
                }
            }
        }

        result = Math.max(result, count);

    }

}
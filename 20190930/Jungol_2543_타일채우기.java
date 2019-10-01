import java.util.Scanner;

public class Jungol_2543_타일채우기 {

    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n][n];
        int tx = sc.nextInt();
        int ty = sc.nextInt();

        arr[tx][ty] = -1;

        find(0, 0, n - 1, n - 1, tx, ty);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==-1) arr[i][j]=0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void find(int sx, int sy, int ex, int ey, int tx, int ty) {

        int mx = (sx + ex) / 2;
        int my = (sy + ey) / 2;

        if (ex == sx)
            return;

        if ((tx >= sx) && (tx <= mx) && (ty >= sy) && (ty <= my)) { // 1
            arr[mx + 1][my] = arr[mx + 1][my + 1] = arr[mx][my + 1] = 1;
            find(sx, sy, mx, my, tx, ty); // 1
            find(sx, my + 1, mx, ey, mx, my + 1); // 2
            find(mx + 1, sy, ex, my, mx + 1, my); // 3
            find(mx + 1, my + 1, ex, ey, mx + 1, my + 1); // 4
        }

        else if ((tx >= sx) && (tx <= mx) && (ty >= my + 1) && (ty <= ey)) { // 2
            arr[mx][my] = arr[mx + 1][my] = arr[mx + 1][my + 1] = 2;
            find(sx, sy, mx, my, mx, my); // 1
            find(sx, my + 1, mx, ey, tx, ty); // 2
            find(mx + 1, sy, ex, my, mx + 1, my); // 3
            find(mx + 1, my + 1, ex, ey, mx + 1, my + 1); // 4
        }

        else if ((tx >= mx + 1) && (tx <= ex) && (ty >= sy) && (ty <= my)) { // 3
            arr[mx][my] = arr[mx][my + 1] = arr[mx + 1][my + 1] = 3;
            find(sx, sy, mx, my, mx, my); // 1
            find(sx, my + 1, mx, ey, mx, my + 1); // 2
            find(mx + 1, sy, ex, my, tx, ty); // 3
            find(mx + 1, my + 1, ex, ey, mx + 1, my + 1); // 4
        }

        else if ((tx >= mx + 1) && (tx <= ex) && (ty >= my + 1) && (ty <= ey)) { // 4
            arr[mx][my] = arr[mx + 1][my] = arr[mx][my + 1] = 4;
            find(sx, sy, mx, my, mx, my); // 1
            find(sx, my + 1, mx, ey, mx, my + 1); //2
            find(mx + 1, sy, ex, my, mx + 1, my); //3
            find(mx + 1, my + 1, ex, ey, tx, ty); // 4
        }

    }

}

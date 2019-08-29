import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_3184_양 {
    static char[][] arr;
    static int[][] check;
    static int N;
    static int M;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int v_num = 0;
    static int o_num = 0;
    static int o;
    static int v;

    static Queue<Integer> qx = new LinkedList<Integer>();
    static Queue<Integer> qy = new LinkedList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new char[N][M];
        check = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                char temp = str.charAt(j);
                arr[i][j] = temp;
                if (temp == '#') {
                    check[i][j] = 1;
                }
                if (temp == 'o') {
                    o_num++;
                }
                if (temp == 'v') {
                    v_num++;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check[i][j] == 0) {
                    o = 0;
                    v = 0;
                    qx.add(i);
                    qy.add(j);
                    while (!qy.isEmpty()) {
                        find(qx.poll(), qy.poll());
                    }
                    if (v >= o) {
                        o_num = o_num - o;
                    } else {
                        v_num = v_num - v;
                    }

                }
            }

        }

        System.out.println(o_num + " " + v_num);

    }

    private static void find(int i, int j) {

        check[i][j] = 1;

        if (arr[i][j] == 'o')
            o++;
        if (arr[i][j] == 'v')
            v++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (check[nx][ny] == 0) {
                    qx.add(nx);
                    qy.add(ny);
                    check[nx][ny] = 1;
                }
            }
        }

    }

}
import java.util.Scanner;
 
public class SWEA_2806_NQueen {
    public static int N;
    public static int result;
    public static int[] col;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int t = 1; t <= testcase; t++) {
            result = 0;
            N = sc.nextInt();
            col = new int[N];
            nqueen(0); // i가 0일 때
            System.out.println("#" + t + " " + result);
        }
    }
 
    public static void nqueen(int i) {
        if (i == N) {
            result++;
            return;
        }
        for (int j = 0; j < N; j++) {
            col[i] = j;
            if (isPossible(i))
                nqueen(i + 1); // 다음칸으로 가도 되느냐 확인
        }
    }
 
    public static boolean isPossible(int level) {
        for (int i = 0; i < level; i++) {
            // level 위치에 현재 시험할 퀸이 놓여져 있는 상태이고
            // 우리는 그 퀸과 i= 0 ~ level-1 에 놓여있는 퀸이 문제를 일으키는지만 보면 된다.
 
            if (col[i] == col[level] || Math.abs(level - i) == Math.abs(col[level] - col[i])) {
                // i번째 퀸의 위치와 level위치의 퀸이 같은 일직선상에 있는경우
                // 또는
                // i번째 퀸의 위치와 level위치의 퀸이 대각선상에 있는 경우.
                // 밑변과 높이가 같으면 대각선상에 있다고 볼수 있다.
                return false;
                // 이 경우는 불가능 하므로 false를 리턴
            }
        }
        return true;
        // 위의 경우를 제외하면 가능하므로 true 리턴
    }
 
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행Buffer{
    static int r, c;
    static char[][] arr;
    static int[] visited;
    
    static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr = new char[r][c];
            // visited = new int[26];
            visited = new int['Z' + 1];
            /*
             * //A:65 , Z:90 => 이 사이의 index만 쓰는걸로 int cur = arr[0][0] - 'A'; => 이렇게 연산하는 시간을
             * 줄일랴면 그냥 배열을 크게 만드는게 이득
             */
            for (int i = 0; i < r; i++) {
                arr[i] = br.readLine().toCharArray(); // 한줄을 통째로
                /*
                 * String str = br.readLine(); for (int j = 0; j < c; j++) { arr[i][j] =
                 * str.charAt(j); }
                 */
            }
            visited[arr[0][0]]++;
            result = 1;
            dfs(0, 0, 1); // i,j,max

            sb.append('#').append(t).append(' ').append(result).append('\n');
        } // end of testcase
        System.out.print(sb);

    }// end of main

    private static void dfs(int i, int j, int max) {
        // 같은 구조라면 재귀함수보다 반복문이 더 빠르다
        // 재귀 : 깊이우선, 넓이우선, 가지치기 등을 자유롭게 할수 있다는 장점
        // 백트랙킹의 포커스는 가지치기
        if (max > result)
            result = max;
        if (result == 26)
            return;

        if (0 <= i - 1 && visited[arr[i - 1][j]] == 0) { // 상
            visited[arr[i - 1][j]]++;
            dfs(i - 1, j, max + 1);
            visited[arr[i - 1][j]]--;
        }
        if (i + 1 < r && visited[arr[i + 1][j]] == 0) { // 하
            visited[arr[i + 1][j]]++;
            dfs(i + 1, j, max + 1);
            visited[arr[i + 1][j]]--;
        }
        if (0 <= j - 1 && visited[arr[i][j - 1]] == 0) { // 상
            visited[arr[i][j - 1]]++;
            dfs(i, j - 1, max + 1);
            visited[arr[i][j - 1]]--;
        }
        if (j + 1 < c && visited[arr[i][j + 1]] == 0) { // 하
            visited[arr[i][j + 1]]++;
            dfs(i, j + 1, max + 1);
            visited[arr[i][j + 1]]--;
        }

    }// end of dfs

}
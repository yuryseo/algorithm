import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1082_화염에서탈출 {
	static int n, m, ans;
	static char[][] arr;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static Pair user, home;
	static ArrayList<Pair> fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		fire = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'D') {
					home = new Pair(i, j);
				} else if (arr[i][j] == 'S') {
					user = new Pair(i, j);
				} else if (arr[i][j] == '*') {
					Pair temp = new Pair(i, j);
					fire.add(temp);
				}
			}
		}

		func(); 

		if (ans == -1)
			System.out.println("impossible");
		else
			System.out.println(ans);
	}

	private static void func() {
		Queue<Pair> quser = new LinkedList<Pair>();
		Queue<Pair> qfire = new LinkedList<Pair>();

		quser.add(user);
		for (int i = 0; i < fire.size(); i++)
			qfire.add(fire.get(i));

		while (!quser.isEmpty()) {
			ans++;

			int size = quser.size();
			for (int i = 0; i < size; i++) {
				Pair temp = quser.poll();
				if (arr[temp.r][temp.c] == '*')
					continue;
				for (int j = 0; j < 4; j++) {
					int nr = temp.r;
					int nc = temp.c;
					nr += dir[j][0];
					nc += dir[j][1];
					if (nr < n && nc < m && nr >= 0 && nc >= 0 && (arr[nr][nc] == '.' || arr[nr][nc] == 'D')) {
						if (arr[nr][nc] == 'D')
							return; 
						arr[nr][nc] = 'S';
						quser.add(new Pair(nr, nc));
					}
				}
			} 

			int size2 = qfire.size();
			for (int i = 0; i < size2; i++) {
				Pair temp = qfire.poll();
				for (int j = 0; j < 4; j++) {
					int nr = temp.r;
					int nc = temp.c;
					nr += dir[j][0];
					nc += dir[j][1];
					if (nr < n && nc < m && nr >= 0 && nc >= 0 && arr[nr][nc] != 'X' && arr[nr][nc] != 'D'
							&& arr[nr][nc] != '*') {
						arr[nr][nc] = '*';
						qfire.add(new Pair(nr, nc));
					}
				}
			} 
		} 
		ans = -1;
	}

	static class Pair {
		int r;
		int c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

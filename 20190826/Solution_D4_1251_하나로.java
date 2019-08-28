import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {
	private static class Node implements Comparable<Node> {
		int x, y;
		double w;s

		Node(int x, int y, double w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
/*		public int compareTo(Node o) { 
			 return Integer.compare((int)this.w, (int)o.w);
		}	// 둘다 음수일때 언더플로우가 발생하지 않게.
*/		
		public int compareTo(Node o) { 
			if (this.w - o.w < 0)
				return -1;
			else if (this.w - o.w > 0)
				return 1;
			else
				return 0;
		}
	}

	static int n, vertex[][], parents[];
	static double rate;
	static double Sum;
	static ArrayList<Node> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			Sum = 0;
			list = new ArrayList<>();

			n = Integer.parseInt(br.readLine());
			vertex = new int[n + 1][2];

			parents = new int[n + 1];
			Arrays.fill(parents, -1);

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < n; i++) {
					vertex[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			rate = Double.parseDouble(br.readLine());

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double x = Math.abs(vertex[i][0] - vertex[j][0]);
					double y = Math.abs(vertex[i][1] - vertex[j][1]);
					list.add(new Node(i, j, ((x * x) + (y * y)) * rate));
				}
			}

			Collections.sort(list);

			int count = 0;

			int select = -1;
			while (count < n - 1) {
				select++;
				if (union(list.get(select).x, list.get(select).y)) {
					count++;
					Sum += list.get(select).w;
				}
			}
			System.out.printf("#%d %d\n", t, Math.round(Sum));
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0)
			return a;
		return parents[a] = find(parents[a]);
	}

}
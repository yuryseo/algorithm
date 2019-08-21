import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FreindEx_AdjacentNode {
	static class Node {
		int vertax;
		Node next;
		public Node(int vertax, Node next) {
			super();
			this.vertax = vertax;
			this.next = next;
		}
		public String toString() {
			return "Node [vertax=" + (char) (65 + vertax) + ", next=" + next + "]";
		}
	}

	static int N, C, Send1_result = 0, Send2_result = 0;
	static boolean[][] adjMatrix;
	static Node[] adjList;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		C = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		int from, to;
		adjMatrix = new boolean[N][N];
		adjList = new Node[N];
		check = new boolean[N];
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(in.readLine());
			from = st.nextToken().charAt(0) - 'A';
			to = st.nextToken().charAt(0) - 'A';
			adjMatrix[from][to] = adjMatrix[to][from] = true;
			adjList[from] = new Node(to, adjList[from]); // 이거 한줄이면 첫번째 노드로 삽입하는거.
			// 기존 헤드
			// 기존에 헤드가 물고있던것을 새로운 첫번쨰 노드에 줌
			adjList[to] = new Node(from, adjList[to]);
		}
		System.out.println((char) (goMatrix('A' - 'A') + 65));
		System.out.println((char) (goList('A' - 'A') + 65));
		check[0] = true;
		Send_dfs('A' - 'A', 0, "A");
		System.out.println("Send1_result : " + Send1_result);
		check = new boolean[N];
		Send_bfs('A' - 'A');
		System.out.println("Send2_result : " + Send2_result);
	}


	private static void Send_bfs(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(cur);
		check[cur] = true;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				cur = q.poll();
				for (Node curFriend = adjList[cur]; curFriend != null; curFriend = curFriend.next) {
					if (!check[curFriend.vertax]) {
						q.add(curFriend.vertax);
						check[curFriend.vertax] = true;
					}
				}
			}
			Send2_result++;
		}
	}

	private static void Send_dfs(int cur, int max, String str) {
		if (max > Send1_result) {
			Send1_result = max;
			System.out.println(str);
		}
		if (Send1_result == N - 1)
			return;

		for (Node curFriend = adjList[cur]; curFriend != null; curFriend = curFriend.next) {
			if (!check[curFriend.vertax]) {
				check[curFriend.vertax] = true;
				Send_dfs(curFriend.vertax, max + 1, str + " " + (char) (curFriend.vertax + 65));
				check[curFriend.vertax] = false;
			}
		}
	}

 

	private static int goList(int cur) {

		int max = 0, count = 0, MaxFreind = 0;
		// 인접리스트에는 친구밖에 안들어 있으니깐 if문이 필요없음
		for (Node curFriend = adjList[cur]; curFriend != null; curFriend = curFriend.next) { // A의 헤드부터 출발
			count = 0;
			for (Node temp = adjList[curFriend.vertax]; temp != null; temp = temp.next) {
				count++;
			}

			if (max < count) {
				max = count;
				MaxFreind = curFriend.vertax;
			}
			System.out.println((char) (curFriend.vertax + 65) + "의 친구의 수 :" + count);
		}
		return MaxFreind;
	}

 

	private static int goMatrix(int cur) {

		int max = 0, count = 0, MaxFreind = 0;
		for (int i = 0; i < N; i++) {
			if (adjMatrix[cur][i]) {
				count = 0;
				for (int j = 0; j < N; j++) {
					if (adjMatrix[i][j]) {
						count++;
					}

					if (max < count) {
						max = count;
						MaxFreind = i;
					}
				}
				System.out.println((char) (i + 65) + "의 친구의 수 :" + count);
			}
		}
		return MaxFreind;
	}
}
package com.ssafy.Adjacent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FreindEx2_Linkedlist {

	static int N, C;
	static boolean[][] adjMatrix;
	static LinkedList[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		C = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		int from, to;
		adjMatrix = new boolean[N][N];
		adjList = new LinkedList[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList();
		}
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(in.readLine());
			from = st.nextToken().charAt(0) - 'A';
			to = st.nextToken().charAt(0) - 'A';
			adjMatrix[from][to] = adjMatrix[to][from] = true;
			adjList[from].offer(to);
			adjList[to].offer(from);
		}
		System.out.println((char) (goList('A' - 'A') + 65));

	}

	private static int goList(int cur) {
		int max = 0, count = 0, MaxFreind = 0;
		
		int curFriend;
		for(int i=0; i<adjList[cur].size(); ++i) {
			curFriend = (Integer)adjList[cur].get(i);
			count=0;
			for (int j = 0; j < adjList[curFriend].size(); j++) count++;
			if (max < count) {
				max = count;
				MaxFreind = curFriend;
			}
			System.out.println((char) (curFriend + 65) + "의 친구의 수 :" + count);
		}
		return MaxFreind;
	}
}
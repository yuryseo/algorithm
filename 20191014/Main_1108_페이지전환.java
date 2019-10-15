import java.util.Arrays;
import java.util.Scanner;

public class Main_1108_페이지전환 {

	private static int max;
	private static int[][] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int INF = 987654321;
		int[][] arr = new int[t][2];
		int a, b;
		max = 0;
		for (int i = 0; i < t; i++) {

			a = sc.nextInt();
			b = sc.nextInt();
			arr[i][0] = a;
			arr[i][1] = b;
			if (a > max)
				max = a;
			if (b > max)
				max = b;
		}

		adj = new int[max + 1][max + 1];
		for (int i = 0; i < max + 1; i++) {
			Arrays.fill(adj[i], INF);
		}
		for (int i = 0; i < t; i++) {
			adj[arr[i][0]][arr[i][1]] = 1;
		}

		FloydWarshall();
		double sum = 0;
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= max; j++) {
				if(i==j)continue;
				sum+=adj[i][j];
			}
		}
		
		sum=sum/(max*(max-1));

		System.out.printf("%.3f",sum);
		//System.out.print(Math.round(sum*1000)/1000.0);
		
	}

	private static void FloydWarshall() {

		for (int k = 1; k <= max; k++) {	//거쳐가는 노드
			for (int i = 1; i <= max; i++) {	//출발노드
				for (int j = 1; j <= max; j++) {	//도착노드

					 if(adj[i][k]+adj[k][j]<adj[i][j]) {
						 adj[i][j] = adj[k][j]+adj[i][k];
					 }
					
					
				}
			}
		}
		
		
	}

}

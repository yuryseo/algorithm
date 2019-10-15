import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1786_찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		int tLength = T.length, pLength = P.length;
		int[] fail = new int[pLength];

		// 실패함수 만들기 : P에서 P을 찾는 형태로...
		// 해당 부분문자열의 최대접미사의 길이
		for (int i = 1, j = 0; i < pLength; ++i) { // i:접미사포인터, j:접두사포인터

			// j위치에 틀리면 j-1위치까지는 맞았다는 이야기
			// fail[j-1] : j-1위치까지 일치하는 접미사의 길이 ==> 이동해야하는 다음 비교 j위치
			while (j > 0 && P[i] != P[j])
				j = fail[j - 1];

			if (P[i] == P[j])
				fail[i] = ++j;
		}

		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		// i: 텍스트포인터, j:패턴포인터
		// i는 계속 증가하는 형태
		for (int i = 0, j=0; i < tLength; ++i) {

			while(j>0 && T[i] != P[j]) j = fail[j-1];
			
			if(T[i] == P[j]) {
				if(j == pLength-1) { // 패턴의 끝까지 일치
					cnt++;
					//System.out.println(i-pLength+2);
					list.add(i-pLength+2);
					j = fail[j];
				}else {
					++j;
				}
			}
		}
		
		System.out.println(cnt);
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		
		
		
	}

}

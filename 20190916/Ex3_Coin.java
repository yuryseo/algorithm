import java.util.Scanner;

public class Ex3_Coin {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D =  new int[money+1];	//각 금액을 만들 수 있는 최소동전갯수 저장
		int min;
		
		for (int i = 1; i <= money; i++) {
			min = Integer.MAX_VALUE;
			if(i>=1 && D[i-1]+1<min) min = D[i-1]+1;
			if(i>=4 && D[i-4]+1<min) min = D[i-4]+1;
			if(i>=6 && D[i-6]+1<min) min = D[i-6]+1;
			D[i] = min;
		}

	}

}

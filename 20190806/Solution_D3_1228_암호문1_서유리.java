import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_1228_암호문1_서유리 {

	public static void main(String[] args) {
		LinkedList<Integer> list;
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t < 11; t++) {

			list = new LinkedList<>();
			int num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				list.add(sc.nextInt());
			}
			
			num = sc.nextInt();
			for (int i = 0; i < num; i++) {
				String str = sc.next();
				int where = sc.nextInt();
				int count = sc.nextInt();
				for (int j = 0; j < count; j++) {
					list.add(where, sc.nextInt());
					where++;
				}
			}
			System.out.print("#" + t + " ");
			for(int i=0;i<10;i++) {
				System.out.print(list.poll()+" ");
			}
			System.out.println();
		}
	}

}

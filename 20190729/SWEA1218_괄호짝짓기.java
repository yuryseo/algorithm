import java.util.Scanner;
import java.util.Stack;

public class SWEA1218_°ýÈ£Â¦Áþ±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();

		for (int t = 1; t <= 10; t++) {
			stack.clear();
			int num = sc.nextInt();
			String str = sc.next();
			int[] count = new int[8];
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (str.charAt(i) == '>' && stack.peek() == '<') {
					stack.pop();
				} else if (str.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (str.charAt(i) == '}' && stack.peek() == '{') {
					stack.pop();
				}else {
					break;
				}
			}
			if (stack.isEmpty()) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}

		}

	}

}

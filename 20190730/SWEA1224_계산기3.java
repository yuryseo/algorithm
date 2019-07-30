
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class SWEA1224_°è»ê±â3 {
	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(in.readLine());
			Stack<Character> s = new Stack<Character>();
			Stack<Integer> num = new Stack<Integer>();
			String tmp = in.readLine();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				char c = tmp.charAt(i);
				switch (c) {
				case '(':
					s.push(c);
					break;
				case '*':
					while (!s.isEmpty() && (s.peek() == '*')) {
						sb.append(s.pop());
					}
					s.push(c);
					break;
				case '+':
					while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '+')) {
						sb.append(s.pop());
					}
					s.push(c);
					break;
				case ')':
					while (!s.isEmpty() && s.peek() != '(') {
						sb.append(s.pop());
					}
					if (s.peek() == '(') {
						s.pop();
					}
					break;
				default:
					sb.append(c);
					break;
				}
			}

			while (!s.isEmpty()) {
				sb.append(s.pop());
			}

			for (int j = 0; j < sb.length(); j++) {
				char c = sb.charAt(j);
				int num1, num2;
				switch (c) {
				case '+':
					num2 = num.pop();
					num1 = num.pop();
					num.push(num1 + num2);
					break;

				case '*':
					num2 = num.pop();
					num1 = num.pop();
					num.push(num1 * num2);
					break;

				default:
					num.push((int) (c - '0'));
					break;
				}
			}
			System.out.println("#" + t + " " + num.pop());
		}
	}
}

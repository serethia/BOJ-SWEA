import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char curr = str.charAt(j);
				if (stack.size() > 0 && curr == stack.peek()) {
					stack.pop();
				} else {
					stack.push(curr);
				}
			}
			if (stack.isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()); // 1 ~ 100,000
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0) {
				stack.pop();
			} else {
				stack.push(number);
			}
		}
		long ans = 0; // 최대 약 2^31
		for (int nums : stack) {
			ans += nums;
		}
		sb.append(ans);
		System.out.println(sb);
	}
}
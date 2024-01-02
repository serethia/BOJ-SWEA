import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 1 ~ 100,000
		int[] input = new int[n + 1];
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < n + 1; i++) {
			input[i] = Integer.parseInt(br.readLine()); // 입력 수열
		}

		int idx = 1;
		for (int i = 1; i < n + 1; i++) { // 오름차순
			stack.push(i);
			sb.append("+").append('\n');
			while (!stack.isEmpty() && stack.peek() == input[idx]) { // pop할 숫자가 수열의 숫자면
				stack.pop();
				if (idx == n) { // 마지막 출력 개행 X
					sb.append("-");
				} else {
					sb.append("-").append('\n');
				}
				idx++; // 그 다음 수열의 숫자로
			}
		}

		if (stack.isEmpty()) { // 모두 pop했으면
			System.out.println(sb);
		} else { // 해당 수열이 아니었으면
			System.out.println("NO");
		}
	}
}
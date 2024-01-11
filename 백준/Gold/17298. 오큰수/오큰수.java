import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 1 ~ 80,000
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> cmpstack = new Stack<Integer>(); // 입력값 역순 저장
		Stack<Integer> ansstack = new Stack<Integer>(); // 출력값 역순 저장
		cmpstack.push(input[n - 1]); // 시작점
		ansstack.push(-1); // 시작 출력값
		for (int i = n - 2; i >= 0; i--) {
			int curr = input[i];
			while (!cmpstack.isEmpty()) {
				int top = cmpstack.peek();
				if (top > curr) {
					ansstack.push(top);
					break;
				} else {
					cmpstack.pop();
				}
			}
			if (cmpstack.isEmpty()) {
				ansstack.push(-1);
			}
			cmpstack.push(curr);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			while (!ansstack.isEmpty()) {
				sb.append(ansstack.pop());
				if (i < n - 1) {
					sb.append(" ");
				}
			}
		}
		System.out.println(sb);
	}
}
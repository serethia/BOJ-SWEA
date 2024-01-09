import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 탑의 수: 1 ~ 500,000
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(st.nextToken()); // 현재 높이: 1 ~ 100,000,000
			if (stack.isEmpty()) {
				sb.append(0);
			} else {
				cycle: for (int j = 0; j < n; j++) {
					while (!stack.isEmpty()) {
						int[] top = stack.peek(); // 스택 맨 위의 높이
						if (top[1] > curr) { // 높이: 스택 맨 위 > 현재
							sb.append(top[0]); // 스택 맨 위 인덱스 출력
							break cycle;
						} else { // 높이: 스택 맨 위 < 현재
							stack.pop(); // 스택 맨 위 빼내기
						}
						if (stack.isEmpty()) {
							sb.append(0);
							break cycle;
						}
					}
				}
			}
			stack.push(new int[] { i + 1, curr }); // [0]: 번호, [1]: 높이
			if (i < n - 1) { // 사이에만 공백
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
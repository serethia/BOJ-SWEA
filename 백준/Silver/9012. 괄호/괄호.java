import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 입력값 줄 수
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			String ans = "YES"; // 올바른 괄호쌍이라고 가정 = 출력값
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char curr = str.charAt(j);
				if (curr == '(') {
					stack.push(curr); // '('만 골라 넣기
				} else { // ')'면
					if (stack.isEmpty()) { // 빼낼 '(' 없으면
						ans = "NO"; // 출력값: no
						break; // 해당 줄 탐색 종료
					}
					stack.pop(); // '(' 1개 빼서 괄호쌍 완성
				}
			}
			if (!stack.isEmpty()) { // '('가 남았으면
				ans = "NO"; // 출력값: no
			}
			sb.append(ans).append('\n');
			stack.clear(); // 다음 줄 가기 전에 스택 비우기
		}
		System.out.println(sb);
	}
}
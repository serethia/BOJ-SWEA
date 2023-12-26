import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 첫 줄 읽기
		StringBuilder sb = new StringBuilder();
		boolean start = true; // 첫 줄인지 여부
		while (!str.equals(".")) { // 마지막 온점이 나오면 종료
			if (start) {
				start = false;
			} else { // 한 줄씩 출력하되 마지막 줄은 개행 X
				sb.append('\n');
			}
			String ans = "yes";
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char letter = str.charAt(i);
				if (letter == '(' || letter == '[') {
					stack.push(letter);
				} else if (letter == ')') {
					if (stack.isEmpty() || stack.pop() == '[') { // 맞는 짝이 없다면
						ans = "no";
						break;
					}
				} else if (letter == ']') {
					if (stack.isEmpty() || stack.pop() == '(') { // 맞는 짝이 없다면
						ans = "no";
						break;
					}
				}
			}
			if (!stack.isEmpty()) { // 남은 괄호 짝이 있다면
				ans = "no";
			}
			sb.append(ans); // yes 혹은 no를 sb에 추가
			str = br.readLine(); // 다음 줄 읽기
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		for (int i = str.length() - 1; i >= 0; i--) { // 출력을 위해 역순 push
			stack.push(str.charAt(i));
			boolean explode = true; // 폭발 가능 여부
			// IndexOutOfBounds (런타임에러) => 스택 크기 고려 안 하고 뽑아서
			if (stack.peek() == bomb.charAt(0) && stack.size() >= bomb.length()) { // 꼭대기가 bomb 첫 글자와 같을 시
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - 1 - j) != bomb.charAt(j)) { // 하나라도 다르면
						explode = false; // 안 터짐
						break;
					}
				}
				if (explode) { // 터진다면
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop(); // 터진 bomb만큼 빼내기
					}
				}
			}
		}
		sb = new StringBuilder();
		if (stack.size() == 0) { // 남은 게 없으면
			System.out.println("FRULA");
		} else {
			while (!stack.isEmpty()) {
				sb.append(stack.pop()); // 남은 거 모두 출력
			}
			System.out.println(sb);
		}
	}
}
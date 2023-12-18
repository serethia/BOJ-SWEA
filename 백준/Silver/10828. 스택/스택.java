import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택을 배열로 구현 (맨 위 값 = 맨 나중에 넣은 값)
public class Main {
	static int[] stack;
	static int idx = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stack = new int[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			// 명령에 따라 다른 결과 반환
			if (str.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				push(num);
			}
			if (str.equals("pop")) {
				sb.append(pop());
				if (i < n - 1) { // 마지막 번째는 개행 없음
					sb.append('\n');
				}
			}
			if (str.equals("size")) {
				sb.append(size());
				if (i < n - 1) {
					sb.append('\n');
				}
			}
			if (str.equals("empty")) {
				sb.append(empty());
				if (i < n - 1) {
					sb.append('\n');
				}
			}
			if (str.equals("top")) {
				sb.append(top());
				if (i < n - 1) {
					sb.append('\n');
				}
			}
		}
		System.out.println(sb);
	}

	public static void push(int x) { // 정수 x 넣기
		stack[idx++] = x; // push: idx값 변하게
	}

	public static int pop() { // 맨 위 값 *빼고* 출력, 없으면 -1 출력
		int popval = top();
		if (idx > 0) {
			stack[idx] = 0; // 현재 idx번째 값 *빼기* = 0으로 초기화
			idx--; // pop: idx값 변하게
		}
		return popval;
	}

	public static int size() { // 들어있는 개수 출력
		return idx;
	}

	public static int empty() { // 비었으면 1, 아니면 0 출력
		if (idx == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int top() { // 맨 위 값 출력, 없으면 -1 출력
		if (idx <= 0) {
			return -1;
		}
		return stack[idx - 1]; // top: idx값 일정하게
	}
}
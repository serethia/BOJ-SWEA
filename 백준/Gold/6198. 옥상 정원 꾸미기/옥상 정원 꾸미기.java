import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 1 ~ 80,000
		int[] height = new int[n];
		for (int i = 0; i < n; i++) { // 1 ~ 1,000,000,000
			height[i] = Integer.parseInt(br.readLine());
		}

		long cnt = 0; // 벤치마킹 가능 수의 합 (int 초과)
		Stack<Integer> stack = new Stack<>();
		stack.push(height[0]); // 시작 값 대입
		for (int i = 1; i < n; i++) {
			int curr = height[i]; // 현재 관리인 건물
			while (!stack.isEmpty() && stack.peek() <= curr) { // 오른쪽 건물과 비교
				stack.pop(); // 옥상을 볼 수 있는 건물 모두 pop
			}
			stack.push(curr);
			cnt += (stack.size() - 1);
		}
		System.out.println(cnt);
	}
}
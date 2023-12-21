import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덱: 배열로 구현
public class Main {
	static int[] deque;
	static int idx; // 맨 앞
	static int jdx; // 맨 뒤

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		idx = n;
		jdx = n + 1;
		deque = new int[2 * n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if (str.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				push_front(num);
			}
			if (str.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				push_back(num);
			}
			if (str.equals("pop_front")) {
				sb.append(pop_front());
				if (i < n - 1) {
					sb.append('\n');
				}
			}
			if (str.equals("pop_back")) {
				sb.append(pop_back());
				if (i < n - 1) {
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
			if (str.equals("front")) {
				sb.append(front());
				if (i < n - 1) {
					sb.append('\n');
				}
			}
			if (str.equals("back")) {
				sb.append(back());
				if (i < n - 1) {
					sb.append('\n');
				}
			}
		}
		System.out.println(sb);
	}

	public static void push_front(int x) { // 앞에 x 넣기
		deque[idx--] = x;
	}

	public static void push_back(int x) { // 뒤에 x 넣기
		deque[jdx++] = x;
	}

	public static int pop_front() { // 맨 앞 *빼고* 출력, 없으면 -1 출력
		int first = front();
		if (size() > 0) {
			deque[idx + 1] = 0;
			idx++;
		}
		return first;
	}

	public static int pop_back() { // 맨 뒤 *빼고* 출력, 없으면 -1 출력
		int last = back();
		if (size() > 0) {
			deque[jdx - 1] = 0;
			jdx--;
		}
		return last;
	}

	public static int size() { // 개수 출력
		return jdx - idx - 1;
	}

	public static int empty() { // 비었으면 1, 아니면 0 출력
		if (size() == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static int front() { // 맨 앞 출력, 없으면 -1 출력
		if (size() == 0) {
			return -1;
		}
		return deque[idx + 1];
	}

	public static int back() { // 맨 뒤 출력, 없으면 -1 출력
		if (size() == 0) {
			return -1;
		}
		return deque[jdx - 1];
	}
}
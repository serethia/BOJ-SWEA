import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1~n 저장
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		// 0명 될 때까지 k번째 제거 => 제거 순서 출력: <0, 0, 0, 0> 형태
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while (!q.isEmpty()) {
			for (int j = 1; j <= k; j++) {
				if (q.size() == 1) { // 마지막 순서면 ', ' 없애고 출력
					sb.append(q.poll());
					break; // 종료 안 하면 null이 뜸
				} else {
					if (j == k) { // k번째면 빼고 ', ' 포함해 출력
						sb.append(q.poll()).append(',').append(' ');
					} else { // k번째가 아니면 빼자마자 큐에 다시 집어넣기
						q.offer(q.poll());
					}
				}
			}
		}
		sb.append('>');
		System.out.println(sb);
	}
}
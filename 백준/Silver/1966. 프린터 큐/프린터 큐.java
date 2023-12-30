import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테케 수
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문서 수
			int m = Integer.parseInt(st.nextToken()); // 알고 싶은 문서 처음 위치
			LinkedList<int[]> q = new LinkedList<>(); // [중요도, 처음 위치]
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				q.offer(new int[] { Integer.parseInt(token.nextToken()), i }); // 한 쌍씩 넣기
			}

			int cnt = 0;
			while (q.size() > 0) {
				int[] compare = q.poll(); // 맨 앞

				boolean flag = true; // 가장 큰 수가 아니면 false: 맨 뒤로
				for (int i = 0; i < q.size(); i++) {
					if (compare[0] < q.get(i)[0]) { // 더 큰 중요도가 있다면
						q.offer(compare); // 맨 뒤로
						for (int j = 0; j < i; j++) { // 그 값 도달까지 맨 뒤로
							q.offer(q.poll());
						}
						flag = false;
						break;
					}
				}
				if (!flag) { // 최대값 찾을 때까지
					continue;
				}

				cnt++; // true: 카운트 up

				if (compare[1] == m) { // 찾던 값이면 종료
					break;
				}
			}
			sb.append(cnt);
			if (tc < t) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
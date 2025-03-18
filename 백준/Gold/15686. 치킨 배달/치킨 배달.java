import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m; // 골라야 할 최대 치킨집 수
	static int[][] map; // 0: 공백, 1: 집, 2: 치킨집
	static int ans; // 치킨 거리 (x축 거리 차 + y축 거리 차: 집 ~ 치킨집)
	static ArrayList<int[]> h = new ArrayList<>(); // 집 좌표
	static ArrayList<int[]> c = new ArrayList<>(); // 치킨집 좌표
	static boolean[] visited; // 방문 여부

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n]; // n*n
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					h.add(new int[] { i, j });
				}
				if (map[i][j] == 2) {
					c.add(new int[] { i, j });
				}
			}
		}

		// 백트래킹
		ans = Integer.MAX_VALUE;
		visited = new boolean[c.size()]; // 치킨집 수만큼
		search(0, 0);

		// 최소 치킨 거리 출력
		System.out.println(ans);
	}

	static void search(int num, int st) { // num: 고른 치킨집 수, st: 시작점
		if (num == m) {
			// 최소 거리 계산
			int sum = 0;
			for (int i = 0; i < h.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < c.size(); j++) {
					if (visited[j]) {
						int tmp = Math.abs(c.get(j)[0] - h.get(i)[0]) + Math.abs(c.get(j)[1] - h.get(i)[1]);
						min = Math.min(min, tmp);
					}
				}
				sum += min;
			}
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = st; i < c.size(); i++) {
			visited[i] = true;
			search(num + 1, i + 1);
			visited[i] = false;
		}

	}
}
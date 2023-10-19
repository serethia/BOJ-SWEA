import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r, ord;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] depths;
	static int[] orders;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		n = Integer.parseInt(s.nextToken());
		m = Integer.parseInt(s.nextToken());
		r = Integer.parseInt(s.nextToken());
		visited = new boolean[n + 1];
		depths = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			depths[i] = -1;
		}
		orders = new int[n + 1];
		ord = 0;
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(s.nextToken());
			int ed = Integer.parseInt(s.nextToken());
			list.get(st).add(ed);
			list.get(ed).add(st);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(list.get(i));
		}

		bfs(r, 0);

		long ans = 0;
		for (int i = 1; i < n + 1; i++) {
			ans += (long) depths[i] * orders[i];
		}
		System.out.println(ans);
	}

	public static void bfs(int r, int depth) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(r);
		visited[r] = true;
		orders[r] = ++ord;
		while (!q.isEmpty()) {
			for (int s = q.size(); s > 0; s--) { // 큐 사이즈가 0이 될 때까지 돌고 나서
				int curr = q.poll();
				depths[curr] = depth;
				for (int i = 0; i < list.get(curr).size(); i++) {
					int next = list.get(curr).get(i);
					if (!visited[next]) {
						q.offer(next);
						visited[next] = true;
						orders[next] = ++ord;
					}
				}
			}
			depth++; // 깊이 + 1
		}
	}

}
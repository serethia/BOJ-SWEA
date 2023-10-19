import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
		ord = 1;

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
			Collections.sort(list.get(i), Collections.reverseOrder());
		}

		dfs(r, 0);

		long ans = 0;
		for (int i = 1; i < n + 1; i++) {
			ans += (long) depths[i] * orders[i];
		}

		System.out.println(ans);

	}

	public static void dfs(int r, int depth) {
		visited[r] = true;
		depths[r] = depth;
		orders[r] = ord++;
		for (int i = 0; i < list.get(r).size(); i++) {
			int curr = list.get(r).get(i);
			if (!visited[curr]) {
				dfs(curr, depth + 1);
			}
		}
	}

}
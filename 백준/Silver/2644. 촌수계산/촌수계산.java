import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int n, a, b, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			list.get(end).add(start);
		}

		ans = -1;
		dfs(a, 0);
		System.out.println(ans);
	}

	public static void dfs(int i, int cnt) {
		if (i == b) {
			ans = cnt;
			return;
		}

		visited[i] = true;
		for (int idx = 0; idx < list.get(i).size(); idx++) {
			int curr = list.get(i).get(idx);
			if (!visited[curr]) {
				dfs(curr, cnt + 1);
			}
		}
	}
}

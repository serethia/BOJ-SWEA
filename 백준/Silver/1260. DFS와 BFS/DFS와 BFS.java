import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int n, m, v;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken()); // 시작점

		// 초기화
		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}

		// 간선 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			list.get(end).add(start);
		}

		// 작은 번호부터 정렬
		for (int i = 0; i < n + 1; i++) {
			Collections.sort(list.get(i));
		}

		// DFS
		sb = new StringBuilder();
		visited = new boolean[n + 1];
		dfs(v);

		// BFS
		sb.append('\n');
		visited = new boolean[n + 1];
		bfs(v);

		System.out.println(sb);
	}

	public static void dfs(int idx) {
		sb.append(idx).append(" ");
		visited[idx] = true;
		for (int i = 0; i < list.get(idx).size(); i++) {
			if (!visited[list.get(idx).get(i)]) {
				dfs(list.get(idx).get(i));
			}
		}
	}

	public static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(idx);
		visited[idx] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for (int i = 0; i < list.get(curr).size(); i++) {
				if (!visited[list.get(curr).get(i)]) {
					q.add(list.get(curr).get(i));
					visited[list.get(curr).get(i)] = true;
				}
			}
		}
	}
}

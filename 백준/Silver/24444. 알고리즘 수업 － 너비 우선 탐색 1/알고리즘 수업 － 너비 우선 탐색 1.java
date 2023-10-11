import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int r;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static int[] order;
	static int or;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Scanner: 시간 초과
		StringTokenizer s = new StringTokenizer(br.readLine());
		n = Integer.parseInt(s.nextToken()); // 정점수
		m = Integer.parseInt(s.nextToken()); // 간선수
		r = Integer.parseInt(s.nextToken()); // 시작점
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>()); // 초기화 (무조건 0부터)
		}
		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(s.nextToken());
			int ed = Integer.parseInt(s.nextToken());
			list.get(st).add(ed);
			list.get(ed).add(st); // 무방향
		}
		for (int i = 1; i < list.size(); i++) {
			Collections.sort(list.get(i)); // 인접리스트 오름차순
		}
		visited = new boolean[n + 1];
		order = new int[n + 1]; // 순서 저장
		or = 1; // 순서 변수

		bfs(r);

		for (int i = 1; i < n + 1; i++) {

			System.out.println(order[i]);
		}
	}

	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		order[i] = or; // 시작점 순서 = 1
		visited[i] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int j = 0; j < list.get(curr).size(); j++) {
				int next = list.get(curr).get(j);
				if (!visited[next]) {
					q.add(next);
					order[next] = ++or; // 순서+1
					visited[next] = true;
				}
			}
		}
	}
}
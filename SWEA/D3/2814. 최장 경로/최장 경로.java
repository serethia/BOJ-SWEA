import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int maxlen;
	static List<Integer>[] nodelist; // 인접리스트 연습
	static boolean[] visited;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt(); // 1~n번 정점의 간선 정보 x,y
			int m = sc.nextInt(); // 간선 총 개수인 m줄에 걸쳐서 입력값
			nodelist = new ArrayList[n + 1]; // 0번 안 씀, 1~n번까지
			for (int i = 0; i < n + 1; i++) {
				nodelist[i] = new ArrayList<>(); // 초기화 필수!
			}

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				nodelist[x].add(y);
				nodelist[y].add(x); // 무방향
			}

			maxlen = Integer.MIN_VALUE;
			for (int i = 1; i < n + 1; i++) { // 시작 지점 탐색
				visited = new boolean[n + 1];
				visited[i] = true; // 시작 지점 방문 완료
				dfs(i, 1); // 최장 경로 = 경로에 존재하는 정점 수 (최소 cnt=1), 재귀 끝나면 cnt 1로 초기화
			}

			System.out.println("#" + tc + " " + maxlen);
		}
	}

	public static void dfs(int i, int cnt) { // 재귀로 DFS 구현
		maxlen = Math.max(maxlen, cnt);

		for (int j = 0; j < nodelist[i].size(); j++) { // i번째 배열 j번째 정점으로 재귀를 통해 이동
			int next = nodelist[i].get(j); // i번째 배열의 j번째 정점 임시 저장
			if (!visited[next]) { // 재방문하지 않음
				visited[next] = true;
				dfs(next, cnt + 1); // 인접한 경우 cnt++
				visited[next] = false;
			}
		}
	}
}
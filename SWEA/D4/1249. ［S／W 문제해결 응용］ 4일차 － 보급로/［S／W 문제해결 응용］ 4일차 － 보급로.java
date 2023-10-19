import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우 델타

	static class Node implements Comparable<Node> { // compareTo 메서드 사용 시 implements Comparable 필수
		int x, y, depth;

		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

		public int compareTo(Node o) { // 우선순위 큐 내부에서 비교하기 위해 필요
			return Integer.compare(this.depth, o.depth);
		}
	}

	public static void main(String[] args) {// 좌상단 출발, 우하단 도착. 지도 크기는 n*n. 지도는 string으로 받아서 하나씩 끊어 저장해야
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테케
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 지도 한 변 길이
			int[][] map = new int[n][n]; // 지도 깊이 정보 저장
			for (int r = 0; r < n; r++) {
				String str = sc.next();
				for (int c = 0; c < n; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}

			PriorityQueue<Node> q = new PriorityQueue<>(); // 우선순위 큐
			boolean[][] visited = new boolean[n][n]; // 방문 처리 배열
			int[][] dist = new int[n][n]; // 최단 거리 배열
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					dist[r][c] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = 0;
			q.add(new Node(0, 0, dist[0][0])); // 시작 정점 큐에 넣기

			while (!q.isEmpty()) { // 다익스트라
				Node curr = q.poll();
				visited[curr.x][curr.y] = true;
				if (curr.x == n - 1 && curr.y == n - 1)
					break; // 도착 지점 도달 시 종료
				for (int d = 0; d < 4; d++) { // 델타 이용
					int nr = curr.x + dr[d];
					int nc = curr.y + dc[d];
					if (nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue; // 경계조건
					if (!visited[nr][nc] && dist[nr][nc] > map[nr][nc] + dist[curr.x][curr.y]) { // 더 작은 값이면 갱신
						dist[nr][nc] = map[nr][nc] + dist[curr.x][curr.y]; // 최단 거리 갱신
						q.add(new Node(nr, nc, dist[nr][nc])); // 방문 안 한 노드 큐에 넣기
					}
				}
			}
			System.out.println("#" + tc + " " + dist[n - 1][n - 1]);
		}
	}
}
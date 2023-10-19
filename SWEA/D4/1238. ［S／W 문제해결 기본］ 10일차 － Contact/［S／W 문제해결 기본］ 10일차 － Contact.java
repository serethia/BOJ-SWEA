import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int doublee = sc.nextInt(); // 간선 수의 2배니까 'double e'
			int start = sc.nextInt(); // 시작 정점
			
			int[][] connect = new int[101][101]; // 1~100번
			boolean[] visited = new boolean[101];
			
			for (int i = 1; i <= doublee / 2; i++) { // 간선 저장
				int st = sc.nextInt();
				int ed = sc.nextInt();
				connect[st][ed] = 1;
			}

			Queue<Integer> q = new LinkedList<>();
			q.offer(start); // 시작 정점 넣기
			visited[start] = true;
			int[] depth = new int[101]; // 각 정점의 깊이 저장
			depth[start] = 0;
			int maxdepth = Integer.MIN_VALUE; // 최대 깊이 => 최종 정점
			int max = Integer.MIN_VALUE; // 출력할 최대 번호
			
			while (!q.isEmpty()) {
				int curr = q.poll();
				for (int i = 1; i <= 100; i++) {
					if (!visited[i] && connect[curr][i] == 1) { // 연결된 미방문 정점이면
						q.offer(i);
						depth[i] = depth[curr] + 1;
						visited[i] = true;
					}
				}
			}
			
			for (int i = 1; i <= 100; i++) {
				maxdepth = Math.max(maxdepth, depth[i]);
				if (depth[i] == maxdepth) {
					max = Math.max(max, i);
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
}
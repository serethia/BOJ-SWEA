import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] connect;
	static boolean[] visited;
	static int v;
	static int e;
	static int cnt;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt(); // 컴퓨터 수
		e = sc.nextInt(); // 간선 수
		connect = new int[v + 1][v + 1]; // 간선 정보 저장
		visited = new boolean[v + 1]; // 0번 정점 없음 = v+1
		for (int i = 1; i <= e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			connect[a][b] = connect[b][a] = 1; // 무향
		}
		q = new LinkedList<>(); // 큐 생성
		cnt = 0; // 감염 전파된 컴퓨터 수
		spread(1); // 1번에서 감염 시작
		System.out.println(cnt);
	}

	public static void spread(int x) {
		q.offer(x); // 현재 정점 넣기
		while (!q.isEmpty()) { // 큐 빌 때까지 반복
			int curr = q.poll(); // 현재 정점 빼기
			visited[curr] = true; // 방문 처리
			for (int j = 1; j <= v; j++) {
				if (connect[curr][j] > 0 && !visited[j]) { // 미방문+연결 정점이면
					visited[j] = true; // 방문 처리
					q.offer(j); // 연결 정점 넣기
					cnt++; // 카운트+1
				}
			}
		}
	}
}
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution { // 프림으로 재풀이
	static class Node implements Comparable<Node> { // compareTo 메서드 사용 시 implements Comparable 필수
		int st, ed;
		double w; // double 주의
		public Node(int st, int ed, double w) { // double 주의
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		public int compareTo(Node o) { // 우선순위 큐 내부에서 비교하기 위해 필요
			return Double.compare(this.w, o.w); // double 주의
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테케
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 정점 (섬) 개수
			double[][] where = new double[n][2]; // [0] x좌표, [1] y좌표 입력값 저장할 배열
			for (int i = 0; i < n; i++) {
				where[i][0] = sc.nextDouble(); // x좌표
			}
			for (int i = 0; i < n; i++) {
				where[i][1] = sc.nextDouble(); // y좌표
			}
			double rate = sc.nextDouble(); // 곱해줄 세율

			List<Node>[] list = new ArrayList[n]; // 인접 리스트
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<>(); // 내부에 또 리스트 생성
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) { // 차례로 st, ed, w => 무향이므로 w는 동일하게 저장
					list[i].add(new Node(i, j,
							Math.pow((where[i][0] - where[j][0]), 2) + Math.pow((where[i][1] - where[j][1]), 2)));
					list[j].add(new Node(j, i,
							Math.pow((where[i][0] - where[j][0]), 2) + Math.pow((where[i][1] - where[j][1]), 2)));
				}
			}

			PriorityQueue<Node> q = new PriorityQueue<>(); // 우선순위 큐
			boolean[] visited = new boolean[n]; // 방문 처리 배열
			visited[0] = true; // 시작 정점 방문 처리
			for (Node x : list[0]) {
				q.add(x); // forEach 연습_시작 정점과 연결된 노드 정보 모두 우선순위 큐에 넣기
			}

			double cnt = 1; // 뽑은 정점 수 (n개가 최대)
			double tax = 0; // 거리 제곱 누적합 = 환경 부담금
			while (cnt < n) {
				Node curr = q.poll();
				if (!visited[curr.ed]) { // 방문 안 했을 때만 아래 과정 진행
					tax += curr.w;
					q.addAll(list[curr.ed]); // addAll 연습_방문 안 한 모든 노드 정보 우선순위 큐에 넣기
					visited[curr.ed] = true; // 방문 처리
					cnt++; // 뽑은 정점 수 증가
				}
			}
			System.out.println("#" + tc + " " + Math.round(tax * rate)); // 첫째 자리에서 반올림
		}
	}
}
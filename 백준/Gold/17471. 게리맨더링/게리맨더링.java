import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int ans;
	static int[] area;
	static int[] people;
	static ArrayList<ArrayList<Integer>> list; // Node 클래스 삭제 후 Integer로 타입 전환해 봄

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 구역 개수
		ans = Integer.MAX_VALUE; // 출력할 최소값
		people = new int[n + 1]; // 인구 수: 1번부터 n번까지
		for (int i = 1; i <= n; i++) {
			people[i] = sc.nextInt();
		}

		list = new ArrayList<>(); // 1번부터 n번까지
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>()); // 초기화
		}

		for (int i = 1; i <= n; i++) {
			int neighbor = sc.nextInt(); // 연결 구역 수

			for (int j = 0; j < neighbor; j++) {
				int to = sc.nextInt(); // 연결 구역 번호
				list.get(i).add(to); // new Node 대신 to를 추가
			}
		}

		area = new int[n + 1]; // 선거구 번호 (A:1, B:2)
		district(1); // 부분집합

		if (ans == Integer.MAX_VALUE) { // ans값 그대로면 -1 출력
			System.out.println(-1);
		} else { // ans값 최소값으로 갱신되었으면 그 값 출력
			System.out.println(ans);
		}

	}

	public static void district(int sidx) { // area의 인덱스 번호
		if (sidx == n + 1) { // 기저 조건: n+1 되면 BFS
			int A = 0; // A(1)로 선택된 인구 합
			int B = 0; // B(2)로 선택된 인구 합
			for (int i = 1; i < n + 1; i++) {
				if (area[i] == 1) {
					A += people[i];
				} else {
					B += people[i];
				}
			}

			if (A > 0 && B > 0) { // 두 선거구로 나뉘었을 때
				if (bfs(1) && bfs(2)) { // 모든 선거구 bfs가 true = 모든 원소들이 연결되어 있으면
					int min = Math.abs(A - B); // 두 인구 수 차이 계산
					ans = Math.min(ans, min); // 최소값을 ans에 갱신
				}
			}

			return;
		}

		area[sidx] = 1; // 선택 받으면 A(1)로 저장
		district(sidx + 1);
		area[sidx] = 2; // 선택 못 받으면 B(2)로 저장
		district(sidx + 1);
	}

	public static boolean bfs(int idx) { // area의 인덱스 번호
		int maxcnt = 0; // idx 선거구의 총 원소 수
		for (int i = 1; i < n + 1; i++) {
			if (area[i] == idx) {
				maxcnt++; // 마지막에 cnt와 비교할 예정
			}
		}

		boolean[] visited = new boolean[n + 1]; // 방문 처리
		Queue<Integer> q = new LinkedList<>(); // 큐 생성
		int cnt = 0; // 연결된 원소 수
		for (int i = 1; i < n + 1; i++) { // 큐에 넣을 시작점 찾기
			if (!visited[i] && area[i] == idx) { // 미방문 + idx 선거구일 때
				q.offer(i);
				visited[i] = true;
				cnt++;
				break; // 이웃 노드 확인하러 바로 break
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < list.get(curr).size(); i++) {
				int next = list.get(curr).get(i); // 연결된 노드 가져오기
				if (!visited[next] && area[next] == idx) { // 미방문 + idx 선거구일 때
					q.offer(next);
					visited[next] = true;
					cnt++;
				}
			}
		}

		if (cnt == maxcnt) { // 원소 수가 똑같으면 = 모두 연결되었으면 true 반환
			return true;
		} else {
			return false;
		}
	}
}
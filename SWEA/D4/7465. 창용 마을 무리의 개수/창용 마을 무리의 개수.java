import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 1 ~ n번, 정점 수
			int m = sc.nextInt(); // 간선 수
			p = new int[n + 1]; // root 저장 배열 (makeset)
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			int[][] nodes = new int[m][2]; // 시작 노드, 끝 노드. (가중치는 1이므로 생략)
			for (int i = 0; i < m; i++) {
				nodes[i][0] = sc.nextInt();
				nodes[i][1] = sc.nextInt();
			}

			int group = 1; // 무리의 개수 (출력값)
			for (int i = 0; i < m; i++) {
				union(nodes[i][0], nodes[i][1]);
			}

			Set<Integer> set = new HashSet<Integer>(); // p 원소 중복 방지 set
			for (int i = 1; i <= n; i++) {
				set.add(findset(p[i]));
			}
			group = set.size(); // set 원소 개수 = 무리 개수
			System.out.println("#" + tc + " " + group);
		}
	}

	public static int findset(int i) {
		if (i == p[i]) {
			return i;
		}
		p[i] = findset(p[i]); // 시간 초과 방지
		return p[i];
	}

	public static void union(int i, int j) {
		p[findset(j)] = findset(i);
	}
}
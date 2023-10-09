import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] select;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n + 1]; // 방문 처리
		m = sc.nextInt();
		select = new int[m]; // 뽑은 숫자 저장
		perm(0); // sidx: select의 시작 인덱스
	}

	public static void perm(int sidx) {
		if (sidx == m) { // m개 뽑으면 종료
			for (int each : select) {
				System.out.print(each + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) { // 1부터 n까지
			if (!visited[i]) {
				visited[i] = true;
				select[sidx] = i;
				perm(sidx + 1);
				for (int j = i + 1; j <= n; j++) { // 오름차순 고려
					visited[j] = false; // i보다 큰 숫자들은 미방문 처리
				}
			}
		}
	}
}
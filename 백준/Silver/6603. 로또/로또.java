import java.io.*;
import java.util.*;

public class Main {
	static int[] nums; // 원본
	static int[] sel; // 이번 조합
	static boolean[] visited;
	static int k;
	static final int r = 6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken()); // 개수

		while (k != 0) { // 0이 오면 입력 종료
			nums = new int[k];
			for (int i = 0; i < k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			sel = new int[r];
			visited = new boolean[k];

			comb(nums, visited, 0, k, 0);

			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			if (k != 0) {
				System.out.println();
			}
		}
	}

	public static void comb(int[] nums, boolean[] visited, int start, int k, int sidx) {
		if (sidx == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[sidx] = nums[i];
				comb(nums, visited, i + 1, k, sidx + 1);
				visited[i] = false;
			}
		}
	}
}

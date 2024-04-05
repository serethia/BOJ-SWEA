import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int s;
	static int cnt; // 부분 수열 개수
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 개수
		s = Integer.parseInt(st.nextToken()); // 합
		cnt = 0;
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		backtrack(0, 0);
		if (s == 0) {
			cnt--; // 공집합 제거
		}
		System.out.println(cnt);
	}

	public static void backtrack(int idx, int sum) {
		if (idx == n) {
			if (sum == s) {
				cnt++;
			}
			return;
		}

		backtrack(idx + 1, sum + nums[idx]);
		backtrack(idx + 1, sum);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 1~100,000
		int[] nums = new int[n];
		StringTokenizer token = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(token.nextToken()); // 값: 1~1,000,000
		}
		Arrays.sort(nums);
		int x = Integer.parseInt(br.readLine()); // 합: 1~2,000,000
		long cnt = 0; // 최대 nC2 = 4,999,950,000 = int 초과
		// 이중 for문 = 시간초과 -> 투포인터로 수정
		int st = 0;
		int ed = n - 1;
		while (st < ed) {
			if (nums[st] + nums[ed] > x) {
				ed--;
			} else if (nums[st] + nums[ed] < x) {
				st++;
			} else {
				cnt++;
				st++;
				ed--;
			}
		}
		System.out.println(cnt);
	}
}

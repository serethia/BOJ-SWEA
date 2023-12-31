import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		Integer[] cnt = new Integer[8001]; // -4,000 ~ 4,000
		Arrays.fill(cnt, 0); // Integer라서
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			cnt[nums[i] + 4000]++;
		}
		Arrays.sort(nums);

		// 1. 산술평균
		long sum = 0; // 최대 500,000 * 4,000
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}
		long aver = Math.round((sum - 0.5) / n); // 음수 반올림 고려
		if (aver == -0) {
			aver = 0;
		}
		sb.append(aver).append('\n');

		// 2. 중앙값
		sb.append(nums[n / 2]).append('\n');

		// 3. 최빈값
		int maxfreq = cnt[0];
		for (int i = 0; i < 8001; i++) {
			if (cnt[i] > maxfreq) {
				maxfreq = cnt[i]; // 최대 빈도
			}
		}
		ArrayList<Integer> freqlist = new ArrayList<>(); // 최빈수들
		for (int i = 0; i < 8001; i++) {
			if (cnt[i] == maxfreq) {
				freqlist.add(i);
			}
		}
		int val = (freqlist.size() > 1) ? freqlist.get(1) - 4000 : freqlist.get(0) - 4000; // 2번째로 작은 값 or 유일값
		sb.append(val).append('\n');

		// 4. 범위
		sb.append(Math.abs(nums[n - 1] - nums[0]));

		System.out.println(sb);
	}
}
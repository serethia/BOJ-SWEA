import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int[] nums = new int[3];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int mid = 0;
		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		for (int i = 0; i < 3; i++) {
			if (nums[i] > min && nums[i] < max) {
				mid = nums[i];
			}
		}
		sb.append(min).append(" ").append(mid).append(" ").append(max);
		System.out.println(sb);
	}
}
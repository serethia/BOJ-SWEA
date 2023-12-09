import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수의 개수
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		// 머지 정렬 시 시간 초과 => 퀵 정렬로 변경
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder(); // 시간 단축
		for (int i = 0; i < n; i++) {
			sb.append(nums[i]).append('\n');
		}
		System.out.println(sb);
	}
}
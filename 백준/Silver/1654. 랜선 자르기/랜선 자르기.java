import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(st.nextToken()); // 1 ~ 10,000. n 이하
		int n = Integer.parseInt(st.nextToken()); // 1 ~ 1,000,000. 남은 조각은 버림 (합치지 X)
		int[] lengths = new int[k];
		long max = 0;
		for (int i = 0; i < k; i++) {
			lengths[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lengths[i]);
		}
		// 이분 탐색
		max += 1;
		long min = 0;
		long mid = 0;
		while (max > min) { // 탐색 범위 0 될 때까지
			mid = (max + min) / 2;
			long cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += (lengths[i] / mid);
			}
			if (cnt < n) { // mid로 자른 개수 < n : max를 mid로 줄이기
				max = mid;
			} else { // mid로 자른 개수 >= n : min을 mid+1로 늘리기
				min = mid + 1;
			}
		}
		sb.append(min - 1);
		System.out.println(sb);
	}
}
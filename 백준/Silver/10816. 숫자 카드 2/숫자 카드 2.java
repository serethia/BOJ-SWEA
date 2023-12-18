import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[20000001]; // -10,000,000 ~ 10,000,000
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken()); // 카드에 적힌 숫자
			cnt[card + 10000000]++; // 카운트 +1
		}

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			int has = Integer.parseInt(st.nextToken()); // 가지고 있는지
			if (i == m - 1) { // 마지막 인덱스: 띄어쓰기 제외
				sb.append(cnt[has + 10000000]);
			} else { // 띄어쓰기 포함
				sb.append(cnt[has + 10000000]).append(" ");
			}
		}
		System.out.println(sb);
	}
}
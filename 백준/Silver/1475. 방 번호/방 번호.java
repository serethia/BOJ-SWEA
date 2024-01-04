import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int[] cnt = new int[9]; // 0 ~ 8번
		for (int i = 0; i < len; i++) {
			int tmp = str.charAt(i) - '0';
			if (tmp == 9) { // 9번은 6번에 통합
				cnt[6]++;
			} else {
				cnt[tmp]++;
			}
		}
		cnt[6] = (cnt[6] + 1) / 2; // 6번은 통합된 세트 수 계산
		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			ans = Math.max(cnt[i], ans);
		}
		sb.append(ans);
		System.out.println(sb);
	}
}
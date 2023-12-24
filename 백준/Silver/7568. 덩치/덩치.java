import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 2 ~ 50
		int[] kg = new int[n]; // 몸무게
		int[] cm = new int[n]; // 키
		int[] rank = new int[n]; // 등수 (출력)
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			kg[i] = Integer.parseInt(st.nextToken());
			cm[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) { // 기준 대상
			int k = 0;
			for (int j = 0; j < n; j++) { // 비교 대상
				// 둘 다 비교 대상보다 작을 때만 k 증가
				if (kg[i] < kg[j] && cm[i] < cm[j]) {
					k++;
				}
			}
			rank[i] = k + 1; // 순위는 k+1
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i == n - 1) { // 마지막 사람은 공백 제외
				sb.append(rank[i]);
			} else {
				sb.append(rank[i]).append(" ");
			}
		}
		System.out.println(sb);
	}
}
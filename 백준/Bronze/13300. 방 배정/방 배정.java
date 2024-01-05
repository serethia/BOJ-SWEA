import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken()); // 학생 수
		int k = Integer.parseInt(token.nextToken()); // 한 방 최대 인원
		int[][] student = new int[2][6]; // 행: 성별, 열: 학년 (0 ~ 5로 변환)
		for (int i = 0; i < n; i++) {
			StringTokenizer sttoken = new StringTokenizer(br.readLine());
			student[Integer.parseInt(sttoken.nextToken())][Integer.parseInt(sttoken.nextToken()) - 1]++;
		}
		int total = 0;
		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 6; c++) {
				if (student[r][c] % k != 0) {
					total++;
				}
				total += student[r][c] / k;
			}
		}
		System.out.println(total);
	}
}
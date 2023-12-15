import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 전체 입력값 map 저장
		char[][] map = new char[n][m];
		for (int r = 0; r < n; r++) {
			String str = br.readLine();
			for (int c = 0; c < m; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		// 시작점 탐색
		int cnt = 64; // 8*8 = 64가 최대
		for (int r = 0; r <= n - 8; r++) {
			for (int c = 0; c <= m - 8; c++) {
				cnt = Math.min(cnt, paint(map, r, c)); // 64와 고친 수 간의 최소값 비교
			}
		}
		System.out.println(cnt); // 출력
	}

	public static int paint(char[][] map, int startr, int startc) {
		// 두 색 중 1가지 경우를 가정하고 고칠 칸 수 count 구하기
		int count = 0;
		char start = 'B'; // 검정으로 시작했다 가정하면
		for (int r = startr; r < startr + 8; r++) {
			for (int c = startc; c < startc + 8; c++) {
				// 행+열 = 짝수일 때 시작점과 동일 색
				if ((r + c) % 2 == 0 && map[r][c] != start) { // 반대 색이면 카운트+1
					count++;
				}
				// 행+열 = 홀수일 때 시작점과 반대 색
				if ((r + c) % 2 != 0 && map[r][c] == start) { // 동일 색이면 카운트+1
					count++;
				}
			}
		}
		// 남은 1가지 경우를 '64에서 뺀 count'로 두고 count와 비교해 최소값 반환
		return Math.min(count, 64 - count);
	}
}
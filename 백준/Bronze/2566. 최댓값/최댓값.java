import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		int max = Integer.MIN_VALUE;
		int maxr = 0;
		int maxc = 0;
		sb = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > max) {
					max = map[r][c];
					maxr = r;
					maxc = c;
				}
			}
		}
		sb.append(max).append('\n').append(maxr + 1).append(" ").append(maxc + 1);
		System.out.println(sb);
	}
}
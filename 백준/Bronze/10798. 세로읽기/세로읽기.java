import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[5][15];
		sb = new StringBuilder();
		for (int r = 0; r < 5; r++) {
			String row = br.readLine();
			for (int c = 0; c < row.length(); c++) {
				map[r][c] = row.charAt(c);
			}
		}
		for (int c = 0; c < 15; c++) {
			for (int r = 0; r < 5; r++) {
				if (map[r][c] == '\0') { // 값이 없을 때 (char에서의 null)
					continue;
				} else {
					sb.append(map[r][c]);
				}
			}
		}
		System.out.println(sb);
	}
}
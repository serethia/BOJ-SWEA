import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int begin = m;
		sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(begin % 10 * n).append('\n');
			begin /= 10;
		}
		sb.append(n * m);
		System.out.println(sb);
	}
}
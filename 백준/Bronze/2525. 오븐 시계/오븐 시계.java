import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int hour = Integer.parseInt(st.nextToken()); // 0 ~ 23
		int min = Integer.parseInt(st.nextToken()); // 0 ~ 59
		int time = Integer.parseInt(br.readLine()); // 0 ~ 1,000
		min += time;
		int exceed = min / 60;
		hour += exceed;
		min %= 60; // 60분을 넘지 않도록
		if (hour > 23) {
			hour -= 24;
		}
		sb.append(hour).append(" ").append(min);
		System.out.println(sb);
	}
}
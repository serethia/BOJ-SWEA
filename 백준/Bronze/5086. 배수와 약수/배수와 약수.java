import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while (first > 0 && second > 0) {
			if (first % second == 0) {
				sb.append("multiple").append('\n'); // 첫 번째가 두 번째의 배수
			} else if (second % first == 0) {
				sb.append("factor").append('\n'); // 첫 번째가 두 번째의 약수
			} else {
				sb.append("neither").append('\n'); // 둘 다 아님
			}
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
}
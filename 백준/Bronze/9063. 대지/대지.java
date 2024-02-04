import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxx = Integer.MIN_VALUE;
		int maxy = Integer.MIN_VALUE;
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			maxx = Math.max(maxx, x);
			maxy = Math.max(maxy, y);
			minx = Math.min(minx, x);
			miny = Math.min(miny, y);
		}
		int ans = (maxx - minx) * (maxy - miny);
		System.out.println(ans);
	}
}
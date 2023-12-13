import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Dot implements Comparable<Dot> {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Dot o) {
			// 1. x좌표 비교
			int xresult = Integer.compare(this.x, o.x);
			if (xresult == 0) {
				// 2. y좌표 비교
				int yresult = Integer.compare(this.y, o.y);
				return yresult;
			} else {
				return xresult;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 시간 단축용

		// 저장
		int n = Integer.parseInt(br.readLine());
		List<Dot> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Dot(x, y));
		}

		// 정렬
		Collections.sort(list);

		// 출력
		StringBuilder sb = new StringBuilder();
		for (Dot d : list) {
			sb.append(d.x).append(" ").append(d.y).append("\n");
		}
		System.out.println(sb);
	}
}
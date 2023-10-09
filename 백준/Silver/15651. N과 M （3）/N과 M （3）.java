import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder(); // 더 빠른 출력을 위함

	public static void main(String[] args) throws NumberFormatException, IOException { // 스캐너: 시간 초과 => 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 단위로 입력 받기
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1]; // 방문 처리
		m = Integer.parseInt(st.nextToken());
		select = new int[m]; // 뽑은 숫자 저장
		perm(0); // sidx: select의 시작 인덱스
		System.out.println(sb);
	}

	public static void perm(int sidx) throws IOException {
		if (sidx == m) { // m개 뽑으면 종료
			for (int each : select) {
				sb.append(each).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			visited[i] = true; // '미방문 시' 조건 삭제 = 중복 허용
			select[sidx] = i;
			perm(sidx + 1);
			visited[i] = false;
		}
	}
}
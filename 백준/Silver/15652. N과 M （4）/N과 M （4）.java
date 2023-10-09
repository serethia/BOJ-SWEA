import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] nums;
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder(); // 더 빠른 출력을 위함

	public static void main(String[] args) throws NumberFormatException, IOException { // 스캐너: 시간 초과 => 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 단위로 입력 받기
		n = Integer.parseInt(st.nextToken());
		nums = new int[n + 1]; // 1부터 n까지 저장
		for (int i = 1; i < n + 1; i++) {
			nums[i] = i;
		}
		visited = new boolean[n + 1]; // 방문 처리
		m = Integer.parseInt(st.nextToken());
		select = new int[m]; // 뽑은 숫자 저장
		perm(1, 0); // idx: nums의 시작 인덱스, sidx: select의 시작 인덱스
		System.out.println(sb);
	}

	public static void perm(int idx, int sidx) throws IOException {
		if (sidx == m) { // m개 뽑으면 종료
			for (int each : select) {
				sb.append(each).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i <= n; i++) { // if(!visited) 지움 = 중복 허용
			visited[i] = true;
			select[sidx] = nums[i];
			perm(i, sidx + 1); // i 그대로 = 중복 허용
			for (int j = i + 1; j <= n; j++) { // 오름차순 처리
				visited[j] = false;
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] nums;
	static int[] select;
	static StringBuilder sb = new StringBuilder(); // 더 빠른 출력을 위함

	public static void main(String[] args) throws NumberFormatException, IOException { // 스캐너: 시간 초과 => 버퍼 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 단위로 입력 받기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		select = new int[m]; // 뽑은 숫자 저장
		nums = new int[n]; // 입력값 저장
		st = new StringTokenizer(br.readLine()); // 줄바꿈
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		perm(0, 0); // idx: nums의 시작 인덱스, sidx: select의 시작 인덱스
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

		int same = 0;
		for (int i = idx; i < n; i++) { // 중복 허용(idx 시작)
			if (same != nums[i]) { // 이전 결과와 중복 아닐 시
				select[sidx] = nums[i];
				same = nums[i]; // 이전 결과와 중복 안 되게
				perm(i, sidx + 1);
			}
		}
	}
}
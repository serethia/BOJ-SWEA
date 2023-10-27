import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 측정 시간
		char[] pattern = new char[n]; // .인지 #인지
		String str = sc.next();
		for (int i = 0; i < n; i++) {
			pattern[i] = str.charAt(i);
		}
		int min = Integer.MAX_VALUE; // 출력값
		int term = 1; // 패턴 주기
		while (term <= n) { // 주기가 길이보다 길어지면 반복 종료
			boolean[] visited = new boolean[n]; // 방문여부
			int cnt = 0; // 귀뚜라미 수

			for (int i = 0; i < n; i++) { // 시작점 찾기
				if (pattern[i] == '#' && !visited[i]) {
					cnt++; // 마리 수 증가
					visited[i] = true;

					for (int j = i; j < n; j += term) { // 주기만큼 더해서 뛰어넘기
						if (pattern[j] == '.') // 주기가 깨짐
							break;
						visited[j] = true;
					}
				}
			}
			term++; // 주기 증가
			min = Math.min(min, cnt); // 최소 마리 수 갱신
		}
		System.out.println(min);
	}
}
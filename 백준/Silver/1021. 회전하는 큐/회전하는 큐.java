import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int qsize = Integer.parseInt(st.nextToken()); // 큐 크기 n
		int pickup = Integer.parseInt(st.nextToken()); // 뽑을 개수 m
		LinkedList<Integer> dq = new LinkedList<>(); // 덱: 인덱스 가져오기 어려움 => 연결리스트
		for (int i = 1; i <= qsize; i++) {
			dq.offer(i); // 1 ~ n 까지 전부 넣어둠
		}

		st = new StringTokenizer(br.readLine());
		int cnt = 0; // 총 이동 횟수
		for (int i = 0; i < pickup; i++) {
			int curr = Integer.parseInt(st.nextToken()); // 뽑을 차례
			int idx = dq.indexOf(curr); // 현재 curr의 인덱스
			if (idx > dq.size() / 2) { // 뒤쪽이면
				for (int j = dq.size() - idx; j > 0; j--) {
					int pop = dq.pollLast(); // 뒤를 뽑아
					dq.offerFirst(pop); // 바로 앞에 넣기
					cnt++;
				}
			} else { // 앞쪽이면
				for (int j = 0; j < idx; j++) {
					int pop = dq.pollFirst(); // 앞을 뽑아
					dq.offerLast(pop); // 바로 뒤에 넣기
					cnt++;
				}
			}
			dq.pollFirst(); // 이동 끝나면 맨 앞을 poll
		}
		System.out.println(cnt);
	}
}
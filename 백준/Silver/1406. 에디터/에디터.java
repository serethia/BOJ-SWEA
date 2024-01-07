import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine(); // 길이 최대 100,000
		int len = word.length();
		LinkedList<Character> list = new LinkedList<>(); // 순수 연결리스트 = 시간초과
		for (int i = 0; i < len; i++) {
			list.add(word.charAt(i));
		}
		int m = Integer.parseInt(br.readLine()); // 1 ~ 500,000
		StringBuilder sb = new StringBuilder(); // 시간 단축용

		ListIterator<Character> cursor = list.listIterator(); // listIterator로 재작성
		while (cursor.hasNext()) {
			cursor.next();
		}
		for (int i = 0; i < m; i++) {
			String command = br.readLine();
			if (command.charAt(0) == 'L') { // 커서를 왼쪽으로 1칸
				if (cursor.hasPrevious()) {
					cursor.previous();
				}
			}
			if (command.charAt(0) == 'D') { // 커서를 오른쪽으로 1칸
				if (cursor.hasNext()) {
					cursor.next();
				}
			}
			if (command.charAt(0) == 'B') { // 커서 왼쪽 문자 삭제
				if (cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
			}
			if (command.charAt(0) == 'P') { // 그 다음 문자를 커서 왼쪽에 추가
				cursor.add(command.charAt(2)); // 공백 그 다음 문자 = 2번째 인덱스
			}
		}
		for (char letters : list) {
			sb.append(letters);
		}
		System.out.print(sb);
	}
}
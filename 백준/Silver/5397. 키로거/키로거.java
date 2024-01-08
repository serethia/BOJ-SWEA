import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String word = br.readLine();
			int len = word.length();
			LinkedList<Character> list = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			ListIterator<Character> cursor = list.listIterator();
			while (cursor.hasNext()) {
				cursor.next();
			}
			for (int i = 0; i < len; i++) {
				if (word.charAt(i) == '<') { // 커서를 왼쪽으로 1칸
					if (cursor.hasPrevious()) {
						cursor.previous();
					}
				} else if (word.charAt(i) == '>') { // 커서를 오른쪽으로 1칸
					if (cursor.hasNext()) {
						cursor.next();
					}
				} else if (word.charAt(i) == '-') { // 커서 왼쪽 문자 삭제
					if (cursor.hasPrevious()) {
						cursor.previous();
						cursor.remove();
					}
				} else { // 문자를 커서 왼쪽에 추가
					cursor.add(word.charAt(i));
				}
			}
			for (char letters : list) {
				sb.append(letters);
			}
			System.out.println(sb);
		}
	}
}
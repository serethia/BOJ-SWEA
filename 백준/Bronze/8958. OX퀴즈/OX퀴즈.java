import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int score = 0; // 출력값
			int cnt = 0; // 연속 등장 횟수
			String str = sc.next();
			char[] letter = str.toCharArray();
			for (int i = 0; i < letter.length; i++) {
				if (letter[i] == 'O') { // O면 카운트+1
					cnt++;
				} else { // X면 카운트 초기화
					cnt = 0;
				}
				score += cnt; // 누적 카운트는 점수에 합산
			}
			System.out.println(score);
		}
	}
}
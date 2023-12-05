import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.next();
			if (str.equals("0")) // 0이면 바로 종료
				break;
			char[] letters = str.toCharArray();
			boolean palindrome = true; // 팰린드롬인 경우 T/F
			int len = letters.length;
			for (int i = 0; i < len / 2; i++) { // 처음과 끝 비교 => 절반 길이만
				if (letters[i] != letters[len - 1 - i]) {
					palindrome = false;
				}
			}
			// 전부 검사한 후 T/F 판별
			if (palindrome) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
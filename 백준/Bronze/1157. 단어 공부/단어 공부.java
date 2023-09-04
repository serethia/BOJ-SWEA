import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String capital = sc.next().toUpperCase();
		char[] word = capital.toCharArray();
		char[] letter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int[] cnt = new int[26];
		for (int i = 0; i < word.length; i++) {
			for (int j = 0; j < letter.length; j++) {
				if (word[i] == letter[j]) {
					cnt[j]++;
				}
			}
		}
		char ans = ' ';
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cnt.length; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				ans = letter[i];
			} else if (max == cnt[i]) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
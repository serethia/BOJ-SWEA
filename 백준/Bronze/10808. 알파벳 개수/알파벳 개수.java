import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] alp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int[] cnt = new int[26];
		char[] word = str.toCharArray();
		for (int i = 0; i < word.length; i++) {
			for (int j = 0; j < alp.length; j++) {
				if (word[i] == alp[j]) {
					cnt[j]++;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			if (i == cnt.length - 1) {
				System.out.print(cnt[i]);
			} else {
				System.out.print(cnt[i] + " ");
			}
		}
		System.out.println();
	}
}
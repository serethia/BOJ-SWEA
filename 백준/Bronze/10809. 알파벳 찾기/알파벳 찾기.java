import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] alp = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int[] res = new int[26];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1; // 모두 -1로 초기화
		}
		String str = sc.next();
		char[] letter = str.toCharArray();
		for (int i = 0; i < letter.length; i++) {
			for (int j = 0; j < alp.length; j++) {
				if (letter[i] == alp[j]) {
					if (res[j] != -1) {
						continue;
					}
					res[j] = i;
				}
			}
		}
		for (int i = 0; i < res.length; i++) {
			if (i == res.length - 1) {
				System.out.print(res[i]);
			} else {
				System.out.print(res[i] + " ");
			}
		}
		System.out.println();
	}
}
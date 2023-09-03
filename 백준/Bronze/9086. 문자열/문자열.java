import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String str = sc.next();
			System.out.printf("%c%c\n", str.charAt(0), str.charAt(str.length() - 1));
		}
	}
}
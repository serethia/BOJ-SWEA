import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 2 * i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		for (int i = 1; i <= 2 * n; i++) {
			System.out.print("*");
		}
		System.out.println(" ");
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= 2 * i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		sc.close();
	}
}
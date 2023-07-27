import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = n; i >= 1; i--) {
			for (int j = 0; j <= n-1-i; j++) {
				System.out.print(" ");
			}
			for (int j = n; j >= n+1-i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
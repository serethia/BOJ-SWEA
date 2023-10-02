import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n은 3~5000
		if (n == 4 || n == 7) System.out.println(-1); // n = 1,2,4,7일 때 -1
		else {
		if (n % 5 == 0)	System.out.println(n / 5); // 1,2,3,4..
		if (n % 5 == 1 || n % 5 == 3) System.out.println(n / 5 + 1); // 2,3,4.. || 2,3,4..
		if (n % 5 == 2 || n % 5 == 4) System.out.println(n / 5 + 2); // 4,5.. || 4,5..
		}
	}
}
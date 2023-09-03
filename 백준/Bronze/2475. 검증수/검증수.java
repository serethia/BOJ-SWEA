import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		System.out.println(cal(a, b, c, d, e));
	}

	public static int cal(int a, int b, int c, int d, int e) {
		int sum = a * a + b * b + c * c + d * d + e * e;
		return sum % 10;
	}
}
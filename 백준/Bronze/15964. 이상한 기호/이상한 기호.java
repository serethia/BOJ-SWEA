import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(cal(x, y));
	}

	public static int cal(int a, int b) {
		return (a + b) * (a - b);
	}
}
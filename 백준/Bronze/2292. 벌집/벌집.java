import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 입력값
		int ans = 0; // 출력값
		int ed = 1; // 끝점
		int i = 1;
		while (n > ed) {
			ed += 6 * i;
			i++;
			ans = i;
		}
		if (n == 1) {
			ans = 1;
		}
		System.out.println(ans);
	}
}
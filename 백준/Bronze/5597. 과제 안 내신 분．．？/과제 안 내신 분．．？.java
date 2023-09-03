import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[30];
		for (int i = 0; i < 28; i++) {
			int stu = sc.nextInt();
			cnt[stu - 1]++;
		}
		for (int i = 0; i < 30; i++) {
			if (cnt[i] == 0) {
				System.out.println(i + 1);
			}
		}
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] music = new int[8];
		int asccnt = 0;
		int descnt = 0;
		for (int i = 0; i < 8; i++) {
			music[i] = sc.nextInt();
		}
		for (int i = 0; i < 7; i++) {
			if (music[i] < music[i + 1]) {
				asccnt++;
			}
			if (music[i] > music[i + 1]) {
				descnt++;
			}
		}
		if (asccnt == 7) {
			System.out.println("ascending");
		} else if (descnt == 7) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
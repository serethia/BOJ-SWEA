import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] shorts;
	public static int[] realshorts;
	public static boolean found;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		shorts = new int[9];
		realshorts = new int[7];
		for (int i = 0; i < 9; i++) {
			shorts[i] = sc.nextInt();
		}
		found = false;
		pick(0, 0, 0);

	}

	public static void pick(int idx, int jdx, int sum) {
		if(found)
			return;
		
		if (jdx == 7) {

			if (sum == 100) {
				found = true;
				Arrays.sort(realshorts);
				for (int i = 0; i < 7; i++) {
					System.out.println(realshorts[i]);
				}
				return;
			}
			return;
		}
		if (idx == 9) {
			return;
		}

		realshorts[jdx] = shorts[idx];
		pick(idx + 1, jdx + 1, sum + shorts[idx]);
		pick(idx + 1, jdx, sum);
	}
}
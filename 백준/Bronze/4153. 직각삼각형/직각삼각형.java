import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		p: while (true) {
			int[] nums = new int[3];
			for (int i = 0; i < 3; i++) {
				nums[i] = sc.nextInt();
				if (nums[i] == 0)
					break p;
			}
			Arrays.sort(nums);
			String result = "wrong";
			if (nums[2] == Math.sqrt(Math.pow(nums[0], 2) + Math.pow(nums[1], 2))) {
				result = "right";
			}
			System.out.println(result);
		}
	}
}
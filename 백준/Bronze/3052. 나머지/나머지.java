import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = sc.nextInt();
		}
		int[] leftage = new int[10];
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			leftage[i] = nums[i] % 42;
			set.add(leftage[i]);
		}
		System.out.println(set.size());
	}
}
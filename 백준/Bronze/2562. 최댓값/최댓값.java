import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		int max = 0;
		for(int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
			max = Math.max(max, nums[i]);
		}
		System.out.println(max);
		for(int i = 0; i < 9; i++) {
			if(max == nums[i]) {
				System.out.println(i+1);
			}
		}
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			if(nums[i] < x) {
				System.out.print(nums[i]+" ");
			}
		}
		System.out.println();
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		for(int i = 0; i < n; i++) {
			if(nums[i] == v) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
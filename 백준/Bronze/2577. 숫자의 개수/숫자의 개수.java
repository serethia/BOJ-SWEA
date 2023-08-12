import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int value = a * b * c;

		String valuestr = String.valueOf(value);
		String[] val = valuestr.split(""); 

		int[] nums = new int[10];

		for (int i = 0; i < val.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (j == Integer.parseInt(val[i])) { 
					nums[Integer.parseInt(val[i])]++;
				}

			}

		}
		for (int j = 0; j < nums.length; j++) {
			System.out.println(nums[j]);
		}
	}
}
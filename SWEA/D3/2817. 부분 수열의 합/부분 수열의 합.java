import java.util.Scanner;
 
public class Solution {
    static int n;
    static int k;
    static int[] nums;
    static int cnt;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            cnt = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
 
            select(0, 0);
            System.out.println("#" + tc + " " + cnt);
        }
    }
 
    public static void select(int idx, int sum) {
        if (idx == n) {
            if (sum == k) {
                cnt++;
            }
            return;
        }
 
        select(idx + 1, sum + nums[idx]);
        select(idx + 1, sum);
    }
}
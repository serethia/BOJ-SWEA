import java.util.Scanner;
 
public class Solution {
    static int n;
    static int b;
    static int min;
    static int[] height;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt(); 
            b = sc.nextInt(); 
            min = Integer.MAX_VALUE;
            int ans = 0;
            height = new int[n];
            for(int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }
            pick(0, 0);
            ans = min - b;
            System.out.println("#"+tc+" "+ans);
        }
    }
     
    public static void pick(int idx, int sum) { // 부분집합
        if(idx == n) {
            if(sum >= b) {
                min = Math.min(min, sum);
            }
            return;
        }
         
        pick(idx+1, sum+height[idx]);
        pick(idx+1, sum);
    }
}
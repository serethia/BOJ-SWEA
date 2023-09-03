import java.util.Scanner;
 
public class Solution {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String ans = "ON";
             
            for(int i = 0; i < n; i++) {
                if((m >> i & 1) == 0) {
                    ans = "OFF";
                    break;
                }
            }
            System.out.println("#"+tc+" "+ans);
             
        }
    }
}
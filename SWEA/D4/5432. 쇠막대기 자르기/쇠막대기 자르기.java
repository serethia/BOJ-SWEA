import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            String s = sc.next().replace("()", "@"); //레이저
            int ans = 0;  //총 조각 수
            int iron = 0; //쇠 막대 수
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '@') {
                    ans += iron;
                }
                if(s.charAt(i) == '(') {
                    iron++;
                }
                if(s.charAt(i) == ')') {
                    ans++;
                    iron--;
                }           
            }       
            System.out.println("#"+t+" "+ans);
        }
    }
}
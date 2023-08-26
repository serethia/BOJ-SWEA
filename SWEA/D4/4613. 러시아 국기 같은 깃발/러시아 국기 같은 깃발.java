import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
             
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] flag = new char[n][m];
             
            int ans = Integer.MAX_VALUE; // 출력값
             
            for (int r = 0; r < n; r++) {
                String str = sc.next();
                for (int c = 0; c < m; c++) {
                    flag[r][c] = str.charAt(c);
                }
            }
             
            //완전 탐색 시작
            for (int blue = 1; blue < n - 1; blue++) { // 1 ~ n-2번째 blue
                for (int red = blue + 1; red < n; red++) { // blue+1 ~ n-1번째 red
                     
                    int paint = 0; // 덧칠할 횟수 초기화
                     
                    for (int i = 0; i < blue; i++) { // 0 ~ b-1번째 흰색
                        for (int c = 0; c < m; c++) {
                            if (flag[i][c] != 'W') {
                                paint++;
                            }
                        }
                    }
                     
                    for (int i = blue; i < red; i++) { // b ~ r-1번째 파랑
                        for (int c = 0; c < m; c++) {
                            if (flag[i][c] != 'B') {
                                paint++;
                            }
                        }
                    }
                     
                    for (int i = red; i < n; i++) { // r ~ n-1번째 빨강
                        for (int c = 0; c < m; c++) {
                            if (flag[i][c] != 'R') {
                                paint++;
                            }
                        }
                    }
                     
                    ans = Math.min(ans, paint);
                }
            }
 
            System.out.println("#" + tc + " " + ans);
        }
    }
}
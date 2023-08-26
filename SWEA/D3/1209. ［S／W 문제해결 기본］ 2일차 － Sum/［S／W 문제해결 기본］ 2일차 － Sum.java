import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt(); //번호 빼기
            int row = 0;
            int col = 0;
            int cross = 0;
            int cross1 = 0;
            int cross2 = 0;
            int sum = 0; //구할 합의 최대값
             
            int[][] map = new int[100][100];
            for(int r = 0; r < 100; r++) {
                for(int c = 0; c < 100; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
             
            //행의 합 최대값
            for(int r = 0; r < 100; r++) {
                int ans = 0;
                for(int c = 0; c < 100; c++) {
                    ans += map[r][c];
                }
                if(ans > row) {
                    row = ans;
                }
            }
             
            //열의 합 최대값
            for(int c = 0; c < 100; c++) {
                int ans2 = 0;
                for(int r = 0; r < 100; r++) {
                    ans2 += map[r][c];
                }
                if(ans2 > col) {
                    col = ans2;
                }
            }
             
            //우하 대각선의 합 최대값
            for(int r = 0; r < 100; r++) {
                int ans3 = 0;
                for(int c = 0; c < 100; c++) {
                    if(r == c) {
                        ans3 += map[r][c];
                    }
                }
                if(ans3 > cross1) {
                    cross1 = ans3;
                }
            }
            //좌하 대각선의 합 최대값
            for(int r = 0; r < 100; r++) {
                int ans4 = 0;
                for(int c = 0; c < 100; c++) {
                    if(r + c == 99) {
                        ans4 += map[r][c];
                    }
                }
                if(ans4 > cross2) {
                    cross2 = ans4;
                }
            }
             
            cross = Math.max(cross1, cross2);
             
                 
            //최대값의 최대값
            if(row > sum) {
                sum = row;
            }
            if(col > sum) {
                sum = col;
            }
            if(cross > sum) {
                sum = cross;
            }
             
            System.out.println("#"+tc+" "+sum);
        }
    }
}
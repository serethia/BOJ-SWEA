import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt(); // 농장 크기
            int[][] farm = new int[n][n];
 
            int sum = 0; // 수익 가치 합
            for (int r = 0; r < n; r++) {
                String str = sc.next();
                for (int c = 0; c < n; c++) {
                    farm[r][c] = str.charAt(c) - '0'; // 입력 저장
                }
            }
 
            for (int row = 0; row <= n / 2; row++) { // 중앙 row 포함 위쪽 절반
                for (int col = n / 2; col >= n / 2 - row; col--) { // 좌측 상단
                    sum += farm[row][col];
                }
                for (int col = n / 2; col <= n / 2 + row; col++) { // 우측 상단
                    sum += farm[row][col];
                }
                sum -= farm[row][n / 2]; // 중앙 col 중복값 제거
            }
 
            for (int row = n / 2 + 1; row < n; row++) { // 중앙 row 제외 아래쪽 절반
                for (int col = n / 2; col >= n / 2 - (n - 1 - row); col--) { // 좌측 하단
                    sum += farm[row][col];
                }
                for (int col = n / 2; col <= n / 2 + (n - 1 - row); col++) { // 우측 하단
                    sum += farm[row][col];
                }
                sum -= farm[row][n / 2]; // 중앙 col 중복값 제거
            }
 
            System.out.println("#" + t + " " + sum); // sum 출력
        }
    }
}
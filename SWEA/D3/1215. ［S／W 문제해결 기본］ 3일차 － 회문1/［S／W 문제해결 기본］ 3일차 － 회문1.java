import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[8][8];
        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt(); // 회문 길이
            sc.nextLine();
            int ans = 0; // n길이 회문 수
            
            for (int i = 0; i < 8; i++) {
                char[] arr = sc.nextLine().toCharArray();
                map[i] = arr;
            }
 
            
            
            
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) { // 가로 시작점
                    part: for (int y = 7; y >= c; y--) { // 비교지점
                        int rowlength = y-c+1;
                        if(map[r][c] == map[r][y]) { // 같으면 비교 시작
                            for(int i = 1; i <= (y-c)/2; i++) { // 비교 횟수
                                if(map[r][c+i] != map[r][y-i]) { // 회문이 아님
                                    continue part;
                                }
                            }
                            if(rowlength == n) { // 회문이 맞으면 길이 체크
                            	ans++;
                            }
                        }
                    }
                }
            }
             
            for (int c = 0; c < 8; c++) {
                for (int r = 0; r < 8; r++) { // 세로 시작점
                    part2: for (int x = 7; x >= r; x--) { // 비교지점
                        int collength = x-r+1;
                        if(map[r][c] == map[x][c]) { // 같으면 비교 시작
                            for(int j = 1; j <= (x-r)/2; j++) { // 비교 횟수
                                if(map[r+j][c] != map[x-j][c]) { // 회문이 아님
                                    continue part2;
                                }
                            }
                            if(collength == n) { // 회문이 맞으면 길이 체크
                            	ans++;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
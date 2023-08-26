import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[100][100];
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt(); // 숫자 뽑아내기
            sc.nextLine();
            int max = 1; // 최대 길이 (한 글자도 회문 인정)
            for (int i = 0; i < 100; i++) {
                String s = sc.nextLine();
                char[] arr = s.toCharArray();
                map[i] = arr;
            } // 한 줄씩 저장해 2차원 배열로
 
            int length = 0; // 가로
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) { // 시작점
                    part: for (int y = 99; y >= c; y--) { // 비교지점
                        length = y-c+1;
                        if(map[r][c] == map[r][y]) { // 같으면 비교 시작
                            for(int i = 1; i <= (y-c)/2; i++) { // 비교 횟수
                                if(map[r][c+i] != map[r][y-i]) { // 회문이 아님
                                    continue part;
                                }
                            }
                            max = Math.max(max, length);
                        }
                    }
                }
            }
 
            int length2 = 0; // 세로
            for (int c = 0; c < 100; c++) {
                for (int r = 0; r < 100; r++) { // 시작점
                    part2: for (int x = 99; x >= r; x--) { // 비교지점
                        length2 = x-r+1;
                        if(map[r][c] == map[x][c]) { // 같으면 비교 시작
                            for(int j = 1; j <= (x-r)/2; j++) { // 비교 횟수
                                if(map[r+j][c] != map[x-j][c]) { // 회문이 아님
                                    continue part2;
                                }
                            }
                            max = Math.max(max, length2);
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
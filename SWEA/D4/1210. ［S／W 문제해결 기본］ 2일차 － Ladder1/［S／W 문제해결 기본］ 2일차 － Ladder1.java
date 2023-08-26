import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt(); // 테스트 케이스 번호 주어짐 : t로 뽑아 출력
 
            int[][] ladder = new int[100][100];
            // 100x100 배열에서 1이 사다리, 2가 도착지점, 0은 아무것도아님
            int endr = Integer.MIN_VALUE;
            int endc = Integer.MIN_VALUE;
 
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) {
                    ladder[r][c] = sc.nextInt(); // 사다리 배열 입력값 저장
                }
            }
 
            for (int r = 0; r < 100; r++) {
                for (int c = 0; c < 100; c++) {
                    if (ladder[r][c] == 2) { // 도착 지점 좌표 저장
                        endr = r;
                        endc = c; // 2로 표시된 도착 지점의 column값 (출발 지점으로 전환해야)
                    }
                }
            }
 
            // 도착 지점 좌표를 현재 좌표로 전환
            int r = endr;
            int c = endc;
 
            while (r > 0) { // r: 0~99, 0에 도달하면 끝나므로 r이 0보다 큰 조건에서 반복
                if (c - 1 >= 0 && ladder[r][c - 1] == 1) { // 왼쪽 이동
                    while (c - 1 >= 0 && ladder[r][c - 1] == 1) {
                        c--; // 왼쪽 계속 이동
                    }
                } else if (c + 1 <= 99 && ladder[r][c + 1] == 1) { // 오른쪽 이동
                    while (c + 1 <= 99 && ladder[r][c + 1] == 1) {
                        c++; // 오른쪽 계속 이동
                    }
                }
                // 두 방향 다 못 가면 위쪽 이동
                r--;
            }
            System.out.println("#" + t + " " + c); // x좌표(c)만 뽑아내기
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;
 
public class Solution {
    static int n;
    static int[][] dessert;
    static int maxcnt;
    static int[] dr = { 1, 1, -1, -1 };
    static int[] dc = { 1, -1, -1, 1 };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            dessert = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    dessert[r][c] = sc.nextInt();
                }
            }
            maxcnt = -1; // 못 먹으면 -1 출력
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    // 출발r 출발c 현재r 현재c 델타방향d 디저트값넣을list 종류수cnt
                    eat(r, c, r, c, 0, new ArrayList<Integer>(), 0);
                }
            }
            System.out.println("#" + tc + " " + maxcnt);
        }
    }
 
    public static void eat(int startr, int startc, int nowr, int nowc, int direction, ArrayList<Integer> ate, int cnt) {
        // direction = 3 진행 후 원점 돌아오면 maxcnt에 cnt 저장하고 빠져나오기
        if (nowr == startr && nowc == startc && direction == 3) {
            maxcnt = Math.max(maxcnt, cnt);
        }
 
         
        // 좌표 갱신
        int nr = nowr + dr[direction];
        int nc = nowc + dc[direction];
        // 그 방향으로 직진
        if (nr >= 0 && nr < n && nc >= 0 && nc < n && !ate.contains(dessert[nr][nc])) { // 경계 조건 + 중복x
            ArrayList<Integer> ate2 = new ArrayList<>();
            for (int i : ate) {
                ate2.add(i);
            }
            ate2.add(dessert[nr][nc]);
            eat(startr, startc, nr, nc, direction, ate2, cnt + 1);
        }
        // 다음 방향으로 전환 (direction = 0,1,2만 해당)
        if (direction == 0 || direction == 1 || direction == 2) {
            // 좌표 갱신
            nr = nowr + dr[direction + 1];
            nc = nowc + dc[direction + 1];
 
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !ate.contains(dessert[nr][nc])) { // 경계 조건 + 중복x
                ArrayList<Integer> ate3 = new ArrayList<>();
                for (int i : ate) {
                    ate3.add(i);
                }
                ate3.add(dessert[nr][nc]);
                eat(startr, startc, nr, nc, direction + 1, ate3, cnt + 1);
            }
 
        }
    }
}
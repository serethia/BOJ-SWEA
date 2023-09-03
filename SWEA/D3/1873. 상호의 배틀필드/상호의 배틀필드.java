import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            // 입력 값 저장
            int h = sc.nextInt();
            int w = sc.nextInt();
            char[][] map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String str = sc.next();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            int n = sc.nextInt();
            char[] input = new char[n];
            String in = sc.next();
            for (int i = 0; i < n; i++) {
                input[i] = in.charAt(i);
            }
 
            for (int i = 0; i < n; i++) { // 사용자 입력 종류 UDLRS
                int tankr = 0;
                int tankc = 0;
 
                for (int r = 0; r < h; r++) {
                    for (int c = 0; c < w; c++) {
 
                        if (map[r][c] == '^' || map[r][c] == '<' || map[r][c] == 'v' || map[r][c] == '>') { // 전차 위치 찾기
                            tankr = r;
                            tankc = c;
                        }
                    }
                }
 
                if (input[i] == 'U') {
                    map[tankr][tankc] = '^'; // 위 방향 바라봄
                    if (tankr - 1 >= 0 && map[tankr - 1][tankc] == '.') {
                        tankr--;
                        map[tankr][tankc] = '^'; // 평지면 탱크 이동
                        map[tankr + 1][tankc] = '.'; // 지나간 곳은 평지
                    }
                }
 
                else if (input[i] == 'D') {
                    map[tankr][tankc] = 'v'; // 아래 방향 바라봄
                    if (tankr + 1 < h && map[tankr + 1][tankc] == '.') {
                        tankr++;
                        map[tankr][tankc] = 'v'; // 평지면 탱크 이동
                        map[tankr - 1][tankc] = '.'; // 지나간 곳은 평지
                    }
                }
 
                else if (input[i] == 'L') {
                    map[tankr][tankc] = '<'; // 왼 방향 바라봄
                    if (tankc - 1 >= 0 && map[tankr][tankc - 1] == '.') {
                        tankc--;
                        map[tankr][tankc] = '<'; // 평지면 탱크 이동
                        map[tankr][tankc + 1] = '.'; // 지나간 곳은 평지
                    }
                }
 
                else if (input[i] == 'R') {
                    map[tankr][tankc] = '>'; // 오른 방향 바라봄
                    if (tankc + 1 < w && map[tankr][tankc + 1] == '.') {
                        tankc++;
                        map[tankr][tankc] = '>'; // 평지면 탱크 이동
                        map[tankr][tankc - 1] = '.'; // 지나간 곳은 평지
                    }
                }
 
                else if (input[i] == 'S') { // 포탄 시작 위치 = 전차 위치. 바라보는 방향으로 직진. 벽돌 벽에 닿으면 파괴되어 평지로. 벽을 만나면 포탄 소멸.
                    int misr = 0;
                    int misc = 0;
 
                    if (map[tankr][tankc] == '^') {
                        misr = tankr;
                        misc = tankc;
 
                        while (misr > 0) {
                            misr--;
 
                            if (map[misr][misc] == '*') {
                                map[misr][misc] = '.';
                                break;
                            } else if (map[misr][misc] == '#') {
                                break;
                            }
 
                        }
 
                    }
 
                    else if (map[tankr][tankc] == 'v') {
                        misr = tankr;
                        misc = tankc;
 
                        while (misr < h - 1) {
                            misr++;
 
                            if (map[misr][misc] == '*') {
                                map[misr][misc] = '.';
                                break;
                            } else if (map[misr][misc] == '#') {
                                break;
                            }
 
                        }
 
                    }
 
                    else if (map[tankr][tankc] == '<') {
                        misr = tankr;
                        misc = tankc;
 
                        while (misc > 0) {
                            misc--;
 
                            if (map[misr][misc] == '*') {
                                map[misr][misc] = '.';
                                break;
                            } else if (map[misr][misc] == '#') {
                                break;
                            }
 
                        }
 
                    }
 
                    else if (map[tankr][tankc] == '>') {
                        misr = tankr;
                        misc = tankc;
 
                        while (misc < w - 1) {
                            misc++;
 
                            if (map[misr][misc] == '*') {
                                map[misr][misc] = '.';
                                break;
                            } else if (map[misr][misc] == '#') {
                                break;
                            }
 
                        }
                    }
 
                }
            }
 
            // 맵 출력
            System.out.print("#" + tc + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
 
        }
    }
}
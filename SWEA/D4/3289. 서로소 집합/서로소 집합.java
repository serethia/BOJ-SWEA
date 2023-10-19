import java.util.Scanner;
 
public class Solution {
    static int[] p;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt(); // a,b가 1 ~ n
            int m = sc.nextInt(); // 연산 수
            p = new int[n + 1]; // root 저장 배열 (makeset)
            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }
            int[] cal = new int[m]; // 연산자 0 or 1
            int[][] nodes = new int[m][2]; // 시작 노드, 끝 노드. (가중치는 1이므로 생략)
            for (int i = 0; i < m; i++) {
                cal[i] = sc.nextInt();
                nodes[i][0] = sc.nextInt();
                nodes[i][1] = sc.nextInt();
            }
 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (cal[i] == 0) { // 0 시작 = 뒤의 두 숫자를 합집합
                    union(nodes[i][0], nodes[i][1]);
                } else if (cal[i] == 1) { // 1 시작 = 뒤의 두 숫자가 포함된 동일 집합인지 (yes면 1, no면 0)
                    if (findset(nodes[i][0]) == findset(nodes[i][1])) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
    }
 
    public static int findset(int i) {
        if (i == p[i]) {
            return i;
        }
        p[i] = findset(p[i]); // 시간 초과 방지
        return p[i];
    }
 
    public static void union(int i, int j) {
        p[findset(j)] = findset(i);
    }
}
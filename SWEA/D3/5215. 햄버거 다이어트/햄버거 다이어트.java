import java.util.Scanner;
 
public class Solution {
    static int[] calory;
    static int[] score;
    static int n;
    static int l;
    static int best;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            best = 0;
            n = sc.nextInt(); // 재료 수
            l = sc.nextInt(); // 제한 칼로리
            calory = new int[n];
            score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
                calory[i] = sc.nextInt();
            }
            check(0, 0, 0);//부분집합
            System.out.println("#" + tc + " " + best);
        }
    }
 
    public static void check(int idx, int cal, int sco) { // idx = 인덱스 번호, cal = 칼로리 합, sco = 점수 합
        if(cal > l) // 제한 칼로리 이하
            return;
        if(idx == n) { // 최대 점수 갱신
            best = Math.max(sco, best);
            return;
        }
        check(idx+1, cal+calory[idx], sco+score[idx]); // 누적 합으로 계산
        check(idx+1, cal, sco);
    }
}
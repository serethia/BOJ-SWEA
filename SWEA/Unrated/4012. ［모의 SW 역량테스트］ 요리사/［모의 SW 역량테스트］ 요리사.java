import java.util.Scanner;
 
public class Solution {
    public static int n;
    public static int r = 2;
    public static int asum;
    public static int bsum;
    public static int similar;
    public static int[][] synergy;
    public static int[] half;
    public static int[] A;
    public static int[] B;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            half = new int[n / 2]; // 절반으로 나누는 조합 배열
            synergy = new int[n][n];
            similar = Integer.MAX_VALUE; // A와 B의 Sij 합의 총합의 절대값 차의 최소값
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    synergy[r][c] = sc.nextInt();
                }
            }
            // 음식 A,B에 선택된 재료들 배열
            A = new int[n / 2];
            B = new int[n / 2];
            // A,B의 synergy 값의 총합
            asum = 0;
            bsum = 0;
 
            divide(0, 0);
 
            System.out.println("#" + tc + " " + similar);
        }
    }
 
    public static void divide(int idx, int jdx) {
        if (jdx == n / 2) {
            A = half; // 선택된 half 조합을 A로 갱신
            int[] nums = new int[n]; // 0 ~ n-1 까지 숫자 배열 임시 생성
            for(int a = 0; a < n; a++) {
                nums[a] = a;
            }
            // A에 없는 번호를 B에 넣는다
            int b = 0;
            for (int j = 0; j < n; j++) {
                boolean exist = false;
                for (int k = 0; k < n / 2; k++) {
                    if(nums[j] == A[k]) {
                        exist = true;
                        break;
                    }
                }
                if(!exist) {
                    B[b++] = nums[j];
                }
            }
 
            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    asum += synergy[A[i]][A[j]] + synergy[A[j]][A[i]];
                }
            }
            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    bsum += synergy[B[i]][B[j]] + synergy[B[j]][B[i]];
                }
            }
 
            similar = Math.min(Math.abs(asum - bsum), similar); // 합의 차의 최소값을 도출
            asum = 0; // 초기화
            bsum = 0; // 초기화
            return;
        }
        if (idx == n) {
            return;
        }
        half[jdx] = idx;
        divide(idx + 1, jdx + 1);
        divide(idx + 1, jdx);
    }
 
}
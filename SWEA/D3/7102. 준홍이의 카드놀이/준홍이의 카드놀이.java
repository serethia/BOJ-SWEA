import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) { // 테케
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] ncard = new int[n];
            int[] mcard = new int[m];
            for (int i = 0; i < n; i++) {
                ncard[i] = i + 1; // 1~n까지 저장
            }
            for (int j = 0; j < m; j++) {
                mcard[j] = j + 1; // 1~m까지 저장
            }
 
            int[] cnt = new int[n + m + 1]; // 카운트(확률) 배열 (인덱스 0 ~ n+m번)
            int maxcnt = 0; // 최대 카운트
            for (int i = 0; i < ncard.length; i++) {
                for (int j = 0; j < mcard.length; j++) {
                    cnt[ncard[i] + mcard[j]]++;
                    if (maxcnt < cnt[ncard[i] + mcard[j]]) {
                        maxcnt = cnt[ncard[i] + mcard[j]];
                    }
 
                }
            }
 
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < cnt.length; k++) {
                if (cnt[k] == maxcnt) {
                    sb.append(k + " ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println("#" + tc + " " + sb);
        }
    }
}
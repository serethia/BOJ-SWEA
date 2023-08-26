import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            Queue<String> qmore = new LinkedList<>(); // 홀수 개면 이 쪽이 1개 많도록
            Queue<String> qless = new LinkedList<>();
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            for (int j = 0; j < (n + 1) / 2; j++) { // 절반 나눠서 분배
                qmore.offer(arr[j]);
            }
            for (int j = (n + 1) / 2; j < n; j++) {
                qless.offer(arr[j]);
            }
            StringBuilder sb = new StringBuilder();
            while (!qmore.isEmpty() || !qless.isEmpty()) {
                if (!qmore.isEmpty()) {
                    sb.append(" " + qmore.poll()); // 교대로 쌓기
                }
                if (!qless.isEmpty()) {
                    sb.append(" " + qless.poll());
                }
            }
            System.out.println("#" + tc + sb);
        }
    }
}
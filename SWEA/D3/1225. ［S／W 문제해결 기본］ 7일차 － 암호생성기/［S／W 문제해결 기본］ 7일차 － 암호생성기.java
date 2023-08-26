import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int t = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for (int j = 1; j <= 8; j++) {
                q.offer(sc.nextInt());
            }
 
            cycle: while (true) {
                for (int i = 1; i <= 5; i++) {
                    int head = q.poll();
                    if (head - i <= 0) {
                        head = 0;
                        q.offer(head);
                        break cycle;
                    }
                    head -= i;
                    q.offer(head);
                }
            }
 
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                sb.append(" " + q.poll());
            }
            System.out.println("#" + tc + sb);
        }
    }
}
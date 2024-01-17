import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int[] dice = new int[7]; // 1 ~ 6
        for (int i = 0; i < 3; i++) {
            dice[Integer.parseInt(st.nextToken())]++;
        }
        int ans = 0;
        int max = 0;
        for (int i = 1; i <= 6; i++) {
            if (dice[i] == 3) {
                ans = Math.max(10000 + 1000 * i, ans);
            } else if (dice[i] == 2) {
                ans = Math.max(1000 + 100 * i, ans);
            } else {
                if (dice[i] == 1) {
                    max = Math.max(max, i);
                }
                ans = Math.max(100 * max, ans);
            }
        }
        System.out.println(ans);
    }
}
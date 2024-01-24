import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int[] want = { 1, 1, 2, 2, 2, 8 };

        for (int i = 0; i < 6; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if (i == 5) {
                sb.append(want[i] - curr);
            } else {
                sb.append(want[i] - curr).append(" ");
            }
        }
        System.out.println(sb);
    }
}
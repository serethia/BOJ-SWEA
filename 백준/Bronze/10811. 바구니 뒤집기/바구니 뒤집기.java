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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n];
        for (int k = 0; k < n; k++) {
            basket[k] = k + 1; // 인덱스 번호: 0 ~ n-1, 값: 1 ~ n
        }
        int i = 0;
        int j = 0;
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            // 인덱스 번호 i,j
            i = Integer.parseInt(st.nextToken()) - 1;
            j = Integer.parseInt(st.nextToken()) - 1;
            while (i < j) { // 역순 정렬
                int tmp = basket[i];
                basket[i] = basket[j];
                basket[j] = tmp;
                i++;
                j--;
            }
        }
        for (int k = 0; k < n; k++) {
            if (k == n - 1) {
                sb.append(basket[k]);
            } else {
                sb.append(basket[k]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
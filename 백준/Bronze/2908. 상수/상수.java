import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        // 둘 다 세자리 수
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        
        int a = first % 10;
        first /= 10;
        int b = first % 10;
        first /= 10;
        int c = first % 10;
        int revfirst = 100 * a + 10 * b + c;
        
        int d = second % 10;
        second /= 10;
        int e = second % 10;
        second /= 10;
        int f = second % 10;
        int revsecond = 100 * d + 10 * e + f;
        
        System.out.println(Math.max(revfirst, revsecond));
    }
}
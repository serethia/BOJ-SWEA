import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 테케 수: 1~1000
        for (int tc = 1; tc <= n; tc++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            String test = token.nextToken();
            String result = token.nextToken();
            String ans = "Possible";
            int[] alphabet = new int[26];
            for (int i = 0; i < test.length(); i++) {
                alphabet[test.charAt(i) - 97]++; // 소문자 ASCII = 97부터
            }
            for (int i = 0; i < result.length(); i++) {
                alphabet[result.charAt(i) - 97]--;
            }
            for (int i = 0; i < 26; i++) {
                if (alphabet[i] != 0) {
                    ans = "Impossible";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
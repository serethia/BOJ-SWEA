import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt(); // 세로
            int m = sc.nextInt(); // 가로
            char[][] num = new char[n][m]; // 문자열로 입력 받고 문자로 변환
            for (int r = 0; r < n; r++) {
                String str = sc.next();
                for (int c = 0; c < m; c++) {
                    num[r][c] = str.charAt(c);
                }
            }
 
            // 역순으로 1 찾은 순간부터 56자를 문자열로 합치기
            String fiftysix = "";
            p: for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = m - 1; c >= 0; c--) {
                    if (num[r][c] == '1') {
                        for (int x = c; x >= c - 55; x--) {
                            sb.append(num[r][x]);
                        }
                        fiftysix = sb.reverse().toString(); // 역순을 다시 정순으로
                        break p;
                    }
                }
            }
 
            // 56자 문자열을 7자씩 8세트 문자열로 분리
            String[] password = new String[8];
            for (int i = 0; i < 8; i++) {
                password[i] = fiftysix.substring(i * 7, (i + 1) * 7);
            }
 
            // map으로 각 암호와 매치되는 수 저장
            Map<String, Integer> code = new HashMap<String, Integer>();
            code.put("0001101", 0);
            code.put("0011001", 1);
            code.put("0010011", 2);
            code.put("0111101", 3);
            code.put("0100011", 4);
            code.put("0110001", 5);
            code.put("0101111", 6);
            code.put("0111011", 7);
            code.put("0110111", 8);
            code.put("0001011", 9);
            int[] pass = new int[8];
            for (int i = 0; i < 8; i++) {
                if (code.containsKey(password[i])) {
                    pass[i] = code.get(password[i]);
                }
            }
 
            // 10의 배수인지 확인 후 맞으면 각 자리 수를 합한 값, 틀리면 0 출력
            int cal = 0;
            int ans = 0;
            cal = (pass[0] + pass[2] + pass[4] + pass[6]) * 3 + (pass[1] + pass[3] + pass[5] + pass[7]);
            if (cal % 10 == 0) {
                for (int i = 0; i < 8; i++) {
                    ans += pass[i];
                }
            } else {
                ans = 0;
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
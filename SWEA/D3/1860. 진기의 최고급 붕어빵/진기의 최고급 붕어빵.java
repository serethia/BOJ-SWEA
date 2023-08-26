import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt(); //명 손님
            int m = sc.nextInt(); //초마다
            int k = sc.nextInt(); //개 빵
 
            // 손님 도착 시간 원본 배열 저장
            int[] arrive = new int[n];
            for (int i = 0; i < n; i++) {
                arrive[i] = sc.nextInt();
            }
 
            // 삽입 정렬 연습 (오름차순)
            for (int i = 1; i < n; i++) {
                int tmp = arrive[i];
                int j = i - 1;
                while (j >= 0 && arrive[j] > tmp) {
                    arrive[j + 1] = arrive[j];
                    j--;
                }
                arrive[j + 1] = tmp;
            }
             
            int fish = 0; // 붕어빵 총 수
            int p = 0; // 도착 시간 배열 인덱스 번호 person
            String result = "Possible";
             
            for (int i = 0; i <= arrive[n-1]; i++) { // 0초~마지막 손님 도착 시간
                if (i != 0 && i % m == 0) { // 빵 만드는 시간
                    fish += k; // 만드는 시간마다 k만큼 생산
                }
                if (p < n && i == arrive[p]) { // 손님 도착 시간이 되면   
                    if (fish <= 0) { // 붕어빵 떨어지면 불가능 확정
                        result = "Impossible";
                        break;
                    }
                    fish--;
                    p++;
                    while (p < n && i == arrive[p-1]) { // 시간 똑같은 손님 모두 처리
                        fish--;
                        p++;
                    }
                }
            }
            System.out.printf("#%d %s%n", tc, result);
        }
    }
}
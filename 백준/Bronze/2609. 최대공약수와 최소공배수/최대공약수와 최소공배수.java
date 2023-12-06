import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double m = sc.nextInt(); // 첫 번째 숫자
		double n = sc.nextInt(); // 두 번째 숫자
		double gcd = 1; // 최대공약수
		double lcm = gcd * m * n; // 최소공배수 = 최대공약수 * 서로소가 된 m,n값
		if (m == n) { // 같은 값일 경우
			gcd = m;
			lcm = m;
		} else { // 다른 값일 경우
			for (int i = 2; i <= Math.min(m, n); i++) { // m,n이 서로소가 될 때까지 반복
				while ((m % i == 0) && (n % i == 0)) { // m과 n의 공약수면
					m = Math.floor(m/i); // i로 나눠 값 갱신 (소수점 버림)
					n = Math.floor(n/i); // i로 나눠 값 갱신 (소수점 버림)
					gcd *= i; // 최대공약수 = 모든 공약수의 곱
					continue;
				}
			}
			lcm = gcd * m * n;
		}
		// 값 출력
		System.out.println((int) gcd);
		System.out.println((int) lcm);
	}
}
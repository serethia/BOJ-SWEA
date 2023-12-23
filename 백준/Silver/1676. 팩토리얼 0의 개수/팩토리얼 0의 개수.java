import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 0 ~ 500 (BigInteger 범위로 나올 것)
		System.out.println(factorial(n));
	}

	public static int factorial(int x) { // 10의 약수의 개수를 구한다. (0! = 1)
		int count = 0; // 짝수 = 2의 배수. 즉, 5의 배수 개수만 구한다
		while (x >= 5) {
			count += (x / 5); // 5, 25, 125로 모두 나눠보기 위함
			x /= 5;
		}
		return count;
	}
}
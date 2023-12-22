import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 666; // 해당 숫자에 666이 있으면
		int cnt = 1; // 카운트 up
		while (cnt < n) { // Brute force
			num++;
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}
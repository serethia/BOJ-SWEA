import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = 1;
		for (int i = 0; i < (str.length() + 1) / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				ans = 0;
			}
		}
		System.out.println(ans);
	}
}
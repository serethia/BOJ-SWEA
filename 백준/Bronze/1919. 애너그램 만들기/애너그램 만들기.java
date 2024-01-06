import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		int[] alphabet = new int[26];
		for (int i = 0; i < first.length(); i++) {
			alphabet[first.charAt(i) - 97]++; // 소문자 ASCII = 97부터
		}
		for (int i = 0; i < second.length(); i++) {
			alphabet[second.charAt(i) - 97]--;
		}
		int cnt = 0;
		for (int i = 0; i < 26; i++) {
			cnt += Math.abs(alphabet[i]);
		}
		System.out.println(cnt);
	}
}
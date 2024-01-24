import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toLowerCase(); // 전부 소문자로 만들기 연습
		int time = 0;
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i); // ASCII로 계산해도 무방할 듯
			if (letter == 'a' || letter == 'b' || letter == 'c') {
				time += 3;
			} else if (letter == 'd' || letter == 'e' || letter == 'f') {
				time += 4;
			} else if (letter == 'g' || letter == 'h' || letter == 'i') {
				time += 5;
			} else if (letter == 'j' || letter == 'k' || letter == 'l') {
				time += 6;
			} else if (letter == 'm' || letter == 'n' || letter == 'o') {
				time += 7;
			} else if (letter == 'p' || letter == 'q' || letter == 'r' || letter == 's') {
				time += 8;
			} else if (letter == 't' || letter == 'u' || letter == 'v') {
				time += 9;
			} else { // w,x,y,z
				time += 10;
			}
		}
		System.out.println(time);
	}
}
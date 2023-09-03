import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] word = str.toCharArray();
		for(int i = 0; i < word.length; i++) {
			if(word[i] >= 97) { //소문자
				word[i] -= 32;
			} else if(word[i] <= 90) { //대문자
				word[i] += 32;
			}
		}
		for(int i = 0; i < word.length; i++) {
			System.out.print(word[i]);
		}
		System.out.println();
	}
}
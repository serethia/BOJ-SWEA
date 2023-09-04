import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		sentence = sentence.trim();
		String[] words = sentence.split(" ");
		if (sentence.length() == 0) {
			System.out.println(0);
		} else {
			System.out.println(words.length);
		}
	}
}
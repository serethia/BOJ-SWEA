import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studies = sc.nextInt(); // 과목 수
		double[] scores = new double[studies]; // 점수 저장 배열
		double m = Integer.MIN_VALUE; // 최대값 m
		// 최대값 뽑기
		for (int i = 0; i < scores.length; i++) {
			scores[i] = sc.nextInt();
			m = Math.max(scores[i], m);
		}
		// 각 점수/m*100 => 모든 점수 합/m*100 => 모든 점수 합 sum
		double sum = 0;
		for (int j = 0; j < scores.length; j++) {
			sum += scores[j];
		}
		// 해당 값을 과목 수로 나눈 결과 값을 '실수(double)'로 출력
		double ans = (sum * 100) / (m * studies);
		System.out.println(ans);
	}
}
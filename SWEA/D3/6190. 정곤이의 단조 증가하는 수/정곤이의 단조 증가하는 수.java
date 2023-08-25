import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int ans = -1; // 출력값
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt(); // arr에 입력값들 저장
			}

			int[] multiple = new int[n * (n - 1) / 2]; // nC2
			int k = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					multiple[k++] = arr[i] * arr[j]; // 두 수의 곱 뽑아서 저장
				}
			}

			cycle: for (int i = 0; i < multiple.length; i++) { // 곱 값 순회
				int front = 0;
				String str = String.valueOf(multiple[i]);
				for (int j = 0; j < str.length(); j++) { // 자릿수 각각 순회
					int rear = Integer.parseInt(String.valueOf(str.charAt(j)));
					if (front <= rear) { // 단조 (앞 자리 <= 뒷 자리)
						front = rear;
					} else { // 단조 아니면 (앞 자리 > 뒷 자리)
						continue cycle;
					}
				}
				ans = Math.max(ans, multiple[i]); // 모든 자릿수 확인 후 단조면 최대값 갱신
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt(); // 1번부터 n번까지
		int k = sc.nextInt(); // k번째를 제거
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1; // 1 ~ n 값 저장
			q.offer(arr[i]); // 선입선출 (직접 확인 결과 7개 크기의 큐에 1,2,3,4,5,6,7 저장 확실하게 됨)
		}
		
		System.out.printf("<");
		while (!q.isEmpty()) {
			for (int i = 0; i < k; i++) {
				if (i != k - 1) {
					q.offer(q.poll());
				} else {
//					System.out.print(q.poll());
//					if (q.size() !=  1) {
//						System.out.print(", ");
//					}
					
					if (q.size() == 1) { // 0 제외한 마지막 원소 뽑을 때는 , 없애기
						System.out.print(q.poll());
						break;
					}
					System.out.print(q.poll() + ", "); // 마지막 직전까지는 , 포함해서 출력
				}
			}
//			for (int i = 0; i < q.size(); i += k) { // 뽑은 후 size 변해가는 것도 반영 (k씩 더하는 건 그대로)
//				if (q.size() == 1) { // 0 제외한 마지막 원소 뽑을 때는 , 없애기
//					System.out.print(q.poll());
//					break;
//				}
//				System.out.print(q.poll() + ", "); // 마지막 직전까지는 , 포함해서 출력
//			}
		}
		System.out.printf(">");
	}
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
			q.offer(arr[i]); //선입선출
		}
		while(q.size() != 1) {
			q.poll();
			int head = q.poll();
			q.offer(head);
		}
		System.out.println(q.poll());
	} 
}
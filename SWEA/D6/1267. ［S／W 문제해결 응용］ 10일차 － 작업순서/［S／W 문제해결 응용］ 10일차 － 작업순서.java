import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			int[][] connect = new int[v + 1][v + 1]; // 1~v번
			int[] entry = new int[v + 1]; // 진입차수
			for (int i = 1; i < e + 1; i++) { // 범위 e 사용 주의, v 아님
				int st = sc.nextInt();
				int ed = sc.nextInt();
				connect[st][ed] = 1;
				entry[ed]++;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i < v + 1; i++) {
				if (entry[i] == 0) { // 시작지점 추가
					q.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()) {
				int curr = q.poll();
				sb.append(" "+curr);
				for(int i = 1; i < v+1; i++) {
					if(connect[curr][i] == 1) {
						connect[curr][i] = 0;
						entry[i]--;
						if(entry[i] == 0) { // 새로운 시작지점 추가
							q.add(i);
						}
					}
				}			
			}
			System.out.println("#"+tc+sb);
		}
	}
}
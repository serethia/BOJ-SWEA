import java.util.Scanner;

public class Solution {
	static int tri;
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 1~n번 정점의 간선 정보 x,y
			int m = sc.nextInt(); // 간선 총 개수인 m줄에 걸쳐서 입력값
			arr = new int[n+1][n+1]; // 0번 안 씀
			tri = 0;
			
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a][b] = arr[b][a] = 1; // 무방향
			}
			
			for(int i = 1; i <= n; i++) {
				for(int j = i+1; j <= n; j++) {
					for(int k = j+1; k <= n; k++) {
						isTriangle(i,j,k);
					}
				}
			}
			System.out.println("#"+tc+" "+tri);
		}		
	}
	
	public static void isTriangle(int i, int j, int k) { // 삼각형 메서드
		if(i<j && j<k) {
			if(arr[i][j] == 1 && arr[j][k] == 1 && arr[k][i] == 1) {
				tri++;
			}
		}
	}
}
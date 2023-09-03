import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		divide(arr, 0, n-1);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
	}
	public static void divide(int[] arr, int l, int r) {
		if(l < r) {
		int m = (l+r)/2;
		divide(arr, l, m);
		divide(arr, m+1, r);
		merge(arr, l, r, m);
		}
	}
	public static void merge(int[] arr, int l, int r, int m) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i = 0; i < n1; i++) {
			L[i] = arr[l+i]; 
		}
		for(int j = 0; j < n2; j++) {
			R[j] = arr[m+1+j];
		}
		int li = 0;
		int ri = 0;
		int arri = l;
		while(li < n1 && ri < n2) {
			if(L[li] < R[ri]) {
				arr[arri++] = L[li++];
			} else {
				arr[arri++] = R[ri++];
			}
		}
		for(;li<n1;li++) {
			arr[arri++] = L[li];
		}
		for(;ri<n2;ri++) {
			arr[arri++] = R[ri];
		}
	}
}
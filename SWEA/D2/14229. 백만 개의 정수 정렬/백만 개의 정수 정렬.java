import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            A[i] = sc.nextInt();
        }
        divide(A, 0, 999999);
        System.out.println(A[500000]);
    }
 
    public static void divide(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            divide(arr, l, m);
            divide(arr, m + 1, r);
            merge(arr, l, r, m);
        }
    }
 
    public static void merge(int[] arr, int l, int r, int m) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i < n1; i++) {
            left[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++) {
            right[i] = arr[m+1+i];
        }
        int a = 0;
        int b = 0;
        int c = l;
        while(a < n1 && b < n2) {
            if(left[a] < right[b]) {
                arr[c++] = left[a++];
            } else {
                arr[c++] = right[b++];
            }
        }
        for(;a<n1;a++) {
            arr[c++] = left[a];
        }
        for(;b<n2;b++) {
            arr[c++] = right[b];
        }
    }
}
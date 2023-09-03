import java.util.Scanner;
 
public class Solution {
    public static int[] heap;
    public static int size = 0;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            System.out.print("#" + tc);
            int n = sc.nextInt();
            heap = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int test = sc.nextInt();
                if (test == 1) {
                    int add = sc.nextInt();
                    hpush(add);
                } else if (test == 2) {
                    System.out.print(" " + hpop());
                }
            }
            System.out.println();
            while(size != 0) {
                hpop();
            }
        }
    }
 
    public static void hpush(int num) {
        heap[++size] = num;
        int child = size;
        int parent = child / 2;
        while (parent >= 1 && heap[child] > heap[parent]) {
            int tmp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = tmp;
 
            child = parent;
            parent = child / 2;
        }
    }
 
    public static int hpop() {
        if (size <= 0)
            return -1;
 
        int root = heap[1];
        heap[1] = heap[size--];
 
        int parent = 1;
        int child = 2 * parent;
        if (child + 1 <= size && heap[child + 1] > heap[child]) {
            child += 1;
        }
        while (child <= size && heap[child] > heap[parent]) {
            int tmp = heap[parent];
            heap[parent] = heap[child];
            heap[child] = tmp;
 
            parent = child;
            child = 2 * parent;
            if (child + 1 <= size && heap[child + 1] > heap[child]) {
                child += 1;
            }
        }
        return root;
    }
}
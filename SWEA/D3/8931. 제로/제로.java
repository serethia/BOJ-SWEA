import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int k = sc.nextInt(); 
            int sum = 0;
             
            int[] arr = new int[k];
            Stack<Integer> stack = new Stack<>();
             
            for(int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
             
            for(int i = 0; i < k; i++) {
                if(arr[i] == 0) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
            while(!stack.isEmpty()) {
                int ele = stack.pop();
                sum += ele;
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
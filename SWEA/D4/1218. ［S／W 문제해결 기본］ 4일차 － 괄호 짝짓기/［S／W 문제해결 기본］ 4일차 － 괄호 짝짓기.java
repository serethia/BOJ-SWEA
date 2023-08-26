import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        test: for (int t = 1; t <= 10; t++) {
            int len = sc.nextInt(); // 테케 길이
            sc.nextLine();
 
            Stack<Character> stack = new Stack<>();
            char[] arr = new char[len];
            arr = sc.nextLine().toCharArray();
             
            for (int i = 0; i < len; i++) {
                if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{' || arr[i] == '<') {
                    stack.push(arr[i]);
                }
                 
                if (arr[i] == ')') {
                    if (stack.pop() != '(') {
                        System.out.println("#" + t + " " + 0);
                        continue test;
                    }
                }
                if (arr[i] == ']') {
                    if (stack.pop() != '[') {
                        System.out.println("#" + t + " " + 0);
                        continue test;
                    }
                }
             
                if (arr[i] == '}') {
                    if (stack.pop() != '{') {
                        System.out.println("#" + t + " " + 0);
                        continue test;
                    }
                }
         
                if (arr[i] == '>') {
                    if (stack.pop() != '<') {
                        System.out.println("#" + t + " " + 0);
                        continue test;
                    }
                }
            } // 왼쪽 괄호들을 push 후 짝인 괄호가 나오면 pop해서 최종적으로 stack이 isEmpty면 유효
 
            if (!stack.isEmpty()) { // 모두 체크한 뒤에 스택이 isEmpty가 아닐 때 0
                System.out.println("#" + t + " " + 0);
            } else { // 짝 조건 모두 만족하고 isEmpty도 유효하면 1
                System.out.println("#" + t + " " + 1);
            }
 
        }
    }
}
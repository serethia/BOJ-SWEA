import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> priority = new HashMap<>(); // 우선 순위
        priority.put('(', 0);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
                 
        for (int tc = 1; tc <= 10; tc++) { // 테케
            int n = sc.nextInt(); // 문자열 계산식 길이
            String str = sc.next();
            Stack<Character> charstack = new Stack<>(); // 연산자 스택
            Stack<Integer> intstack = new Stack<>(); // 피연산자 스택
            char[] arr = new char[n]; // 원본 배열
            char[] sortarr = new char[n]; // 후위 배열
            for (int i = 0; i < n; i++) {
                arr[i] = str.charAt(i);
            }
 
            // 후위 전환 (연산자 스택)
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '+' || arr[i] == '*') {
                    while (!charstack.isEmpty() && priority.get(charstack.peek()) >= priority.get(arr[i])) {
                        sortarr[idx++] = charstack.pop();
                    }
                    charstack.push(arr[i]);
                } else {
                    sortarr[idx++] = arr[i];
                }
            }
 
            for (int j = 0; j < n; j++) {
                while (!charstack.isEmpty() && sortarr[j] == 0) {
                    sortarr[j] = charstack.pop();
                }
            }
 
            // 후위 계산 (피연산자 스택)
            for (int i = 0; i < n; i++) {
                if (sortarr[i] != '+' && sortarr[i] != '*') {
                    intstack.push((sortarr[i]) - '0');
                }
                if (!intstack.isEmpty() && sortarr[i] == '+') {
                    int b = intstack.pop();
                    int a = intstack.pop();
                    intstack.push(a + b);
                }
                if(!intstack.isEmpty() && sortarr[i] == '*') {
                    int b = intstack.pop();
                    int a = intstack.pop();
                    intstack.push(a * b);
                }
            }
            System.out.println("#" + tc + " " + intstack.pop());
        }
    }
}
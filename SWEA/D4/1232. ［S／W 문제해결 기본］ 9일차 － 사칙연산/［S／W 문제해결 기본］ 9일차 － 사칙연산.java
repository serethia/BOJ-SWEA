import java.util.Scanner;
import java.util.Stack;
 
class Node {
    String data;
    Node left;
    Node right;
}
 
public class Solution {
    static Stack<Double> stack;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            stack = new Stack<>();
            int n = sc.nextInt();
            String[] array = new String[n + 1];
            Node[] nodes = new Node[n + 1];
            for (int i = 0; i < nodes.length; i++) { // 노드 초기화
                nodes[i] = new Node();
            }
            for (int i = 1; i < array.length; i++) { // 배열 저장 후 노드에도 저장
                array[sc.nextInt()] = sc.next();
                nodes[i].data = array[i];
                if (array[i].equals("+") || array[i].equals("-") || array[i].equals("*") || array[i].equals("/")) {
                    nodes[i].left = nodes[sc.nextInt()]; // 왼쪽 노드 번호 저장
                    nodes[i].right = nodes[sc.nextInt()]; // 오른쪽 노드 번호 저장
                }
            }
            System.out.print("#" + t + " ");
            postorder(nodes[1]);
            System.out.println((int)(double)stack.pop()); // Double => double => int
        }
    }
 
    public static void postorder(Node node) { //LRV 후위 순회
        //null로 덮어씌워지지 않게 미리 처리
        if (node.left != null) {
            postorder(node.left);
        } 
        if (node.right != null) {
            postorder(node.right);
        }
        if (node.data.equals("+") || node.data.equals("-") || node.data.equals("*") || node.data.equals("/")) {
            double y = stack.pop();
            double x = stack.pop();
            if (node.data.equals("+")) {
                stack.push(x + y);
            }
            if (node.data.equals("-")) {
                stack.push(x - y);
            }
            if (node.data.equals("*")) {
                stack.push(x * y);
            }
            if (node.data.equals("/")) {
                stack.push(x / y);
            }
        } else {
            stack.push(Double.parseDouble(node.data)); // 실수 연산
        }
    }
}
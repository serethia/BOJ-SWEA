import java.util.Scanner;
 
 
// 구현 연습
class Node {
    public int data;
    public Node link;
 
    public Node() {
    }
 
    public Node(int data) {
        this.data = data;
    }
}
 
 
// 구현 연습
class MyLinkedList {
    private Node head;
    private int size;
     
    public Node get(int idx) {
        if (idx < 0 || idx >= size) {
            return null;
        }
         
        Node now = head;
         
        for (int i = 0; i < idx; i++) {
            now = now.link;
        }
         
        return now;
    }
 
    public void addFirst(int data) {
        Node node = new Node(data);
        node.link = head;
        head = node;
        size++;
    }
 
    public void addLast(int data) {
        if (size == 0) {
            addFirst(data);
            return;
        }
         
        Node node = new Node(data);
        Node now = head;
         
        while (now.link != null) {
            now = now.link;
        }
         
        now.link = node;
        size++;
    }
 
    public void add(int idx, int data) {
        if (idx < 0 || idx > size) {
            return;
        }
         
        if (idx == 0) {
            addFirst(data);
            return;
        }
         
        if (idx == size) {
            addLast(data);
            return;
        }
         
        Node node = new Node(data);
        Node prenode = get(idx - 1);
        node.link = prenode.link;
        prenode.link = node;
        size++;
    }
     
    public void remove() {
        if(head == null) {
            return;
        }
         
        head = head.link;
        size--;
    }
     
    public void remove(int idx) {
        if(idx == 0) {
            remove();
            return;
        }
         
        if(idx < 0 || idx >= size) {
            return;
        }
         
        Node node = get(idx);
        Node prenode = get(idx - 1);
        prenode.link = node.link;
        size--;
    }
}
 
 
// 문제 테스트 코드
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for (int tc = 1; tc <= 10; tc++) { // 테케 10개
            MyLinkedList list = new MyLinkedList();
 
            int n = sc.nextInt(); // 암호문 길이
            for (int i = 0; i < n; i++) {
                list.addLast(sc.nextInt()); // 순서 맞춰서 원본 입력값 저장
            }
 
            int w = sc.nextInt(); // 명령어 수
            for (int i = 0; i < w; i++) {
                String str = sc.next();
                if (str.equals("I")) { // 한 삽입 명령어 세트 시작
                    int x = sc.nextInt(); // 삽입 위치 번호
                    int y = sc.nextInt(); // 삽입할 숫자 개수
                    for (int j = 0; j < y; j++) {
                        list.add(x + j, sc.nextInt()); // x+j여야 삽입 순서 유지 가능
                    }
                } else if (str.equals("D")) { // 한 삭제 명령어 세트 시작
                    int dx = sc.nextInt(); // 삭제 위치 번호
                    int dy = sc.nextInt(); // 삭제할 숫자 개수
                    for(int dj = 0; dj < dy; dj++) {
                        list.remove(dx);
                    }
                } else if (str.equals("A")) { // 한 추가 명령어 세트 시작
                    int ay = sc.nextInt(); // 맨 뒤에 추가할 숫자 개수
                    for(int aj = 0; aj < ay; aj++) {
                        list.addLast(sc.nextInt());
                    }                   
                }
            }
 
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 10; i++) { // 처음 10개 항만
                System.out.print(list.get(i).data + " ");
            }
            System.out.println();
        }
    }
}
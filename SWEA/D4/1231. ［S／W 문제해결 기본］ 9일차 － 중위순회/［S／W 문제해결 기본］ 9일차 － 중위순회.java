import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) { // 테케 10개
            int n = sc.nextInt(); // 트리 노드 수
            char[] arr = new char[n+1]; // 0번은 비워두기
            // 노드마다 문자 값 저장
            if (n % 2 == 0) { // 짝수 개면
                for (int i = 1; i < n+1; i++) { // 0번 빼고 1~n번 돌아서 입력받기
                    arr[sc.nextInt()] = sc.next().charAt(0); // 인덱스 번호와 문자 받기
                    if (i == n / 2) {
                        sc.nextInt(); // 1번 뽑아내고 버리기
                    } else if (i < n / 2) {
                        sc.nextInt();
                        sc.nextInt(); // 2번 뽑아내고 버리기
                    }
                }
            } else { // 홀수 개면
                for (int i = 1; i < n+1; i++) { // 0번 빼고 1~n번 돌아서 입력받기
                    arr[sc.nextInt()] = sc.next().charAt(0); // 인덱스 번호와 문자 받기
                    if (i <= n / 2) {
                        sc.nextInt();
                        sc.nextInt(); // 2번 뽑아내고 버리기
                    }
                }
            }
            // 중위 순회 출력
            System.out.print("#"+tc+" ");
            inorder(arr, 1);
            System.out.println();
        }
    }
     
    // 중위 순회 메서드 작성
    public static void inorder(char[] array, int index) {
        if(index < array.length) {
            inorder(array, 2*index);
            if(array[index] != ' ') {
                System.out.print(array[index]);
            }
            inorder(array, 2*index+1);
        }
    }
}
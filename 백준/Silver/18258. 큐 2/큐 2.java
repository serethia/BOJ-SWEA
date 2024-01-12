import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 큐: 배열로 구현 (맨 앞 = 맨 처음)
public class Main {
    static int[] q;
    static int idx = 0; // 맨 앞
    static int jdx = 0; // 맨 뒤

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 2,000,000
        q = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken()); // 1 ~ 100,000
                push(num);
            }
            if (str.equals("pop")) {
                sb.append(pop());
                if (i < n - 1) {
                    sb.append('\n');
                }
            }
            if (str.equals("size")) {
                sb.append(size());
                if (i < n - 1) {
                    sb.append('\n');
                }
            }
            if (str.equals("empty")) {
                sb.append(empty());
                if (i < n - 1) {
                    sb.append('\n');
                }
            }
            if (str.equals("front")) {
                sb.append(front());
                if (i < n - 1) {
                    sb.append('\n');
                }
            }
            if (str.equals("back")) {
                sb.append(back());
                if (i < n - 1) {
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    public static void push(int x) { // x 넣기
        q[jdx++] = x;
    }

    public static int pop() { // 맨 앞 *빼고* 출력, 없으면 -1 출력
        int num = front();
        if (size() > 0) {
            q[idx] = 0;
            idx++;
        }
        return num;
    }

    public static int size() { // 개수 출력
        return jdx - idx;
    }

    public static int empty() { // 비었으면 1, 아니면 0 출력
        if (size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() { // 맨 앞 출력, 없으면 -1 출력
        if (size() == 0) {
            return -1;
        }
        return q[idx];
    }

    public static int back() { // 맨 뒤 출력, 없으면 -1 출력
        if (size() == 0) {
            return -1;
        }
        return q[jdx - 1];
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 시간 단축 (+ while 사용 시 시간 초과)
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double a = Double.parseDouble(st.nextToken()); // 낮에 올라가는 meter
		double b = Double.parseDouble(st.nextToken()); // 밤에 내려오는 meter (정상에서는 X)
		double v = Double.parseDouble(st.nextToken()); // 막대 높이
		double cnt = Math.ceil((v - b) / (a - b)); // 출력할 일수 => [(a-b)*cnt + b >= v] => [cnt >= (v-b)/(a-b)]을 올림
		System.out.println((int) cnt);
	}
}
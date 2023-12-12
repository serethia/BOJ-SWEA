import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class User implements Comparable<User> {
		int age;
		String name;
		int registAt;

		public User(int age, String name, int registAt) {
			this.age = age;
			this.name = name;
			this.registAt = registAt;
		}

		@Override
		public int compareTo(User o) {
			// TODO Auto-generated method stub
			// 1. 나이를 비교
			int ageresult = Integer.compare(this.age, o.age);
			if (ageresult == 0) { // 나이가 같다면
				// 2. 가입순을 비교
				int registresult = Integer.compare(this.registAt, o.registAt);
				return registresult;
			} else { // 나이가 다르면
				return ageresult; // 비교 결과 반환
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 시간 단축용

		// 입력값 저장
		int n = Integer.parseInt(br.readLine());
		List<User> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken()); // 나이
			String name = st.nextToken();
			int registAt = i + 1; // 가입 순서
			list.add(new User(age, name, registAt));
		}

		// 정렬 (클래스에 작성한 대로)
		Collections.sort(list);

		// 출력
		StringBuilder sb = new StringBuilder();
		for (User u : list) {
			sb.append(u.age).append(" ").append(u.name).append("\n");
		}
		System.out.println(sb);
	}
}
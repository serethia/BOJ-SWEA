import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 시간 단축용

		// 입력값 저장
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}

		// 중복 제거
		List<String> list = new ArrayList<>();
		for (String word : words) {
			if (!list.contains(word)) { // list에 없을 경우에만 (set 너무 까다로움)
				list.add(word); // 삽입
			}
		}

		// 정렬 (길이순 => 사전순) : sort 함수로 대체해 시간 단축 (java8부터 사용 가능)
		// Comparator를 통한 람다 식 : comparing 기준으로 비교한 후, 같다면 thencomparing 기준으로 비교.
		// String::length : String 클래스를 길이 순으로 정렬
		// Comparator.naturalOrder() : 오름차순 정렬
		Collections.sort(list,
				Comparator.<String, Integer>comparing(String::length).thenComparing(Comparator.naturalOrder()));
//		int len = list.size();
//		for (int i = 0; i < len - 1; i++) {
//			for (int j = i + 1; j < len; j++) {
//
//				if (list.get(i).length() == list.get(j).length()) { // 길이가 같다면
//					if (list.get(i).compareTo(list.get(j)) > 0) { // 사전 순으로 (if 현재 대상 > 비교 대상)
//						String temp = list.get(i);
//						list.set(i, list.get(j));
//						list.set(j, temp); // 현재 대상 < 비교 대상 (사전 순) 으로 swap
//					}
//				} else if (list.get(i).length() > list.get(j).length()) { // 짧은 게 앞으로
//					String str = list.get(i);
//					list.set(i, list.get(j));
//					list.set(j, str);
//				} else { // 그 외
//					continue;
//				}
//
//			}
//		}

		// 출력
		StringBuilder sb = new StringBuilder(); // 시간 단축용
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}
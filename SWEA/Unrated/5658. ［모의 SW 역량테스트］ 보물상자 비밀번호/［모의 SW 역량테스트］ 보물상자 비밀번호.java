import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 숫자 총 개수
			int k = sc.nextInt(); // 번째로 큰
			String str = sc.next(); // 입력값 한 줄 전부 받기
			int div = n / 4; // 한 변에 들어갈 글자수 = 초기화되는 회전 수
			char[] letter = new char[str.length()];
			for(int i = 0; i < letter.length; i++) { // 한 글자씩 쪼개 저장
				letter[i] = str.charAt(i);
			}
			
			LinkedList<Character> wordlist = new LinkedList<>(); // 회전 용이 list
			ArrayList<Integer> arrlist = new ArrayList<>(); // 10진수 변환값 저장
			for(int i = 0; i < n; i++) {
				wordlist.add(letter[i]);
			}
		
			// 시계방향 회전
			for(int i = 0; i < div; i++) { // n/4번째 회전 = 0번째 회전
				ArrayList<Integer> tmp = new ArrayList<>(); // 생성된 수 임시 저장
				
				for(int j = 0; j < n; j += div) { // 한 변의 길이만큼 이동
					String cut = ""; 
					for(int m = j; m < j + div; m++) { // 생성 글자(숫자) 합치기
						cut += wordlist.get(m);
					}
					tmp.add(Integer.parseInt(cut, 16)); // 16진수 string => 10진수 int
					
					// 중복 체크 후 추가
					for(int m = 0; m < tmp.size(); m++) {
						if(!arrlist.contains(tmp.get(m))) { // 중복 아닐 때만 추가
							arrlist.add(tmp.get(m)); 
						}
					}
				}
				
				// 회전할 때마다 마지막 원소가 맨 앞으로
				char last = wordlist.remove(n-1);
				wordlist.add(0, last);
			}
			
			// 내림차순 후 k번째(k-1번 인덱스)로 큰 수
			Collections.sort(arrlist, Collections.reverseOrder());
			System.out.println("#" + tc + " " + arrlist.get(k-1));
		}
	}
}
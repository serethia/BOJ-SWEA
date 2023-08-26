import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            String quiz = sc.next();
            String ans = sc.next();
            int correct = 0;
            for(int i = 0; i < quiz.length(); i++) {
            	if(quiz.charAt(i) == (ans.charAt(i))){
            		correct++;
            	}
            }            
            System.out.println("#" + tc + " " + correct);
        }
    }
}
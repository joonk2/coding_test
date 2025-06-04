import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] scores_lst = br.readLine().split(" ");
		double[] scores = new double[scores_lst.length];
//		System.out.println(Arrays.toString(scores));
		
		double max_val = Integer.MIN_VALUE;
		for (int i = 0; i < scores_lst.length; i++) {
			scores[i] = Integer.parseInt(scores_lst[i]);
			if (scores[i] > max_val) {
				max_val = scores[i];
			}
		}
//		System.out.println(Arrays.toString(scores));
		
		double total_score = 0;
		for (int i = 0; i < scores.length; i++) {
			scores[i] = (scores[i]/max_val)*100;
//			System.out.println(scores[i]);
			total_score += scores[i];
		}
		System.out.println(total_score/N);
		
		
	}
}
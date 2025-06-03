import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] checked = new boolean[31];
		for (int i = 0; i < 28; i++) {
			int student = Integer.parseInt(br.readLine());
			checked[student] = true;
		}
//		System.out.println(Arrays.toString(checked));
		
		
		int idx = 0;
		int[] box = new int[2];
		for (int i = 1; i < 30+1; i++) {
			if (!checked[i]) {
				box[idx++] = i;
			}
		}
		Arrays.sort(box);
//		System.out.println(Arrays.toString(box));
		
		for (int i : box) {
			System.out.println(i);
		}
		
	}
}
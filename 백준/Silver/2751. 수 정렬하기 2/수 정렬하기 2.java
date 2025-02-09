/*
CountSort  

[cond]
1.  -1000000 <= num <= 1000000
2. 숫자가 중복되는 경우도 함께 생각해라
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// CountSort
		int[] cnt_lst = new int[2000001];
		for (int i = 0; i < N; i++) {
			cnt_lst[Integer.parseInt(br.readLine()) + 1000000]++;
		}
		
		// cond
		for (int i = 0; i < cnt_lst.length; i++) {
			while (cnt_lst[i]-- > 0) {
				sb.append(i-1000000 + "\n");
			}
		}
		System.out.println(sb);
		
		
		
		
	}
}
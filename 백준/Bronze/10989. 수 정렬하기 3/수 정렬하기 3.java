import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// print optimization
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine());
		int[] cnt_lst = new int[10001]; // 1~10000
		
		// counting num
		for (int i = 0; i < N; i++) {
			cnt_lst[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i < 10001; i++) {
			while (cnt_lst[i]-- > 0) {
				sb.append(i).append('\n'); 
			}
		} 
		
		System.out.print(sb);
	}
}


/*
10
5
2
3
1
4
2
3
5
1
7
*/
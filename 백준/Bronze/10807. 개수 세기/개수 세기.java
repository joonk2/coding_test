import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] lst = br.readLine().split(" ");
		int target_num = Integer.parseInt(br.readLine());
		
		int[] num_lst = new int[lst.length];
//		System.out.println(num_lst.length);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			num_lst[i] = Integer.parseInt(lst[i]);
			if (num_lst[i] == target_num) {
				cnt++;
			}
		}
//		System.out.println(Arrays.toString(num_lst));
		System.out.println(cnt);
		
		
		
		
	}
}
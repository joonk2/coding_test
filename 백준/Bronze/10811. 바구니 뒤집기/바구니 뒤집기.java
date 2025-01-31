import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s_arr = br.readLine().split(" ");
		int N = Integer.parseInt(s_arr[0]);
		int M = Integer.parseInt(s_arr[1]);
		StringBuilder sb = new StringBuilder();
		
		
		int[] bucket = new int[N];
		for (int i = 0; i < N; i++) {
			bucket[i] = i+1;
		}
		
		for (int k = 0; k < M; k++) {
			String[] arr = br.readLine().split(" ");
			int i = Integer.parseInt(arr[0])-1;
			int j = Integer.parseInt(arr[1])-1;
			
			while (i < j) {
				int temp = bucket[i];
				bucket[i] = bucket[j];
				bucket[j] = temp;
				i++;
				j--;
			}
		}
		
		for (int n : bucket) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb);
		
		
	}
}
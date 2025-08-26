import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, K;
	static int[] arr;
	static int left;
	static int cnt_K;
	static int min_leng, temp_leng;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		String[] str_arr = br.readLine().split(" ");
		int res = min_subset_leng(NK, str_arr);
		System.out.println(res);
	}
	
	
	
	public static int min_subset_leng(String[] NK, String[] str_arr) {
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		
		
		cnt_K = 0;
		left = 0;
		min_leng = -1;
		temp_leng = 1000001;
		
		for (int right = 0; right < N; right++) {
			if (arr[right] == 1) cnt_K++;
			
			while (cnt_K >= K) {
				temp_leng = Math.min(temp_leng, right - left + 1);
				if (arr[left] == 1) cnt_K--;
				left++;
			}
		}
		
		
		
				
		if (temp_leng < 1000001) {
			min_leng = temp_leng;
		}
		return min_leng;
		
	}
	
	
	
	
}
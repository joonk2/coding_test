import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] N_arr = br.readLine().split(" ");
		int[] N_lst = new int[N_arr.length];
		
		for (int i = 0; i < N; i++) {
			N_lst[i] = Integer.parseInt(N_arr[i]);
		}
		
		Arrays.sort(N_lst);
		
		
		int M = Integer.parseInt(br.readLine());
		String[] M_arr = br.readLine().split(" ");
		
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(M_arr[i]);
			
			if (binary_search(N_lst, target) == true) {
				sb.append(1 + " ");
			}
			else {
				sb.append(0 + " ");
			}
		}
		
		System.out.println(sb);
		
	}
	
	
	
	public static boolean binary_search(int[] lst, int key) {
		int left = 0;
		int right = lst.length-1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (lst[mid] == key) {
				return true;
			}
			else if (lst[mid] < key) {
				left = mid + 1;
			}
			else if (lst[mid] > key) {
				right = mid - 1;
			}
			
		}
		
		return false;
		
		
	}
	
	
	
}
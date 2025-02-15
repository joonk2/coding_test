import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] N_arr = br.readLine().split(" ");
		
		int[] N_lst = new int[N];
		for (int i = 0; i < N; i++) {
			N_lst[i] = Integer.parseInt(N_arr[i]);
		}
		
		Arrays.sort(N_lst);
		
		
		
		int M = Integer.parseInt(br.readLine());
		String[] M_arr = br.readLine().split(" ");
		
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(M_arr[i]);
			if (binary_search(N_lst, target) == true) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
		
	}	
	
	
	
	// binary search
	public static boolean binary_search(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			// if success at one queue
			if (arr[mid] == key) {
				return true;
			}
			else if (arr[mid] < key) {
				left = mid + 1;
			}
			else if (arr[mid] > key) {
				right = mid - 1;
			}
		}
		
		// if there's no number to compare
		return false;
		
	
		
		
		
	}
	
	
	
	
	
	
}
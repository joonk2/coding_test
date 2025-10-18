/*
1초 -> java 1억 연산 이내

정렬 N log N -> 100만 log 100만 -> 약 2000만
binary_search -> log N -> 약 20

충분히 1억 연산 이내에 가능하네
*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		String[] s_arr = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s_arr[i]);
		}
		Arrays.sort(arr);
		
		what_is_the_answer(M, N, arr);
	}
	
	
	
	static void what_is_the_answer(int M, int N, int[] arr) {
		long res = 0;
		long left = 1;
		long right = arr[N-1];
		while (left <= right) {
			long mid = (left + right) / 2;
			if (can_make_snack_bigger(M, N, arr, mid)) {
				res = mid;
				left = mid + 1;
			}
			else if (!can_make_snack_bigger(M, N, arr, mid)) {
				right = mid - 1;
			}
		}
		System.out.println(res);
	}
	
	
	
	
	static boolean can_make_snack_bigger(int M, int N, int[] arr, long mid) {
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += (long) (arr[i] / mid);
		}
		if (cnt >= M) {
			return true;
		}
		return false;
	}
	
	
	
}
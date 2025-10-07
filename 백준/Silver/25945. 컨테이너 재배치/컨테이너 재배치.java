/*
# input
4
3 3 3 9

# output
5


--- 흐름 ---
1. 정렬
2. 반복문
- 평균보다 큰 것과, 작은 것에 대한 각 누적합을 구하고
비교 후 큰 값 채택
*/


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s_arr = br.readLine().split(" ");
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s_arr[i]);
			if (arr[i] > max) max = arr[i];
			sum += arr[i];
		}
		
		int avg = sum / N;
		
		int cnt_1 = 0;
		int cnt_2 = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] <= avg) {
				cnt_1 += (avg - arr[i]);
			}
			else if (arr[i] > (avg + 1)) {
				cnt_2 += (arr[i] - (avg + 1));
			}
		}
		System.out.println(Math.max(cnt_1, cnt_2));
		
	}

}
/*
누적합시 
{1,3,6,7,9}

M으로 나누었을때 나머지 배열
{1,0,0,1,0}

정방향 A[0] 포함하여 셀 때 (3개)
A[0] + A[1]
A[0] + A[1] + A[2]
A[0] + A[1] + A[2] + A[3] + A[4]


조합을 위한 배열 (A[1] 부터 찾기)
C = new long[M];
C = {3, 2, 0}

M으로 나누어 떨어지는 구간의 갯수 세기 --> 4개
A[1] + A[2] + A[3]
A[2]
A[2] + A[3] + A[4]
A[3] + A[4]

도합 7개
*/



import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int N, M;
	static long[] A, S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		A = new long[N];
		S = new long[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(arr[i]);
		}
		
		// prefix_sum
		S[0] = A[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];
		}
		
		// remainder
		long[] S_remainder = new long[N];
		long[] C = new long[M];
		long res = 0;
		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M);
			S_remainder[i] = remainder;
			if (remainder == 0) res++;
			C[remainder]++;
		}
		
		// combination
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				res += (C[i] * (C[i]-1)) / 2;
			}
		}
		
		System.out.println(res);
	}
}
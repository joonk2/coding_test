/*
0일 경우에 이미 지운 수니까 continue로 건너뛰면서,
배수를 오름차순으로 증가시키면서 지워주자 (!=0 이면 =0 처리)
배수르 지우자 그리고 K--
이제 K == 0 이면 그 수를 출력하고 return(종료)
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;



public class Main {
	static int N, K;
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		IsPrimeNumber(N, K);
		
		
	}
	
	
	
	public static void IsPrimeNumber(int N, int K) {
		int[] arr = new int[N+1];
		for (int i = 2; i < N+1; i++) {
			arr[i] = i;
		}
		
		for (int i = 2; i < N+1; i++) {
			if (arr[i] == 0) {
				continue;
			}
			
			for (int j = i; j < N+1; j += i) {
				if (arr[j] != 0) {
					arr[j] = 0;
					K--;
					
					if (K == 0) {
						System.out.println(j);
						return;
					}
					
					
				}
			}
		}
		
	}
	
	
}
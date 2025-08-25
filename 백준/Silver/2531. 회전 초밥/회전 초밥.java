import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Main {
	static int N, d, k, c;
	static int[] sushi;
	static int[] eaten;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] Ndkc = br.readLine().split(" ");
		N = Integer.parseInt(Ndkc[0]);
		d = Integer.parseInt(Ndkc[1]);
		k = Integer.parseInt(Ndkc[2]);
		c = Integer.parseInt(Ndkc[3]);
		
		sushi = new int[N];
		eaten = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int res = how_many_max_sushi(N, k, c, sushi, eaten);
		System.out.println(res);
	}
	
	
	
	
	
	
	public static int how_many_max_sushi(int N, int k, int c, int[] sushi, int[] eaten) {
		int max_leng = 0;
		int temp_leng = 0;
		
		// 초기값 설정
		// (idx 0 ~ k-1 만큼 초밥 먹었다)
		// 만약 처음 먹는 종류라면 그 갯수도 추가
		for (int i = 0; i < k; i++) {
			int idx = sushi[i];
			if (eaten[idx] == 0) {
				temp_leng++;
			}
			eaten[idx]++;
		}

		// 초기 최댓값 갱신
		if (temp_leng > max_leng) max_leng = temp_leng;
		
		
		
		
		
		
		// 슬라이딩 윈도우 && 투포인터 && 원형 큐
		// 먼저 맨 앞의 초밥을 빼주고, 그다음 뒤의 초밥을 더한다
		int start = 0;
		int end = k;
		while (start < N) {
			
			// 맨 앞의 초밥 빼기
			// 만약 0이 되면 임시 최대길이-1
			int idx_s = sushi[start];
			eaten[idx_s]--;
			if (eaten[idx_s] == 0) temp_leng--;
			start++;
			
			// 뒤에 초밥 더하기
			int idx_e = sushi[end % N];
			if (eaten[idx_e] == 0) {
				temp_leng++;
			}
			eaten[idx_e]++;
			end++;
			
			
			// 쿠폰초밥 길이 갱신 --> 취식 여부 
			int cur_leng = temp_leng;
			if (eaten[c] == 0) {
				cur_leng++;
			}
			
			// 최종 갱신
			if (cur_leng > max_leng) max_leng = cur_leng;
		}
		
		
		
		
		
		
		return max_leng;
	}
	
	
	
	
	
	
	
}
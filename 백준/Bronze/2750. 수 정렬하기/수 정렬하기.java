import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] res = bubble_sort(arr);
//		System.out.println(Arrays.toString(res));
		for (int i : res) {
			System.out.println(i);
		}
		
	}
	
	
	public static int[] bubble_sort(int[] arr) {
		// 맨 뒤의 idx부터 거꾸로 오름차순을 통해 완성하며
		// 완성된 곳은 보지 않도록 범위를 줄인다
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	
}
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		arr = bubble_sort(arr);
		
		int res_1 = avg(arr);
		int res_2 = median(arr);
		
		System.out.println(res_1);
		System.out.println(res_2);
	}
	
	
	public static int median(int[] int_arr) {
		int res = 0;
		int left = 0;
		int right = int_arr.length - 1;
		
		int mid = (left + right) / 2;
		res = int_arr[mid];
		return res;
	}
	
	
	public static int avg(int[] int_arr) {
		int N = int_arr.length;
		int sum = 0;
		for (int i : int_arr) {
			sum += i;
		}
		sum = (sum / N);
		return sum;
	}
	
	
	
	public static int[] bubble_sort(int[] int_arr) {
		for (int i = 0; i < int_arr.length-1; i++) {
			for (int j = 0; j < int_arr.length-1-i; j++) {
				if (int_arr[j] > int_arr[j+1]) {
					int temp = int_arr[j];
					int_arr[j] = int_arr[j+1];
					int_arr[j+1] = temp;
				}
			}
		}
		return int_arr;
	}
	
}
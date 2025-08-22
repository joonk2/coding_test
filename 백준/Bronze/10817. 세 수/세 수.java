import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ABC = br.readLine().split(" ");
		int res = solution(ABC);
		System.out.println(res);
	}
	
	
	public static int solution(String[] ABC) {
		int[] arr = new int[ABC.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(ABC[i]);
		}
		
		// BubbleSort
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}	
		return arr[1];
	}
	
	
	
}
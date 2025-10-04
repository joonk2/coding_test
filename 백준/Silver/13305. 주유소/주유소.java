import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dist, price;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] dist_arr = br.readLine().split(" ");
		String[] price_arr = br.readLine().split(" ");
		dist = new int[dist_arr.length];
		price = new int[N];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.parseInt(dist_arr[i]);
		}
		for (int i = 0; i < price.length; i++) {
			price[i] = Integer.parseInt(price_arr[i]);
		}
		
		what_is_the_answer();
	}
	
	
	
	
	static void what_is_the_answer() {
		long total_cost = 0;
		long min_price = price[0];
		for (int i = 0; i < price.length-1; i++) {
			min_price = Math.min(price[i], min_price);
			total_cost += (dist[i] * min_price);
		}
		System.out.println(total_cost);
	}
	
	
	
}
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        for (int x = 1; x < M+1; x++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            for (int y = i; y < j+1; y++) {
                arr[y] = k;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            sb.append(arr[i] + " ");
        }
        
        
        System.out.println(sb.toString().trim());
        
        
        
        
    }
}
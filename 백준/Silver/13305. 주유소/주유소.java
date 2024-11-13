import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 갯수
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1]; // 거리
        long[] cost = new long[N]; // 비용

        // 거리 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }


        // 리터당 기름 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long min_cost = cost[0];

        // 주유 최소비용
        for (int i = 0; i < N-1; i++) {
            // 현재 값보다 저렴하면 갱신
            if (cost[i] < min_cost) {
                min_cost = cost[i];
            }
            sum += (min_cost * dist[i]);

        }

        System.out.println(sum);
    }
}
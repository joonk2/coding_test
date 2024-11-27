import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> arr = new ArrayList<>();

        int min_sum = 0;
        int cumsum_time = 0;

        // arr
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // asc
        Collections.sort(arr);

        // cumsum
        for (int a : arr) {
            cumsum_time += a;
            min_sum += cumsum_time;
        }

        // res
        System.out.println(min_sum);


    }
}
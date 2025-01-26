import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        long[] arr = new long[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine()); 
        }

        Arrays.sort(arr); 

        long max = arr[N - 1]; 
        long sumOfOthers = 0; 

        for (int i = 0; i < N - 1; i++) {
            sumOfOthers += arr[i];
        }

        if (max > sumOfOthers) {
            System.out.println(max - sumOfOthers); 
        }
        else {
            // 최댓값과 나머지 합의 합이 홀수인지 짝수인지 확인
            if ((max + sumOfOthers) % 2 == 0) {
                System.out.println(0);
            } else {
                System.out.println(1); 
            }
        }
    }
}
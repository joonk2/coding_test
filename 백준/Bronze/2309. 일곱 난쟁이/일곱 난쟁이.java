import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Main {
    static int[] arr;
    static int sum;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        sum = 0;

        // 1. 9난쟁이의 키 입력 및 합산
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 2. 난쟁이 2마리의 키 0cm으로 변경 후, 오름차순 정렬
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);

                    for (int k = 2; k < 9; k++) {
                        System.out.println(arr[k]);
                    }

                    // 3. 원하는 것을 찾았으면, 3중 반복문 탈출
                    return;
                }
            }
        }



    }
}

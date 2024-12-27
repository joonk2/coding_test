/*
ex)

5 / 4 3 2 1 2
3 / 4 1 1

->

A[4] = 1
A[3] = 1
A[2] = 2
A[1] = 1

B[4] = 1
B[3] = 0
B[2] = 0
B[1] = 1
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int[] A_arr = new int[101];
            int A = Integer.parseInt(st.nextToken());
            for (int j = 0; j < A; j++) {
                A_arr[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine().trim());
            int[] B_arr = new int[101];
            int B = Integer.parseInt(st.nextToken());
            for (int j = 0; j < B; j++) {
                B_arr[Integer.parseInt(st.nextToken())]++;
            }

            for (int j = 100; j > 0; j--) {
                if (A_arr[j] > B_arr[j]) {
                    System.out.println("A");
                    break;
                }
                else if (A_arr[j] < B_arr[j]) {
                    System.out.println("B");
                    break;
                }
                if (j == 1) {
                    System.out.println("D");
                    break;
                }
            }

            
            
        }
        
        
        
    }
}
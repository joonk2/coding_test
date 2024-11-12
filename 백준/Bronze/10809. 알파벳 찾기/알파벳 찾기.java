// 입출력 예제 설명

// 아래는 String S
// 0 1 2 3 4 5 6 7
// b a c k j o o n

// 아래는 arr
// a b c d e f g h i j ... z
// 0 1 2 3 4 5 6 7 8 9     25
// 1 0-1-1 2-1-1-1-1 4     -1

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // -1로 된 알파벳 갯수 26개 배열 생성
        int arr[] = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }

        // 결과 출력
        for (int var : arr) {
            System.out.print(var + " ");
        }
    }
}
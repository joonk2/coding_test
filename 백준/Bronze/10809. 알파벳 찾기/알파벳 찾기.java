import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // -1로 된 알파벳 배열 갯수 26개 생성
        int arr[] = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        //S 문자열 인덱스 설정
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            // arr에 매칭
            if (arr[ch - 'a'] == -1) {
                arr[ch-'a'] = i;
            }
        }
        // 출력
        for (int res : arr) {
            System.out.print(res + " ");
        }

    }
}
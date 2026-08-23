import java.util.Arrays;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        
        int N = input_string.length();
        int[] lonely_dict = new int[26];
        
        // 1. O(N)
        for (int i = 1; i < N; i++) {
            char cur = input_string.charAt(i);
            char prev = input_string.charAt(i-1);
            
            // 1-1. 현재와 이전이 다르면 이전문자열 추가
            if (cur != prev) {
                lonely_dict[prev - 'a']++;
            }
            
            // 1-2. 마지막 인덱스일때 둘다 다르면? || 마지막 인덱스일 때, 맨뒤에 2개만 같고, 3번째가 다르면? -> 마지막만 추가
            if ( (i == N-1 && cur != prev) || (i == N-1 && cur == prev && prev != input_string.charAt(i-2)) ) {
                lonely_dict[cur - 'a']++;
            }
        }
        
        // 2. 결과
        for (int i = 0; i < 26; i++) {
            if (lonely_dict[i] >= 2) {
                char temp = (char) ('a' + i);
                answer += temp;
            }
        }
        
        if (answer == "") return "N";
        return answer;
    }
}
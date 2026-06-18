class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        // 0. 0을 제거한 총갯수, 이진변환 총횟수
        int total_cnt_zero = 0;
        int total_round = 0;
        
        // 1. 검사 
        while (true) {
            // 1-1. s의 길이가 1이면 종료
            if (s.length() == 1) break;
            
            // 1-2. 제거할 0의 갯수 세기
            int temp_cnt_zero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') temp_cnt_zero++;
            }
            total_cnt_zero += temp_cnt_zero;
            
            // 1-3. 0 제거후 길이
            int cur_leng = s.length() - temp_cnt_zero;
            
            // 1-4. 이진변환
            int power = 1;
            while (true) {
                // 1-5. 만약 2^{power-1} 까지가 cur_leng보다 작다면 정지
                if (power * 2 > cur_leng) break;
                
                // 1-6. 그렇지 않다면
                power *= 2;
            }
            
            // 1-7. cur_leng을 이진변환
            String new_s = "";
            while (true) {
                // 1-8. power == 0 이면 종료
                if (power == 0) break;
                
                // 1-9. cur_leng이 power보다 크면
                if (cur_leng >= power) {
                    cur_leng -= power;
                    new_s += 1;
                    power /= 2;
                    continue;
                }
                // 1-10. 그렇지않으면 
                new_s += 0;
                power /= 2;
                
            }
            // 1-11. new_s 갱신
            s = new_s;
            
            // 1-12. total_round 갱신
            total_round++;   
        }
        
        // 2. 답 추가
        answer[0] = total_round;
        answer[1] = total_cnt_zero;
        return answer;
    }
}
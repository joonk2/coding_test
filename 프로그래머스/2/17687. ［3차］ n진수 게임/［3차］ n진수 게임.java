class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String temp = "";
        int num = 0;
        
        while (num < (m*t) + 1) {
            StringBuilder sb = new StringBuilder();
            int temp_num = num;
            if (temp_num == 0) {
                sb.append(num);
            }
            
            while (temp_num > 0) {
                int remain = temp_num % n;
                if (remain == 10) sb.append("A");
                else if (remain == 11) sb.append("B");
                else if (remain == 12) sb.append("C");
                else if (remain == 13) sb.append("D");
                else if (remain == 14) sb.append("E");
                else if (remain == 15) sb.append("F");
                else sb.append(remain);
                
                temp_num /= n;
            }
            
            // 추가
            temp += sb.reverse().toString();
            
            // 다음으로 전환
            num++;
        }
        
        int idx = p-1;
        int cnt = 0;
        while (cnt < t) {
            int index = idx + (cnt * m);
            char ch = temp.charAt(index);
            answer += ch;
            cnt++;
        }
        
        
        return answer;
    }
}
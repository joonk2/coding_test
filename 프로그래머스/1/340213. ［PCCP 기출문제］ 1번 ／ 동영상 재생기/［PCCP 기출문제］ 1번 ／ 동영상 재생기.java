class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int N = commands.length;
        
        
        // 비디오 길이 
        String[] s1 = video_len.split(":");
        int[] end = new int[2];
        end[0] = Integer.parseInt(s1[0]);
        end[1] = Integer.parseInt(s1[1]);
        int total_seconds = (end[0] * 60) + end[1];
        
        
        // 현재 시간
        String[] s2 = pos.split(":");
        int[] cur_time = new int[2];
        cur_time[0] = Integer.parseInt(s2[0]);
        cur_time[1] = Integer.parseInt(s2[1]);
        int cur_seconds = (cur_time[0] * 60) + cur_time[1];
        
        
        // 오프닝 시작
        String[] op_1 = op_start.split(":");
        int[] op_s = new int[2];
        op_s[0] = Integer.parseInt(op_1[0]);
        op_s[1] = Integer.parseInt(op_1[1]);
        int opening_start = (op_s[0] * 60) + op_s[1];
      
        
        // 오프닝 끝
        String[] op_2 = op_end.split(":");
        int[] op_e = new int[2];
        op_e[0] = Integer.parseInt(op_2[0]);
        op_e[1] = Integer.parseInt(op_2[1]);
        int opening_end = (op_e[0] * 60) + op_e[1];
        

        // 오프닝 구간에 겹치는지 먼저 확인
        if (opening_start <= cur_seconds && cur_seconds <= opening_end) {
            cur_seconds = opening_end;
        }
        
        
        int i = 0;
        while (i < N) {
            // 현재 명령어
            String cmd = commands[i];
            
            // next
            if (cmd.equals("next")) {
                if (total_seconds - cur_seconds < 10) {
                    cur_seconds = total_seconds;
                }
                else if (total_seconds - cur_seconds >= 10) {
                    cur_seconds += 10;
                }
            }
            // prev
            else if (cmd.equals("prev")) {
                if (cur_seconds - 10 < 0) {
                    cur_seconds = 0;
                }
                else if (cur_seconds - 10 >= 0) {
                    cur_seconds -= 10;
                }
            }
            
            // 오프닝 구간에 겹치나 확인
            if (opening_start <= cur_seconds && cur_seconds <= opening_end) {
                cur_seconds = opening_end;
            }
            
            
            // 다음으로 전환
            i++;
        }

        
        
        
        // 정답
        int h = cur_seconds / 60;
        int s = cur_seconds % 60;
        
        String final_h = "";
        String final_s = "";
        
        if (h < 10) {
            final_h += "0";
            final_h += h;
        }
        else if (h >= 10) {
            final_h += h;
        }
        
        answer += final_h;
        answer += ":";
        
        if (s < 10) {
            final_s += "0";
            final_s += s;
        }
        else if (s >= 10) {
            final_s += s;
        }
        answer += final_s;
        
        return answer;
    }
}
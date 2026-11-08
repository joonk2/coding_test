import java.util.Stack;
import java.util.Arrays;


class Solution {
    public String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        
        Stack<int[]> my_stack = new Stack<>();
        
        int[][] lst = new int[N][3];
        for (int i = 0; i < N; i++) {
            int idx = i;
            String h_m = plans[i][1];
            int h = Integer.parseInt(h_m.split(":")[0]);
            int m = Integer.parseInt(h_m.split(":")[1]);
            int duration = Integer.parseInt(plans[i][2]);
            lst[i][0] = idx;
            lst[i][1] = (h*60) + m;
            lst[i][2] = duration;
        }
        
        // 1. 빨리 시작하는 순서로 정렬
        Arrays.sort(lst, (a,b) -> {
            return Integer.compare(a[1], b[1]);
        });

        
        int answer_idx = 0;
        // 2. 초기 1회차 숙제 시간 적용
        for (int i = 0; i < N-1; i++) {
            
            // 2-1 현재 진행중인 숙제에 남은 시간 합쳐도 다음 숙제 시작시간보다 늦으면?
            int[] cur = lst[i];
            int[] next = lst[i+1];
            int cur_idx = cur[0];
            int cur_start = cur[1];
            int cur_duration = cur[2];
            int next_start = next[1];
            if (next_start < cur_start + cur_duration) {
                
                // 2-1-a. 현재 이어서 시작할 시각 변경
                lst[i][1] = next_start;
                
                // 2-1-b. 현재 남은시간 변경
                lst[i][2] -= (next_start - cur_start);
                
                // 2-1-c. 스택에 추가
                my_stack.push(new int[] {cur_idx, lst[i][1], lst[i][2]});
            }
            // 2-2 그렇지않고, 다음숙제시간 >= (현재 진행할 숙제시간 + 남은시간) 일때
            else if (next_start >= cur_start + cur_duration) {
                
                // 2-2-a. 현재 과제 완료
                int subject_idx = cur[0];
                answer[answer_idx] = plans[subject_idx][0];
                answer_idx++;
                
                // 2-2-b. 다음 과제 시작까지 남은 시간
                int remain_time = next_start - (cur_start + cur_duration);
                
                // 2-2-c. 중단된 과제 재개
                while (!my_stack.isEmpty() && remain_time > 0) {
                    int[] stopped = my_stack.pop();
                    int sub_idx = stopped[0];
                    int sub_start = stopped[1];
                    int dur = stopped[2];

                    // 2-2-d. 남은 시간안에 과제 완료 가능하면?
                    if (remain_time >= dur) {
                        remain_time -= dur;
                        answer[answer_idx] = plans[sub_idx][0];
                        answer_idx++;
                    }
                    // 2-2-e. 그렇지않고, 남은 시간안에 과제 완료 불가능하면? -> 일부만 하자
                    else if (remain_time < dur) {
                        dur -= remain_time;
                        my_stack.push(new int[] {sub_idx, sub_start, dur});
                        break;
                    }
                    
                }
                
            }
        }
        
        // 3. 마지막 과목 처리
        int[] last = lst[N-1];
        int last_idx = last[0];
        answer[answer_idx] = plans[last_idx][0];
        answer_idx++;
        
        // 4. 스택에 남은거 처리
        while (!my_stack.isEmpty()) {
            int[] cur = my_stack.pop();
            
            int cur_idx = cur[0];
            answer[answer_idx] = plans[cur_idx][0];
            answer_idx++;
        }
        
        
        
        
        return answer;
    }
}
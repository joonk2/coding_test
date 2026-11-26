import java.util.Set;
import java.util.HashSet;



class Solution {
    static boolean found = false;
    
    static Set<int[]> res_o = new HashSet<>();
    static Set<int[]> res_x = new HashSet<>();
    
    static int[][][] check = {
        // ㅡ
        { {0,0}, {0,1}, {0,2} },
        { {1,0}, {1,1}, {1,2} },
        { {2,0}, {2,1}, {2,2} },
        
        // |
        { {0,0}, {1,0}, {2,0} },
        { {0,1}, {1,1}, {2,1} },
        { {0,2}, {1,2}, {2,2} },
        
        // \
        { {0,0}, {1,1}, {2,2} },
        
        // /
        { {0,2}, {1,1}, {2,0} },
    };
    
    
    public int solution(String[] board) {
        int answer = 0;
        int N = 0;
        
        char[][] res_arr = new char[3][3];
        for (int r = 0; r < 3; r++) {
            String cols = board[r];
            for (int c = 0; c < 3; c++) {
                res_arr[r][c] = cols.charAt(c);
                char cur = res_arr[r][c];
                if (cur == 'O') {
                    res_o.add(new int[] {r, c});
                    N++;
                }
                else if (cur == 'X') {
                    res_x.add(new int[] {r, c});
                    N++;
                }
            }
        }
        
        // 1. 내 틱택토 저장할 공간
        Set<int[]> my_o = new HashSet<>();
        Set<int[]> my_x = new HashSet<>();
        char[][] my_arr = new char[3][3];  
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                my_arr[r][c] = '.';
            }
        }       
        
        // 2. 조기 검사
        int sum_o = 0;
        int sum_x = 0;
        if (N % 2 == 0) {
            int mod = N / 2;
            sum_o += mod;
            sum_x += mod;
        }
        else if (N % 2 == 1) {
            int mod = N / 2;
            sum_o += mod;
            sum_x += mod;
            sum_o++;
        }
        
        if (sum_o != res_o.size() && sum_x != res_x.size()) {
            return 0;
        }
        
        
        
        // 3. 백트랙킹
        int idx = 0;
        back_tracking(idx, N, my_arr, my_o, my_x, res_arr);
        
        // 6. 답
        if (!found) answer = 0;
        else answer = 1;
        return answer;
    }
    
    
    
    // 4. 함수 (백트랙킹)
    static void back_tracking(int idx, int N, char[][] my_arr, Set<int[]> my_o, Set<int[]> my_x, char[][] res_arr) {
        
        // 4-1. 답 찾았으면 끝
        if (found) return;
        
        // 4-2. 끝점 도달시
        if (idx == N) {
            int cnt_o = 0;
            int cnt_x = 0;
            int total_o = res_o.size();
            int total_x = res_x.size();
            for (int[] i : my_o) {
                for (int[] j : res_o) {
                    if (i[0] == j[0] && i[1] == j[1]) cnt_o++;
                }
            }
            for (int[] i : my_x) {
                for (int[] j : res_x) {
                    if (i[0] == j[0] && i[1] == j[1]) cnt_x++;
                }
            }
            
            
            if (cnt_o == total_o && cnt_x == total_x)  {
                found = true;
            }
            return;
        }
        
        
        
        // 4-3. 만약 (5개 이상 && 끝점 도달전에 빙고 발생시, 해당 분기만 종료)
        if (idx >= 5 && is_one_of_them_bingo(my_o, my_x)) {
            return;
        }
        

        
        
        // 4-4. 위 경우가 아니라면 (선O, 후X)
        if (idx % 2 == 0) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (my_arr[r][c] != '.') continue;
                    my_arr[r][c] = 'O';
                    int[] pos = new int[] {r, c};
                    my_o.add(pos);
                    back_tracking(idx + 1, N, my_arr, my_o, my_x, res_arr);
                    my_arr[r][c] = '.';          
                    my_o.remove(pos);
                }
            }
        }
        else if (idx % 2 == 1) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (my_arr[r][c] != '.') continue;
                    my_arr[r][c] = 'X';
                    int[] pos = new int[] {r, c};
                    my_x.add(pos);
                    back_tracking(idx + 1, N, my_arr, my_o, my_x, res_arr);
                    my_arr[r][c] = '.';          
                    my_x.remove(pos);
                }
            }
        }
        
        
    }
    
    
    // 5. 함수 (내 o,x중 하나는 빙고인가?)
    static boolean is_one_of_them_bingo(Set<int[]> my_o, Set<int[]> my_x) {
        boolean is_o_bingo = false;
        boolean is_x_bingo = false;
        
        // 5-1. 내 o 확인
        int M = check.length;
        int total_cnt = 3;
        for (int i = 0; i < M; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j ++) {
                int[] cur_pos = check[i][j];
                int cur_r = cur_pos[0];
                int cur_c = cur_pos[1];
                for (int[] k : my_o) {
                    int temp_r = k[0];
                    int temp_c = k[1];
                    if (cur_r == temp_r && cur_c == temp_c) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == 3) {
                is_o_bingo = true;
                break;
            }
        }
        

        
        
        // 5-2. 내 x 확인
        for (int i = 0; i < M; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j ++) {
                int[] cur_pos = check[i][j];
                int cur_r = cur_pos[0];
                int cur_c = cur_pos[1];
                for (int[] k : my_x) {
                    int temp_r = k[0];
                    int temp_c = k[1];
                    if (cur_r == temp_r && cur_c == temp_c) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt == 3) {
                is_x_bingo = true;
                break;
            }
        }
        
        
        // 5-3. 둘중 하나라도 빙고면 
        if (is_o_bingo || is_x_bingo) return true;
        
        return false; 
    }
    
}
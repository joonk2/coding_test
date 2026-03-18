import java.util.Arrays;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int[] dr_diag = {-1,-1,1,1};
    static int[] dc_diag = {-1,1,-1,1};
    
    static int row, col;
    
    public int[] solution(String[][] places) {
        int T = places.length;
        int[] answer = new int[T];
        
        for (int t = 0; t < T; t++) {
            row = places[t].length;
            col = places[t][0].length();
            
            char[][] arr = new char[row][col];
            
            // 1. 배열 생성
            for (int r = 0; r < row; r++) {
                arr[r] = places[t][r].toCharArray();
            }
            
            // 2. 탐색
            boolean flag = false;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    // 2-1. 사람을 찾으면 -> 임마가 거리두기를 잘 지키나 확인
                    if (arr[r][c] == 'P') {
                        boolean is_detected = my_detector(r, c, arr);
                        // 2-2. 방역수칙 안지켜서 적발되면
                        if (is_detected) {
                            flag = true;
                            break;
                        }
                    }
                    // 2-3. 방역수칙 적발이미 되었으니 더 볼필요 없다
                    if (flag) break;
                }
                // 2-4. 마찬가지로 방역수칙 위반자 이미 적발되었으니 더 볼필요 없음
                if (flag) break;
            }
            
            // 3. 판별
            if (flag) {
                answer[t] = 0;
            }
            else if (!flag) {
                answer[t] = 1;
            }
            
        }
        return answer;
    }
    
    
    // 4. 방역수칙 조사원
    static boolean my_detector(int or, int oc, char[][] arr) {
        // 4-1. 상하좌우
        boolean is_partition;
        for (int d = 0; d < 4; d++) {
            is_partition = false;
            int cr = or;
            int cc = oc;
            for (int x = 0; x < 2; x++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 4-1-a 범위 밖 -> skip
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 4-1-b 범위 내
                // 만약에 파티션이 다음 좌표네?
                if (arr[nr][nc] == 'X') {
                    is_partition = true;
                }
                // 그렇지 않고, 다음좌표가 사람이야
                else if (arr[nr][nc] == 'P') {
                    // 그런데 파티션이 없다 -> 임마 바로 검거
                    if (!is_partition) {
                        return true;
                    }
                }
                // 4-1-c 좌표 갱신
                cr = nr;
                cc = nc;  
            }
        }
        
        // 4-2. 대각선
        for (int d = 0; d < 4; d++) {
            int nr = or + dr_diag[d];
            int nc = oc + dc_diag[d];
            
            // 4-2-a 범위 밖 -> skip
            if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
            
            // 4-2-b 범위 안
            // 만약에 다음좌표갸 사람이라면?
            if (arr[nr][nc] == 'P') {
                // 두 곳중 한곳이라도 파티션이 없다면 --> 검거
                if ( (arr[or][nc] != 'X') || (arr[nr][oc] != 'X') ) return true;
            }
        }
        
        
        
        // 4-3. 별일 없으면 정상으로 판별
        return false;
    }
    
    
}
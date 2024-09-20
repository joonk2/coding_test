# https://www.youtube.com/watch?v=O8K5A9ojrVw
# 1. 문제를 읽고 입출력 예제를 통해서 먼저 풀어본다
# 2. bfs(시작, 끝) 그리고 q와 v 생성
# 3. q에 시작 넣어주고 초기데이터 1로 설정
# 4. 큐가 차있을 동안, 들어있는거 1개 뺀 것을 현재 위치로 저장
# 5. 3방향 ( c-1, c+1, c*2 ), 만약 범위내 (0 <=   <= 200000), 다음 좌표가 미방문이라면?
# 6. q에 다음좌표 삽입, v[next] = v[c] + 1
# 7. 4번에 만약 현재 좌표가 끝이랑 같다면 v[e]-1로 return 해주자
# 8. 디버깅용으로 return -1 적어주자

from collections import deque

def bfs(s, e):
    q = deque([])
    v = [0] * 200001

    q.append(s)
    v[s] = 1

    min_time = 0

    while q:
        c = q.popleft()
        if c == e:
            min_time = v[c]-1
            return min_time
        
        # 3방향 범위내(0~200000), 미방문
        for next in (c-1, c+1, c*2):
            if 0 <= next <= 200000:
                if v[next] == 0:
                    q.append(next)
                    v[next] = v[c]+1

    # 디버깅용(만약 -1이 나오면 땡)
    return -1

N, K = map(int, input().split())
ans = bfs(N, K)
print(ans)

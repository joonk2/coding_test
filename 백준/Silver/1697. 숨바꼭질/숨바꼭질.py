# https://www.youtube.com/watch?v=O8K5A9ojrVw

# 1. 문제를 읽고 입출력 예제를 통해서 먼저 풀어본다
# 2. bfs(시작, 끝) 그리고 q와 v 생성
# 3. q에 시작 넣어주고 초기데이터 1로 설정
# 4. 큐가 차있을 때, 들어있는거 1개 빼기
# 5. 3방향 ( c-1, c+1, c*2 ), 범위내 (0 <=   <= 200000), 미방문
# 6. q삽입, v[next] = v[c] + 1
# 7. 4번에 만약 현재 좌표가 끝이랑 같다면 끝좌표 -1로 return 해주자


def bfs(s, e):

    # 2
    q = []
    v = [0] * 200001

    # 3
    q.append(s)
    v[s] = 1

    while q:
        c = q.pop(0)
        if c == e:
            return v[e]-1
        
        # 3방향 범위내(0~200000), 미방문
        for n in (c-1, c+1, c*2):
            if  0 <= n <= 200000 and v[n] == 0:
                q.append(n)
                v[n] = v[c]+1

    # 디버깅용(만약 -1이 나오면 땡)
    return -1

N, K = map(int, input().split())
ans = bfs(N, K)
print(ans)

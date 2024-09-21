# 수빈이만 동생을 찾는 것이니 범위는 당연히 100000
# 모든 이동은 연결되는 if - elif 가 아닌 독립적인 if if if으로 진행

# 시간이 전부 `1초 후에`로 같다면 next node 쓴다
# 근데 여긴 시간이 0초, 1초, 1초 라서 next node 필요없다
# --> 개별 처리 if if if

from collections import deque

def bfs(s, e):
    v = [0] * 100001
    q = deque([])
    q.append(s)
    v[s] = 1

    min_time = 0
    while q:
        c = q.popleft()
        if c == e:
            min_time = v[c]-1
            return min_time
        
        # 순간이동 (우선처리)
        if 0 <= c*2 <= 100000:
            if v[c*2] == 0:
                q.appendleft(c*2) # 텔레포트는 먼저 처리
                v[c*2] = v[c] # 시간이 증가하지 않음

        # 뒤로 이동
        if 0 <= c-1 <= 100000:
            if v[c-1] == 0:
                q.append(c-1)
                v[c-1] = v[c]+1

        # 앞으로 이동
        if 0 <= c+1 <= 100000:
            if v[c+1] == 0:
                q.append(c+1)
                v[c+1] = v[c]+1

    return "이 글 나오면 니 로직 땡"




N, K = map(int, input().split())
min_time = bfs(N, K)
print(min_time)

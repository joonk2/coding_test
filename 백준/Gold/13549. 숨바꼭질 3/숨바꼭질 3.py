# 수빈이만 동생을 찾는 것이기 때문에 범위는 당연히 100000

from collections import deque

def bfs(s, e):
    q = deque([s])
    v = [0] * 100001  
    v[s] = 1  

    min_time = 0 
    while q:
        c = q.popleft()
        
        if c == e:
            min_time = v[c]-1
            return min_time  

        # 텔레포트 먼저 처리 (시간 0초)
        if 0 <= c*2 <= 100000:
            if v[c*2] == 0:
                v[c*2] = v[c]  # 시간이 증가하지 않음
                q.appendleft(c * 2)  # 텔레포트는 먼저 처리

        # 뒤로 이동 (시간 1초)
        if 0 <= c-1 <= 100000:
            if v[c-1] == 0:
                v[c-1] = v[c]+1
                q.append(c-1)

        # 앞으로 이동 (시간 1초)
        if 0 <= c+1 <= 100000:
            if v[c+1] == 0:
                v[c+1] = v[c] + 1
                q.append(c+1)



def upsidedown_path(s, e, shortcut):
    way = []
    c = e
    while c != s:
        way.append(c)
        c = shortcut[c] # 역추적
    way.append(s)

    return way[::-1]





N, K = map(int, input().split())
min_time = bfs(N, K)

print(min_time)

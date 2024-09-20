# 1.  만약 현재위치랑 목적지 위치 같을때, 방문 처리에서 +1 했으므로 min_time에서 다시 1 빼줌
# 2. case 1) 첫방문
# 3. case 2) 재방문


from collections import deque

def bfs(s, e):
    q = deque([])
    v = [0] * 100001
    q.append(s)
    v[s] = 1
    
    min_time = 0
    cnt_shortcut = 0
    

    while q:
        c = q.popleft()
        if c == e:
            min_time = v[c]-1
            cnt_shortcut += 1
            continue
        
        for next in (c-1, c+1, c*2):
            if 0 <= next <= 100000:

                # 처음 방문시
                if v[next] == 0:
                    q.append(next)
                    v[next] = v[c] + 1

                # 이미 방문했지만 다른 루트를 통해서도 같은 시간이 걸려서 도달했을 때
                elif v[next] == v[c] + 1:
                    q.append(next)

    return min_time, cnt_shortcut



N, K = map(int, input().split())
min_time, cnt_shortcut = bfs(N, K)
print(min_time)
print(cnt_shortcut)

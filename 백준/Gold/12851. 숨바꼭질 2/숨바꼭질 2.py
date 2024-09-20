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
                if v[next] == 0:
                    q.append(next)
                    v[next] = v[c] + 1
                
                elif v[next] == v[c] + 1:
                    q.append(next)

    return min_time, cnt_shortcut

N, K = map(int, input().split())
min_time, cnt_shortcut = bfs(N, K)
print(min_time)
print(cnt_shortcut)